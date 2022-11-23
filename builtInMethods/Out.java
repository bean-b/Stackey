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
        parser.out(d1, name.equals("println") ? true : false);
    }
}
