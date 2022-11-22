package builtInMethods;
import src.*;

public class Out extends Method{
    private static final int ARGS = 1;
    public Out(String s) {
        super(s);
    }

    @Override
    public void run(Parser parser) {
        parser.checkSize(ARGS);
        Data d1 = parser.pop();
        boolean println = name.equals("println") ? true : false;
        parser.out(d1, println);
    }
}
