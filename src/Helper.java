package src;

public class Helper {
    public static boolean isInteger(String s){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
