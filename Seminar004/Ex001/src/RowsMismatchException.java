public class RowsMismatchException extends Exception{
    public RowsMismatchException(String message) {
        super(String.format("String conversion exception: %s", message));
    }

    public RowsMismatchException(int expected, int current, String value) {
        super(String.format("Rows conversion exception: expected %d rows. Received %d rows in %s string.", expected, current, value));
    }

    public RowsMismatchException(int expected, int current) {
        super(String.format("Rows conversion exception: expected %d rows. Received %d rows.", expected, current));
    }
}
