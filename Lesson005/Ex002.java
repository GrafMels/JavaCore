package Lesson005;

public class Ex002 {
    public static void main(String[] args) {
        long timeStart = System.nanoTime();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s = s + i;
        }
        double deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time(sec): " + deltaTime);

        timeStart = System.nanoTime();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println("Delta time(sec): " + deltaTime);

        System.out.println(s.equals(sb.toString()));
    }
}
