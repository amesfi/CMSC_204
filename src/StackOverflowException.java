public class StackOverflowException extends Exception {
    public StackOverflowException() {
        super("Stack overflow: The stack is full.");
    }

    public StackOverflowException(String message) {
        super(message);
    }
}