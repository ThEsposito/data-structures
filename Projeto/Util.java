public class Util {
    public static <T> boolean arrayContains(T[] arr, T value){
        for(T e: arr){
            if(e.equalsIgnoraCase(value)) return true;
        }
        return false;
    }

    public static boolean isNumber(String s){
        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))return false;
        }
        return true;
    }
}
