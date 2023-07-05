import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Field field;
        if (View.isExist()){
            try {
                field = new Field(View.loadGame());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            field = new Field();
        }
        boolean isExit = false;
        while(!isExit){
            System.out.println(field);

            try {
                byte answer = (byte) View.returnAnswer();
                isExit = field.makeAMove(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!field.isClose()){
            if (!field.isCrosses()){
                System.out.println("Crosses win!!");
            }else {
                System.out.println("Zeros win!!");
            }
        }else {
            System.out.println("Friendship won!!");
        }
        View.scannerClose();
    }
}