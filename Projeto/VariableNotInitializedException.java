public class VariableNotInitializedException extends Exception {
    String message;
    VariableNotInitializedException(String message){
        super(message);
    }
}