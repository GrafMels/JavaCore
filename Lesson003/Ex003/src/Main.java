public class Main {
    public static void main(String[] args) {
        //У всех котов обычно четыре лапы
        Cat cat1 = new Cat("Basilar", "White", 4);
        // но вот мы захотели завести кота с 3 лапами
        Cat cat2 = new Cat("Murasaki", "Black", 6);
        cat2.setPawsCount(3);
        //теперь у всех котов по три лапы
        System.out.println(cat1.getPawsCount());
        // Так получилось по тому что мы установили значение лап
        // pawsCount как статическое
        // тоесть одинаковое для всех экзепляров класса
        // Что бы избегать такова не изменяйте статические значения
        // с помощью экземпляров класса или делайте статические константы.
    }
}