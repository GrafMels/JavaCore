import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static LinkedList<Cat> newList = new LinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            Cat newCat = new Cat(String.format("Murmur%d", i));
            newList.add(newCat);
        }
        deleteCat(5);
        deleteCat(15);
        deleteCat(43);
        deleteCat(33);

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i).getCatId());
        }
    }

    public static void deleteCat(int id){
        for (int i = 0; i < newList.size(); i++) {
            if (newList.get(i).getCatId() == id){
                newList.remove(i);
                Cat.minusCountCat();
            }
        }
    }
}