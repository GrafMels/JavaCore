public class Main {
    static FullArrays arrays = new FullArrays(2, 5, 5);
    public static void main(String[] args){


        try {
            if (true){//Значение true это без ошибок а значение false это с ошибкой AmountException
                arrays.getOrderList()[0] = buildOrder(arrays.getCustomersList()[0], arrays.getProductsList()[0], 10);
            }else {
                arrays.getOrderList()[0] = buildOrder(arrays.getCustomersList()[0], arrays.getProductsList()[0], -10);
            }

            if (true){// с ошибкой CustomerException
                arrays.getOrderList()[1] = buildOrder(arrays.getCustomersList()[1], arrays.getProductsList()[1], 20);
            }else {
                arrays.getOrderList()[1] = buildOrder(new Customer("ss", "20.03.1983", 89085587623L), arrays.getProductsList()[1], 20);
            }

            if (true){// с ошибкой ProductException
                arrays.getOrderList()[2] = buildOrder(arrays.getCustomersList()[0], arrays.getProductsList()[2], 30);
            }else {
                arrays.getOrderList()[2] = buildOrder(arrays.getCustomersList()[0], new Product("Gus", 123, true), 30);
            }
            arrays.getOrderList()[3] = buildOrder(arrays.getCustomersList()[1], arrays.getProductsList()[3], 40);
            arrays.getOrderList()[4] = buildOrder(arrays.getCustomersList()[0], arrays.getProductsList()[4], 50);

        } catch (CustomerException e) {
            throw new CustomerException(e.getMessage());
        } catch (ProductException e) {
            e.printStackTrace();
        } catch (AmountException e) {
            arrays.getOrderList()[0] = buildOrder(arrays.getCustomersList()[0], arrays.getProductsList()[0], 10);
        }

        try {
            arrays.getProductsList()[4].pushDiscount(false);//Если хотите вызвать эту ошибку передайте true
        } catch (TooMuchSaleException e) {
            e.printStackTrace();
        }

        System.out.println(arrays);
    }

    private static Order buildOrder(Customer customer, Product product, int count) throws CustomerException, ProductException, AmountException {

        boolean hasCustomer = false;
        for (int i = 0; i < arrays.getCustomersList().length; i++) {
            if (arrays.getCustomersList()[i].equals(customer)){
                hasCustomer = true;
            }
        }
        if (!hasCustomer){
            throw new CustomerException("That customer does not exist.");
        }

        boolean hasProduct = false;
        for (int i = 0; i < arrays.getProductsList().length; i++) {
            if (product.equals(arrays.getProductsList()[i])){
                hasProduct = true;
            }
        }
        if (!hasProduct){
            throw new ProductException("That product does not exist.");
        }

        if (product.getCount() < count){
            if (product.getCount()>0){
                count = 1;
                product.minusCount(count);
            }else {
                throw new AmountException(String.format("Wrong product quantity: expected x(quantity) <= %d. Received %d.", product.getCount(), count));
            }
        } else if (count < -1) {
//            throw new AmountException(String.format("Wrong product quantity: expected x(quantity) > 0. Received %d.", count));
            count = 1;
            product.minusCount(count);
        }else {
            product.minusCount(count);
        }

        return new Order(customer, product, count);
    }
}