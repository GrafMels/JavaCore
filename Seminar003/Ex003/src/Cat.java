public class Cat {
    private static int countCat = 0;
    private int catId;
    private String name;


    public Cat(String name) {
        this.name = name;
        this.catId = ++countCat;
    }

    public static int getCountCat() {
        return countCat;
    }

    public static void minusCountCat() {
        countCat--;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
