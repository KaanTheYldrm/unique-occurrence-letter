package exception;

public class MissingPathArgumentException extends Exception {

    private static String message = "Please specify path";

    public MissingPathArgumentException() {
        super(message);
    }
}

