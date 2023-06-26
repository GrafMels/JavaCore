public class ColumnMismatchException extends Exception{
    public ColumnMismatchException(String message) {
        super("Column conversion exception: " + message);
    }

    public ColumnMismatchException(int expected, int current, String value) {
        super(String.format("Column conversion exception: expected %d column. Received %d column in %s string.", expected, current, value));
    }

    public ColumnMismatchException(int expected, int current) {
        super(String.format("Column conversion exception: expected %d column. Received %d column.", expected, current));
    }
}


