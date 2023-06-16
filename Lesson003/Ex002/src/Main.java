public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", "White", 5);
        Cat cat2 = cat1;
        cat2.color = "Black";
        System.out.println(cat1.color);//В переменной cat2 просто ссылка на обьект на который ссылка в cat1 поэтому изменяя cat2 мы изменяем и второю переменную
    }
}