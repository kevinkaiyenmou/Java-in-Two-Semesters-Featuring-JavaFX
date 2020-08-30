
import java.util.Scanner;

public class CircleTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = 0;
        do{System.out.println("Please enter the radius (enter a negative number to quit): ");
        radius = scanner.nextDouble();
        if(radius < 0){
            break;
        }
        CircularShape testCircle = new CircularShape(radius);
        System.out.println("Area: " + testCircle.calculateArea());
        System.out.println("Circumference: " + testCircle.calculateCircumference());
        System.out.println("Diameter: " + testCircle.calculateDiameter());
        }while(radius >= 0);
        scanner.close();
    }
}
