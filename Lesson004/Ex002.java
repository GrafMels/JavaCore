package Lesson004;
public class Ex002 {
    enum Color {
        RED("#FF0000"), GREEN("00FF00"), BLUE("0000FF");
        private String code;
        Color(String code){
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }
    public static void main(String[] args) {
        for (Color c: Color.values()){
            System.out.printf("%s(%s)\n", c, c.getCode());
        }
    }
}
