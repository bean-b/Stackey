package builtInMethods;
import src.*;

public class StackManipulation extends Method{
    public StackManipulation(String s) {
        super(s);
    }

    @Override
    public void run(Parser parser) {
        switch(name){
            case("remove"):{
                parser.pop();
                break;
            }
            case("duplicate"):{
                Data d1 = parser.pop();
                parser.push(d1);
                parser.push(d1);
                break;
            }
            case("sizeOfStack"):{
                parser.push(new Data(Data.Type.INT, parser.stackSize()));
                break;
            }
        }
    } 
}
