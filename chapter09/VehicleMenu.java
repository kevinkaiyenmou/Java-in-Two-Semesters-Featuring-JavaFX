package chapter09;
import java.util.Scanner;
import java.util.ArrayList;

public class VehicleMenu 
{
    
   
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(system.in);
        ArrayList<Vehicle> vehicleList = new Arraylist<Vehicle>();
        do
        {
            System.out.println("Add vehicle[1] \nDisplay vehicle details[2] \nDelete a vehicle[3] \nQuit program[4]");
            int choice = scanner.nextInt();
            
            
            
            switch (choice)
            {
                case 1: System.out.println("What is your vehicle's registration number");
                        String registrationSignature = scanner.nextLine();
                        System.out.println("What is your vehicle's manufacturer");
                        String manufacturer = scanner.nextLine();
                        System.out.println("When was your vehicle made");
                        int yearMade = scanner.nextInt();
                        System.out.println("What is your vehicle's cost");
                        double costOfVehicle = scanner.nextDouble();
                        vehicleList.add(new Vehicle(registrationSignature, manufacturer, yearMade, costOfVehicle));
                        break;
                case 2: //System.out.println("What is your vehicle's registration number")
                        //String registrationSignature = scanner.nextLine();
                        //vehicleList.forEach()equals(registrationSignature);
                        //I don't know how to search an ArrayList for objects
                        break;
                case 3: System.out.println("What is your vehicle's registration number");
                        String registrationSignature = scanner.nextLine();
                        System.out.println("What is your vehicle's manufacturer");
                        String manufacturer = scanner.nextLine();
                        System.out.println("When was your vehicle made");
                        int yearMade = scanner.nextInt();
                        System.out.println("What is your vehicle's cost");
                        double costOfVehicle = scanner.nextDouble();
                        //I know there's an easier way to do this but I couldn't think of it so I just copy and pasted the whole thing.
                        vehicleList.remove(Vehicle(registrationSignature, manufacturer, yearMade, costOfVehicle));
                        break;
                default: System.out.println("You entered an invalid number.");
                
            }
        }
        while(choice != 4);
        scanner.close();
    }
}
