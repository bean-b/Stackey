package src;
public abstract class Method{
    protected String name;
    protected Method(String s){
        name = s;
    }


    public void run(Parser p) {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public void setName(String s){
        name = s;
    }
    
}
