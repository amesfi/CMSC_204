public class StackUnderflowException extends Exception {
    public StackUnderflowException() {
        super("Stack underflow: The stack is empty.");
    }

    public StackUnderflowException(String message) {
        super(message);
    }
}