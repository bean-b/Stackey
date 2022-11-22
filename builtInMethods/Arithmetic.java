package builtInMethods;

import src.*;

public class Arithmetic extends Method{

    public Arithmetic(String s) {
        super(s);
    }


    @Override
    public void run(Parser parser) {
        parser.checkSize(2);
        Data d1 = parser.pop();
        switch(name){
            case("++"):{
                if(d1.getGetType() == Data.Type.INT){
                    parser.push(new Data(Data.Type.INT, (Integer)d1.getData()+1));
                }else{
                    throw new Error("invalid args, expected ints" + name);
                }
                return;
            }
            case("--"):{
                if(d1.getGetType() == Data.Type.INT){
                    parser.push(new Data(Data.Type.INT, (Integer)d1.getData()-1));
                }else{
                    throw new Error("invalid args, expected ints" + name);
                }
                return;
            }
        }
        Data d2 = parser.pop();
        
        if(d1.getGetType() == Data.Type.INT && d2.getGetType() == Data.Type.INT){
            int result = 0;
            int num1 = (Integer) d1.getData();
            int num2 = (Integer) d2.getData();
            switch(name){
                case("+"):{
                    result = num2 + num1;
                    break;
                }
                case("-"):{
                    result = num2 - num1;
                    break;
                }
                case("*"):{
                    result = num2 * num1;
                    break;
                }
                case("/"):{
                    result = num2 / num1;
                    break;
                }
                case("%"):{
                    result = num2 % num1;
                    break;
                }
                case("^"):{
                    result = (int) Math.pow(num2, num1);
                    break;
                }
            }
            parser.push(new Data(Data.Type.INT, result));
        }else if(d1.getGetType() == Data.Type.STRING && d2.getGetType() == Data.Type.STRING && name.equals("+")){
            String result = "";
            if(name.equals("+")){
                String arg1 = (String) d1.getData();
                String arg2 = (String) d2.getData();
                result = arg2 + arg1;
                parser.push(new Data(Data.Type.STRING, result));
            }
        }else{
            throw new Error("invalid args, expected ints" + name);
        }

    }
    
}
