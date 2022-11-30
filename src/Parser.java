package src;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import builtInMethods.*;
import builtInMethods.Out;

public class Parser {
    private Stack<Data> theStack;
    private Scanner sc;
    private HashMap<String, Method> methodMap;
    private HashMap<String, Data> variableMap;
    private PrintStream printStream;
    private Stack<Integer> resetPositions;
    private int curLine = 1;

    public Parser(PrintStream printStream){
        this.printStream = printStream;
        theStack = new Stack<>();
        methodMap = new HashMap<>();
        variableMap = new HashMap<>();
        resetPositions = new Stack<>();
        addInBuiltMethods();
        sc = new Scanner(System.in);
    }

    public void Interpret(List<String> data){
        makeToStack(data);
    }

    private void addInBuiltMethods() {
        String[] arithmetics = new String[]{"+", "-", "*", "^", "/", "%", "++", "--"};
        for(String s : arithmetics) {
            methodMap.put(s, new Arithmetic(s));
        }
        
        String[] stackManipulations = new String[]{"remove", "duplicate", "sizeOfStack"};
        for(String s : stackManipulations) {
            methodMap.put(s, new StackManipulation(s));
        }

        methodMap.put("print", new Out("print"));
        methodMap.put("println", new Out("println"));
        methodMap.put("input", new In("input"));
        methodMap.put("range", new Iterator("range"));
        methodMap.put("for", new FlowControl("for"));
        methodMap.put("goTo", new FlowControl("goTo"));
    }

    private void makeToStack(List<String> data){
        for(curLine=0; curLine<data.size();){
            String curStr = data.get(curLine);
            
            if(curStr.length() == 0){
                throw new Error("can't read empty string");
            }

            int curLine2 = parseString(curStr);
            if(curLine == curLine2){
                curLine++;
            }else{
                curLine = curLine2;
            }
            
        }
    }
    
    public int parseString(String curStr){
        String bodyText = curStr.substring(1,curStr.length());
        switch(curStr.substring(0,1)){
            case("#"):{
                break;
            }
            case("."):{
                if(methodMap.containsKey(bodyText)){
                    methodMap.get(bodyText).run(this);
                }else{
                    throw new Error("no method named " + bodyText);
                }
                break;
            }

            case(">"):{
                variableMap.put(bodyText, theStack.pop());
                break;
            }

            case("<"):{
                if(variableMap.containsKey(bodyText)){
                    push(variableMap.get(bodyText));
                }else{
                    throw new Error("invalid variable name: " + bodyText);
                }
                break;
            }
            
            case("{"):{
                break;
            }

            case("}"):{
                if(resetPositions.size() > 0){
                    return resetPositions.pop();
                }
                break;
            }

            case("\""):{
                push(new Data(Data.Type.STRING, bodyText));
                break;
            }

            default:{
                if(Helper.isInteger(curStr)){
                    push(new Data(Data.Type.INT, Integer.valueOf(curStr)));
                }else{
                    throw new Error("attempting to read" + curStr + "as an int that isn't an int");
                }
            }
        }
        return curLine;
    }

    public void push(Data n){
        theStack.push(n);
    }

    public Data pop(){
        return theStack.pop();
    }

    public void checkSize(int n){
        if(theStack.size() < n-1){
            throw new Error("attempting to read" + (n-1) + " times from a stack of size " + theStack.size());
        }
    }

    public void out(Data d1, boolean println) {
        if(println){
            printStream.println(d1.getData());
        }else{
            printStream.print(d1.getData());
        }
    }

    public void nextMethodDuplicate(Integer resetPos, int numTimes) {
        for(int i=0; i<numTimes; i++){
            resetPositions.add(resetPos);
        }
    }

    public int stackSize() {
        return theStack.size();
    }

    public void setCurLine(int n){
        curLine = n;
    }

    public String getInput(){
        String input = sc.nextLine();
        return input;
    }

    public void close(){
        sc.close();
    }
    public int getCurLine(){
        return curLine;
    }
}
