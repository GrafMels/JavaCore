public class Manager extends Employee{
    public Manager(String firstName, String lastName, String jobTitle, int salary, long phoneNumber, String birthDate) {
        super(firstName, lastName, jobTitle, salary, phoneNumber, birthDate);
    }

    public static void salaryIncrease(int salaryIncrease, Employee employee){
        if (employee instanceof Manager == false){
            employee.plusSalary(salaryIncrease);
        }
    }
}
