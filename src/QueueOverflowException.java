public class QueueOverflowException extends Exception {
    public QueueOverflowException() {
        super("Queue overflow: The queue is full.");
    }

    public QueueOverflowException(String message) {
        super(message);
    }
}