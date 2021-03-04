package exception;

public class InvalidCharacterException extends Exception {

    private static String message = "The string value consists of only lowercase letters (a-z)";

    public InvalidCharacterException() {
        super(message);
    }
}
