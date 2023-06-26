import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("answer: " + input());
            }catch (RowsMismatchException e){
                e.printStackTrace();
            }
        } catch (ColumnMismatchException e) {
            e.printStackTrace();
        }
    }

    public static int input() throws RowsMismatchException, ColumnMismatchException {
        Random rd = new Random();
        int[][] array = new int[rd.nextInt(1+1)+5][rd.nextInt(1+1)+5];
        System.out.println(array.length);
        System.out.println(array[0].length);
        System.out.println();
        if (array.length != 5){
            throw new RowsMismatchException(5, array.length);
        }

        if (array[0].length != 5){
            throw new ColumnMismatchException(5, array[0].length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rd.nextInt(9+1);
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                answer += array[i][j];
            }
        }
        System.out.println();

        return answer;
    }
}