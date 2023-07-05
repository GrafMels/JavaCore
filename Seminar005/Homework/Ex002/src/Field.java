import java.io.IOException;

public class Field {
    private byte[] fieldArray = new byte[9];
    private boolean isCrosses = true;
    private boolean isClose = false;
    public Field() {
    }
    public Field(byte[] fieldArray) {
        this.fieldArray = fieldArray;

        int crossesCount = 0;
        int zerosCount = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            if (this.fieldArray[i]==1){
                crossesCount++;
            } else if (this.fieldArray[i]==0) {
                zerosCount++;
            }
            if (crossesCount > zerosCount){
                this.isCrosses = false;
            }
        }
    }

    public boolean isCrosses() {
        return isCrosses;
    }

    public boolean isClose() {
        return isClose;
    }

    public boolean makeAMove(byte move) throws IOException {
        move--;

        if(move == 10){
            this.isClose = true;
            saveGame();
            return true;
        }

        if(move == -1){
            this.isClose = true;
            return true;
        }

        if (fieldArray[move] == 0) {

            if (isCrosses) {
                this.fieldArray[move] = 1;
                this.isCrosses = false;
            } else {
                fieldArray[move] = 2;
                this.isCrosses = true;
            }
        } else {
            throw new SlightException("Ячейка занята.");
        }
        return feelWinField();
    }

    public boolean feelWinField(){
        if (this.fieldArray[0] == this.fieldArray[1] && this.fieldArray[1] == this.fieldArray[2] && this.fieldArray[0]!=0){
            return true;
        }
        if (this.fieldArray[0] == this.fieldArray[3] && this.fieldArray[3] == this.fieldArray[6] && this.fieldArray[0]!=0){
            return true;
        }
        if (this.fieldArray[0] == this.fieldArray[4] && this.fieldArray[4] == this.fieldArray[8] && this.fieldArray[0]!=0){
            return true;
        }
        if (this.fieldArray[6] == this.fieldArray[7] && this.fieldArray[8] == this.fieldArray[7] && this.fieldArray[6]!=0){
            return true;
        }
        if (this.fieldArray[6] == this.fieldArray[4] && this.fieldArray[2] == this.fieldArray[4] && this.fieldArray[6]!=0){
            return true;
        }
        if (this.fieldArray[2] == this.fieldArray[5] && this.fieldArray[8] == this.fieldArray[2] && this.fieldArray[2]!=0){
            return true;
        }
        if (this.fieldArray[3] == this.fieldArray[4] && this.fieldArray[5] == this.fieldArray[3] && this.fieldArray[3]!=0){
            return true;
        }
        if (this.fieldArray[1] == this.fieldArray[4] && this.fieldArray[4] == this.fieldArray[7] && this.fieldArray[1]!=0){
            return true;
        }
        if (this.fieldArray[0] != 0 && this.fieldArray[1] != 0 && this.fieldArray[2] != 0 && this.fieldArray[3] != 0 && this.fieldArray[4] != 0 && this.fieldArray[5] != 0 && this.fieldArray[6] != 0 && this.fieldArray[7] != 0 && this.fieldArray[8] != 0){
            this.isClose=true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder newField = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (i!=0){
                newField.append("===========\n");
            }
            for (int j = 0; j < 3; j++) {
                if (j!=0){
                    newField.append("|");
                }
                if (fieldArray[count]==0){
                    newField.append(" . ");
                } else if (fieldArray[count]==1) {
                    newField.append(" X ");
                }else if (fieldArray[count]==2) {
                    newField.append(" 0 ");
                }

                count++;
            }
            newField.append("\n");
        }
        return newField.toString();
    }

    public void saveGame() throws IOException {
        int allField = 0;
        if (isCrosses){
            for (int i = 0; i < fieldArray.length; i++) {
                allField = allField + (int) (fieldArray[i] * Math.pow(10, i));
            }
        }else {
            for (int i = 0; i < fieldArray.length; i++) {
                if (fieldArray[i]==1){
                    fieldArray[i]=2;
                }else if(fieldArray[i]==2){
                    fieldArray[i]=1;
                }
                allField = allField + (int) (fieldArray[i] * Math.pow(10, i));
            }
        }
        View.saveGame(String.format("%d", allField));

    }
}
