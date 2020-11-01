import java.util.Scanner;
public class KevinsPartTimeEmployeeTester
{
    final static String  employeeNumber, employeeName;
    final static double hourlyPay;
    final static int hoursWorked;
    final static PartTimeEmployee person;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter employee number: ");
        employeeNumber = scanner.nextLine();
        System.out.println("Please enter employee name: ");
        employeeName = scanner.nextLine();
        System.out.println("Please enter hourly pay: ");
        hourlyPay = scanner.nextDouble();
        System.out.println("Please enter amount of hours worked this week: ");
        person = new PartTimeEmployee(employeeNumber, employeeName, hourlyPay);
        hoursWorked = scanner.nextInt();
        printEmployeeInfo();
        System.out.println("Please enter new hourly pay: ");
        person.setHourlyPay(scanner.nextDouble());
        printEmployeeInfo();
    } 

    private static void printEmployeeInfo(){
        System.out.println("The employee's name is " + person.getName() + "\nThe employee's number is " + person.getNumber() + "\nThe employee earns $" + person.getHourlyPay() + " per hour\nThe employee earns $" + person.calculateWeeklyPay(hoursWorked) + " per week");
    }
}