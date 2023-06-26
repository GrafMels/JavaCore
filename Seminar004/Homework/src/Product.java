import java.util.Random;

public class Product {
    private String title;
    private int salary;
    private int count = 100;
    private final int[] DISCOUNTS = new int[]{0, 5, 10, 15, 20};
    private Integer discount;
    private boolean isPremium;

    public Product(String title, int salary, boolean isPremium) {
        this.title = title;
        this.salary = salary;
        this.discount = DISCOUNTS[0];
        this.isPremium = isPremium;
    }

    public void pushDiscount(boolean isException) throws TooMuchSaleException {
        Random random = new Random();
        int newDiscount = DISCOUNTS[random.nextInt(3+1)+1];
        if (isException){
            this.isPremium = true;
            this.discount = 20;
        }
        if (isPremium && newDiscount >= 15){
            throw new TooMuchSaleException("Discount on premium products must be less than 15%");
        }
        if (discount != DISCOUNTS[0]){

            this.salary = (this.salary/100 - this.discount) * (100);
            this.discount = newDiscount;
            this.salary = (this.salary/100) * (100 - this.discount);
        }else {
            this.discount = newDiscount;
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
