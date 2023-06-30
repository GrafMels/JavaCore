package Lesson004;

public class Ex004 {
    private static class Orange{
        public Orange(){
        } 

        public void squeezeJuice(){
            System.out.println("Squeeze juice...");
        }

        public class Juice{
            public void flow(){
                System.out.println("Juice dripped...");
            }
        }
    }
    public static void main(String[] args) {
        Orange orange = new Orange();
        Orange.Juice juice = orange.new Juice();
        orange.squeezeJuice();
        juice.flow();
    }
}
