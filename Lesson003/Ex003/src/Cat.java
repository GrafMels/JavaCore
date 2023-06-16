public class Cat {
    static int pawsCount = 4;
    String name;
    int age;
    String color;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public static int getPawsCount() {
        return pawsCount;
    }

    public static void setPawsCount(int pawsCount) {
        Cat.pawsCount = pawsCount;
    }
}
