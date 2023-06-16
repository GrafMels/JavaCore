import java.util.LinkedList;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<MyObject> myList = new LinkedList<>();
        for (int i = 0; i < 1000; i++){
            MyObject newObject = new MyObject(i);
            myList.add(newObject);
            System.out.println(newObject);
        }
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i).toString(i));
        }
    }
}