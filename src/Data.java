package src;
public class Data{
    public static enum Type{STRING, INT};
    private Type type;
    private Object data;
    
    public Data(Type t, Object d){
        type = t;
        data = d;
    }
    public Type getGetType(){
        return type;
    }
    public Object getData(){
        return data;
    }
}
