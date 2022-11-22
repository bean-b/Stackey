package builtInMethods;
import java.util.Scanner;
import src.*;
public class In extends Method{
    public In(String s) {
        super(s);
    }

    @Override
    public void run(Parser parser) {
        switch(name){
            case("input"):{
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                if(Helper.isInteger(line)){
                    parser.push(new Data(Data.Type.INT, Integer.valueOf(line)));
                }else{
                    parser.push(new Data(Data.Type.STRING, line));
                }
                sc.close();
                break;
            }
        }
    }
}
