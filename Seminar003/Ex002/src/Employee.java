import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Employee implements Comparable<Employee>{
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int salary;
    private long phoneNumber;
    private int age;
    private Date birthDate;//Я решил что вводить возраст будет как то не интересно, пусть вводят дату рождения а возраст я буду выдавать командой
    private static SimpleDateFormat format = new SimpleDateFormat();
    public Employee(String firstName, String lastName, String jobTitle, int salary, long phoneNumber, String birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        format.applyPattern("dd.MM.yyyy");
        try{
            this.birthDate = format.parse(birthDate);
        }catch (ParseException e){
            System.out.println("Ошибка перобразования даты, дата введена неверно.");
        }
    }

    public int getAge(){
        this.age = LocalDate.now().getYear() - birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().getYear();
        return age;
    }
    @Override
    public String toString() {
        getAge();
        return String.format("Full name: %s %s, JobTitle: %s, Salary: %s, Phone Number:%d, Age: %d", lastName, firstName, jobTitle, salary, phoneNumber, age);
    }

    @Override
    public int compareTo(Employee o) {
        return this.age -o.age;
    }



//    @Override
//    public int compareTo(Employee o) {
//        if (this.salary < o.salary){
//            return -1;
//        } else if (this.salary > o.salary) {
//            return 1;
//        }else {
//            return 0;
//        }
//    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void plusSalary(int salaryIncrease) {
        this.salary = this.salary + salaryIncrease;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
