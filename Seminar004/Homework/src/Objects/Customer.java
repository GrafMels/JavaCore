package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Customer {
    private String fullName;
    private LocalDate birthDate;
    private long phoneNumber;
    private String gender;

    public Customer(String fullName, String birthDate, long phoneNumber) {
        this.fullName = fullName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        this.birthDate = LocalDate.parse(birthDate, formatter);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "\n\t\tObjects.Customer{" +
                "\n\t\t\tfullName='" + fullName + '\'' +
                "\n\t\t\tgender='" + gender + '\'' +
                ", \n\t\t\tage=" + (LocalDate.now().getYear() - birthDate.getYear()) +
                ", \n\t\t\tphoneNumber=" + phoneNumber +
                '}';
    }

    public String toStringInOrder() {
        return "\n\t\t\t\tObjects.Customer{" +
                "\n\t\t\t\t\tfullName='" + fullName + '\'' +
                "\n\t\t\t\t\tgender='" + gender + '\'' +
                ", \n\t\t\t\t\tage=" + (LocalDate.now().getYear() - birthDate.getYear()) +
                ", \n\t\t\t\t\tphoneNumber=" + phoneNumber +
                '}';
    }

    public void buildMan(){
        this.gender = "male";
    }

    public void buildWoman(){
        this.gender = "female";
    }
}
