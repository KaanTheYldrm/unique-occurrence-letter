package exception;

public class MaximumCharacterLengthException extends Exception {

    private static String message = "The maximum character number of the input line is 300000";

    public MaximumCharacterLengthException() {
        super(message);
    }
}
