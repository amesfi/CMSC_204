public class QueueUnderflowException extends Exception {
    public QueueUnderflowException() {
        super("Queue underflow: The queue is empty.");
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}