package builtInMethods;
import src.*;

public class Iterator extends Method{
    public Iterator(String s) {
        super(s);
    }


    @Override
    public void run(Parser parser) {
        switch(name){
            case("range"):{
                parser.checkSize(2);
                Data d1 = parser.pop();
                Data d2 = parser.pop();
                for(int i=(Integer)d1.getData(); i<(Integer)d2.getData(); i++){
                    parser.push(new Data(Data.Type.INT, i));
                }
                break;
            }
        }
    }
}
