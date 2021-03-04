package exception;

public class MinimumCharacterLengthException extends Exception {

    private static String message = "The minimum character number of the input line is 1";

    public MinimumCharacterLengthException() {
        super(message);
    }
}
