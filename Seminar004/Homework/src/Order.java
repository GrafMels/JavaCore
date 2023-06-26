public class Order {
    private Customer customer;
    private Product product;
    private int count;

    public Order(Customer customer, Product product, int count) {
        this.customer = customer;
        this.product = product;
        this.count = count;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "\n\t\tOrder{" +
                "\n\t\t\tcustomer=" + customer.toStringInOrder() +
                ", \n\t\t\tproduct=" + product.toStringInOrder() +
                ", \n\t\t\tcount=" + count +
                '}';
    }
}
