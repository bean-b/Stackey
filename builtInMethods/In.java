package builtInMethods;
import src.*;
public class In extends Method{
    public In(String s) {
        super(s);
    }

    @Override
    public void run(Parser parser) {
        switch(name){
            case("input"):{
                String input =  parser.getInput();
                if(Helper.isInteger(input)){
                    parser.push(new Data(Data.Type.INT, Integer.valueOf(input)));
                }else{
                    parser.push(new Data(Data.Type.STRING, input));
                }
                break;
            }
        }
    }
}
