package chapter09;
import java.util.Scanner;

public class SecondHandVehicleTester 
{
    final static Scanner SCANNER = new Scanner(System.in);
    public static Vehicle;
    public static Vehicle vehicleBuilder()
    {
        char choiceNewUsed;
        do{System.out.println("Do you want to enter a new[N] or used[U] vehicle?");
        choiceNewUsed = SCANNER.next().toLowerCase().charAt(0);
        String registrationSignature;
        String manufacturer;
        int yearMade;
        double costOfVehicle;
        System.out.println("What is your vehicle's registration number");
        registrationSignature = SCANNER.nextLine();
        System.out.println("What is your vehicle's manufacturer");
        manufacturer = SCANNER.nextLine();
        System.out.println("When was your vehicle made");
        yearMade = SCANNER.nextInt();
        System.out.println("What is your vehicle's cost");
        costOfVehicle = SCANNER.nextDouble();
        if(type == 'n'){
            return new Vehicle(registrationSignature, manufacturer, yearMade, costOfVehicle);
        } else if (type == 'u'){
            int numOfOwners;
            System.out.println("How many owners have you vehicle had")
            numOfOwners = SCANNER.nextInt();
            return new SecondHandVehicle(registrationSignature, manufacturer, yearMade, costOfVehicle, numOfOwners);
        }
        System.out.println("That is not a valid choice.");
        }while(choiceNewUsed != 'n' && choiceNewUsed !='u');
    }
    public static void main(String args[])
    {
        char choice;
        do{
            if(/** there is already a vehicle that the tester is modifying, then */) System.out.println("Do you want to view[V] or modify[M] vehicle?");
            choiceNewUsed = SCANNER.next().toLowerCase().charAt(0); 
        }while(choice != '');
        
        
        /** 
         * Function Modify(Vehicle): asks user what field they want to change, then asks for input value, then changes it based; Print
         * Function Print(Vehicle): print details of Vehicle
         * Function VehicleBuilder: Return a new vehicle by asking for all details
         * Main Loop:
         * If they don't have a vehicle, then invoke Destroy
         * If they have a vehicle, then ask
         * modify?
         * print?
         * destroy?
         * exit?
        */
    }
    SCANNER.close();
}
