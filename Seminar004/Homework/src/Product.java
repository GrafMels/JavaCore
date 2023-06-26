public class Product {
    private String title;
    private int salary;
    private int count = 100;

    public Product(String title, int salary) {
        this.title = title;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
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
