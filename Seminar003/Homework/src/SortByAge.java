import java.util.Comparator;

public class SortByAge implements Comparator<Employee> {
    public int compare(Employee a, Employee b) {
        if (a.getAge() < b.getAge()) return -1;
        else if (a.getAge() == b.getAge()) return 0;
        else return 1;
    }
}