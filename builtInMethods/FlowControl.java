package builtInMethods;
import src.*;
public class FlowControl extends Method{

    public FlowControl(String s) {
        super(s);
    }
    @Override
    public void run(Parser parser) {
        switch(name){
            case("for"):{
                parser.checkSize(1);
                Data d1 = parser.pop();
                if(d1.getGetType() != Data.Type.INT){
                    throw new Error("Invalid args, expected int" + name);
                }
                parser.nextMethodDuplicate(parser.getCurLine()+1, (Integer)d1.getData()-1);
                break;
            }
            case("goTo"):{
                parser.checkSize(1);
                Data d1 = parser.pop();
                if(d1.getGetType() != Data.Type.INT){
                    throw new Error("Invalid args, expected int" + name);
                }
                parser.setCurLine((Integer)d1.getData()-1);
                break;
            }
        }
    } 
}
