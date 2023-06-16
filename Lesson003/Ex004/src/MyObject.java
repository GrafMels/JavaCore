import java.util.Random;

public class MyObject {
    private int number;
    public MyObject(int diff) {
        Random rd = new Random();
        number = rd.nextInt(diff + 1);
    }

    @Override
    public String toString() {
        return "Number = " + number;
    }

    public String toString(int Id) {
        return String.format("%d. Number = %d", Id, number);
    }
}
