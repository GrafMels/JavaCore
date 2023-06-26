import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Customer {
    private String fullName;
    private LocalDate birthDate;
    private long phoneNumber;

    public Customer(String fullName, String birthDate, long phoneNumber) {
        this.fullName = fullName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        this.birthDate = LocalDate.parse(birthDate, formatter);
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "\n\t\tCustomer{" +
                "\n\t\t\tfullName='" + fullName + '\'' +
                ", \n\t\t\tage=" + (LocalDate.now().getYear() - birthDate.getYear()) +
                ", \n\t\t\tphoneNumber=" + phoneNumber +
                '}';
    }

    public String toStringInOrder() {
        return "\n\t\t\t\tCustomer{" +
                "\n\t\t\t\t\tfullName='" + fullName + '\'' +
                ", \n\t\t\t\t\tage=" + (LocalDate.now().getYear() - birthDate.getYear()) +
                ", \n\t\t\t\t\tphoneNumber=" + phoneNumber +
                '}';
    }
}
