package Lesson004;
/**
 * Ex001
 */
public class Ex001 {
    public static void main(String[] args) {
        enum Season{WINTER, SPRING, SUMMER, AUTUMN}
        Season[] seasons = Season.values();
        for (Season oneSeason : seasons) {
            System.out.println(oneSeason.ordinal() + ": " + oneSeason);//ordinal возращает порядковый номер константы
        }
    }
}