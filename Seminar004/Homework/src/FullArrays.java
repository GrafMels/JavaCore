import java.util.Random;

public class FullArrays {
    private final Customer[] customersList;
    private final Product[] productsList;
    private final Order[] orderList;

    public Customer[] getCustomersList() {
        return customersList;
    }

    public Product[] getProductsList() {
        return productsList;
    }

    public Order[] getOrderList() {
        return orderList;
    }

    public FullArrays(int countCustomer, int countProduct, int countOrder) {
        String[] firstNames = new String[]{"Annie", "Donna", "Katherine", "David", "Gail", "Richard", "Jeanne", "James", "Joe", "Maxine"};
        String[] lastNames = new String[]{"Nelson", "Martinez", "Campbell", "Brooks", "Burke", "Mitchell", "Thomas", "Abbott", "Moran", "Brown"};
        String[] dates = new String[]{"20.09.1999", "10.11.1998", "29.12.2000", "01.01.2001", "08.06.1998", "09.03.2001", "02.02.2000", "09.11.2000", "20.12.2001", "02.05.1998"};
        Long[] phoneNumbers = new Long[]{79140711002L, 79148831781L, 79143211721L, 79148476281L, 79145335362L, 79145532448L, 79146994200L, 79144867689L, 79141375997L, 79145069457L};
        String[] titles = new String[]{"Blanched Vanilla Turkey", "Dried Egg & Beans Mutton", "Tenderized Apples & Mustard Quail", "Braised Sour Mutton", "Barbecued Sugar Venison", "Poached Rice & Boar", "Tea-Smoked Mustard Pork", "Breaded Coriander & Lemon Venison", "Blanched Wasabi Duck", "Beef Stroganoff"};
        int[] salary = new int[]{1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};

        customersList = new Customer[countCustomer];
        productsList = new Product[countProduct];
        orderList = new Order[countOrder];

        Random random = new Random();
        for (int i = 0; i < countCustomer; i++) {
            customersList[i] = new Customer(String.format("%s %s", firstNames[random.nextInt(9+1)], lastNames[random.nextInt(9+1)]), dates[random.nextInt(9+1)], phoneNumbers[random.nextInt(9+1)]);
        }

        for (int i = 0; i < countProduct; i++) {
            productsList[i] = new Product(titles[i%10], salary[random.nextInt(9+1)]);
        }
    }

    @Override
    public String toString() {
        return "Arrays{" +
                "\n\tcustomersList=" + java.util.Arrays.toString(customersList) +
                ", \n\tproductsList=" + java.util.Arrays.toString(productsList) +
                ", \n\torderList=" + java.util.Arrays.toString(orderList) +
                '}';
    }
}
