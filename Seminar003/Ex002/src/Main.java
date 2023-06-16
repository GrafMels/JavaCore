import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Main{
    public static void main(String[] args){
        LinkedList<Employee> newList = new LinkedList<>();
        Random random = new Random();
        String[] firstNames = {"Vasya", "Misha", "Jenya", "Timofei", "Ilya"};
        String[] lastName = {"Pupkin", "Ivanov", "Petrov", "Zvyagin", "Mur"};
        String[] jobTitle = {"Manager", "Engineer", "Machine worker", "Developer", "Tester"};

        newList.add(new Manager("Nikita", "Bogatov", "Senior Manager", 20000, 89145545345L+random.nextInt(1000000), String.format("12.12.%d", random.nextInt(20)+1970)));
        newList.add(new Manager("Viktor", "Vesovalov", "Senior Manager", 30000, 89145545345L+random.nextInt(1000000), String.format("12.12.%d", random.nextInt(20)+1970)));
        
        for (int i = 0; i < 5; i++) {
            newList.add(new Employee(firstNames[random.nextInt(5)], lastName[random.nextInt(5)], jobTitle[random.nextInt(5)], 2000+random.nextInt(10)*1000, 89145545345L+random.nextInt(1000000), String.format("12.12.%d", random.nextInt(20)+1980)));
        }

        //Задание 1
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
            Manager.salaryIncrease(1000, newList.get(i));
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
        //Задание 2 сортировка по возрасту
        Collections.sort(newList, new SortByAge());
        System.out.println();
        System.out.println();

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }

        //Задание 2 сортировка по зарплате
        Collections.sort(newList, new SortBySalary());
        System.out.println();
        System.out.println();

        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }

    }
}