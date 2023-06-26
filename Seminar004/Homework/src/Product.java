import java.util.Random;

public class Product {
    private String title;
    private int salary;
    private int count = 100;
    private final int[] DISCOUNTS = new int[]{0, 5, 10, 15, 20};
    private Integer discount;

    public Product(String title, int salary) {
        this.title = title;
        this.salary = salary;
        this.discount = DISCOUNTS[0];
    }

    public void pushDiscount(){
        Random random = new Random();
        if (discount != DISCOUNTS[0]){
            this.salary = (this.salary/100 - this.discount) * (100);
            this.discount = DISCOUNTS[random.nextInt(3+1)+1];
            this.salary = (this.salary/100) * (100 - this.discount);
        }else {
            this.discount = DISCOUNTS[random.nextInt(3+1)+1];
            this.salary = (this.salary/100) * (100 - this.discount);
        }
    }
    public int getCount(){
        return count;
    }

    public void minusCount(int count){
        this.count = this.count - count;
    }

    public void plusCount(){
        this.count = this.count + count;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "\n\t\tProduct{" +
                "\n\t\t\ttitle='" + title + '\'' +
                ", \n\t\t\tsalary=" + salary +
                ", \n\t\t\tcount=" + count +
                '}';
    }

    public String toStringInOrder() {
        return "\n\t\t\t\tProduct{" +
                "\n\t\t\t\t\ttitle='" + title + '\'' +
                ", \n\t\t\t\t\tsalary=" + salary +
                ", \n\t\t\t\t\tcount=" + count +
                '}';
    }
}
