import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();

        String[] login = {"MyLogin", "NotMyLogin jhwrfjwrtjwrtjrewtjrewtjrwtjwrtj"};
        String[] password = {"1234567890", "123456789012345678901"};
        String[] confirmPassword = {"1234567890", "1235125125125"};

        int rand1 = rd.nextInt(1+1);
        int rand2 = rd.nextInt(1+1);
        int rand3 = rd.nextInt(1+1);

        try {
            System.out.println(loginPasswordChecker(login[rand1], password[rand2], confirmPassword[rand3]));
        } catch (WrongLoginException e) {
            e.printStackTrace();
        } catch (WrongPasswordException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(login[rand1]);
        System.out.println(password[rand2]);
        System.out.println(confirmPassword[rand3]);
    }

    public static boolean loginPasswordChecker(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20){
            throw new WrongLoginException(String.format("Wrong login exception: expected %d login length. Received 20 login length.", login.length()));
        }

        if(password.length() >= 20){
            throw new WrongPasswordException(String.format("Wrong password exception: expected %d password length. Received 20 password length.", password.length()));
        }

        if (!confirmPassword.equals(password)){
            throw new WrongPasswordException(String.format("Wrong password exception: expected %s password, and expected %s confirm password. Passwords not equals", password, confirmPassword));
        }
        return true;
    }
}