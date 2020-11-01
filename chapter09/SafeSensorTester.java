package chapter09;

import java.util.Scanner;

public class SafeSensorTester {
    // Ask for the maximum pressure value, and then ask for pressure. Then print
    // pressure and max.
    static private SafeSensor testSensor;
    static private Scanner scanner;

    public static enum Choice {
        CONT {
            @Override
            public String toString() {
                return "CONT";
            }
        },
        QUIT {
            @Override
            public String toString() {
                return "QUIT";
            }
        }
    };

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        do {
            System.out.println("Please choose from the following SafeSensor options:\n" +
            //Test constructors
            "\t[1] Test constructors\n" +
            //Test setPressure
            "\t[2] Test setPressure\n" +
            //Test getMax
            "\t[3] Test getMax\n" +
            //Test toString
            "\t[4] Test toString\n");
            if(scanner.hasNextInt()){
                int mainChoice = scanner.nextInt();
                switch (mainChoice) {
                    case 1:
                        constructorTest();
                        break;
                    case 2:
                        setPressureTest();
                        break;
                    case 3:
                        System.out.println("Maximum pressure value: " + testSensor.getMax());
                        break;
                    case 4:
                        System.out.println(testSensor);
                        break;
                    default:
                        break;
            }
        }
            System.out.println("Continue(CONT) OR quit(QUIT)");
        } while (!scanner.nextLine().equals((Choice.QUIT).toString()));
        scanner.close();
    }
    private static void constructorTest(){
        System.out.println("Enter just max [1] or max and current pressure [2]:");
            if(scanner.hasNextInt()){
                int constructorChoice = scanner.nextInt();
                double max = 0.0;
                double pressure = 0.0;
                switch (constructorChoice) {
                    case 1:
                        System.out.println("You chose 1");
                        System.out.println("Enter maximum possible pressure value ");
                        if(scanner.hasNextDouble()){
                            max = scanner.nextDouble();
                        } else if(scanner.nextLine().equals((Choice.QUIT).toString())){
                            return;
                        }
                        testSensor = new SafeSensor(max);
                        System.out.println(testSensor);
                        break;
                    case 2:
                        System.out.println("You chose 2");
                        System.out.println("Enter maximum possible pressure value ");
                        if(scanner.hasNextDouble()){
                            max = scanner.nextDouble();
                        } else if(scanner.nextLine().equals((Choice.QUIT).toString())){
                            return;
                        }
                        System.out.println("Enter pressure value ");
                        if(scanner.hasNextDouble()){
                            pressure = scanner.nextDouble();
                        } else if(scanner.nextLine().equals((Choice.QUIT).toString())){
                            return;
                        }
                        testSensor = new SafeSensor(max, pressure);
                        System.out.println(testSensor);
                        break;
                    default:
                        System.out.println("Executing default");

                        break;
                }
            }

    }
    private static void setPressureTest(){
        System.out.println("Enter pressure value:");
            if(scanner.hasNextDouble()){
                double pressure = scanner.nextInt();
                if(testSensor.setPressure(pressure)){
                    //all good
                    System.out.println(testSensor);
                } else{
                    //no good
                    System.out.println("Illegal pressure value: Pressure value of " + pressure + " is not allowed. Sensor remains at "+ testSensor.getPressure());
                }
                
            }
    }
}
