package chapter09;
import java.util.Scanner;

public class SensorTester {
    
    static double pressure;
    static int whichChoice;
    static Sensor sensor;
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        do{System.out.println("Which constructor would you like to use? (1, 2) ");
        System.out.println("\t1.\tSensor()\n\t2.\tSensor(double pressure)");
        int whichChoice = scanner.nextInt();
        switch (whichChoice) {
            case 1://"they chose the first constructor"
                sensor = new Sensor();
                break;
        
            case 2://"they chose the second constructor"
                System.out.print("Enter pressure: ");
                pressure = scanner.nextDouble();
                sensor = new Sensor(pressure);
                break;
            default:
                System.out.print("Please choose 1 or 2!");
                break;
        }}while(!(whichChoice == 1 || whichChoice == 2));
        System.out.println("What should we do now? (1, 2, 3)");
        System.out.println("\t1.\tChange the pressure\n\t2.\tPrint the pressure\n\t3.\tPrevious menu");
        int whichChoice = scanner.nextInt();
        switch (whichChoice) {
            case 1:
                System.out.print("Enter pressure: ");
                pressure = scanner.nextDouble();
                sensor.setPressure(pressure);
                break;
            case 2:
                System.out.println(sensor);
                break;
            }
    }
}
