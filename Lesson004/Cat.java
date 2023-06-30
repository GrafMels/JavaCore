package Lesson004;

public class Cat {
    private String name, color;
    private int age;
    private static String watsAnimal = "Cat";
    public Cat(){}
    public Cat(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }
    static class Voice{
        private final int volume;
        public Voice(int volume){
            this.volume = volume;
        }

        public void sayMur(){
            System.out.printf("A %s purrs with volume %d\n",watsAnimal , volume);
        }
    }
}
