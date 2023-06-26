package Objects;

import Objects.Customer;

public class Order {
    private Customer customer;
    private Product product;
    private int count;
    private int price;

    public Order(Customer customer, Product product, int count) {
        this.customer = customer;
        this.product = product;
        this.count = count;
        this.price = count * product.getSalary();
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "\n\t\tObjects.Order{" +
                "\n\t\t\tcustomer=" + customer.toStringInOrder() +
                ", \n\t\t\tproduct=" + product.toStringInOrder() +
                ", \n\t\t\tcount=" + count +
                ", \n\t\t\tprice=" + price +
                '}';
    }
}
