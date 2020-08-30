import java.util.*;

public class StudentTester {
    private static Student currStudent;
    private static Collection<Student> school = new ArrayList<>();

    public static boolean studentEnrolled(Student prospectiveStudent) {
        for(Student enrolledStudent : school){
            if (enrolledStudent.getNumber() == prospectiveStudent.getNumber()) {
                System.out.println("This student number is already enrolled.");
                return true;
            }
        }
        System.out.println("No student with this number is yet enrolled.");
        return false;
    }

    public static boolean studentEnrolled(int prospectiveStudentNum) {
        return studentEnrolled(new Student(prospectiveStudentNum, ""));
    }

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        do {
            System.out.println("1. New student");
            System.out.println("2. Show student information");
            System.out.println("3. Set Marks");
            System.out.println("4. Set Tuition Fees");
            System.out.println("5. Quit\n");
            System.out.print("Enter choice [1-5]: ");

            choice = EasyScanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    newStudent();
                    break;
                case 2:
                    printStudentInfo();
                    break;
                case 3:
                    setStudentMarks();
                    break;
                case 4:
                    setTuitionFees();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        } while (!quit);

    }
    private static void setTuitionFees() 
    {
        double debt;
        System.out.println("How much does the student owe?"); 
        debt = EasyScanner.nextDouble();
        if(studentEnrolled(currStudent))
        {
            currStudent.setFee(debt);
        }
        else
        {
            System.out.println("Invalid student number");
        }
        
        //finding out if the student exists but I don't know how to.
        
        currStudent.setFee(debt);
        // asks for how much the student owes, sets the fees for student
    }

    private static void setStudentMarks() 
    {
        int math, english, science;
        System.out.println("Enter math marks");
        math = EasyScanner.nextInt();
        System.out.println("Enter english marks");
        english = EasyScanner.nextInt();
        System.out.println("Enter science marks");
        science = EasyScanner.nextInt();
        if(studentEnrolled(currStudent))
        {
            currStudent.enterMarks(math, english, science);
        }
        printStudentInfo();
        // ask for the marks for the three courses and then call student.enterMarks(...) with the marks as arguments
    }

    static void newStudent() {
        boolean validChoice = false;
        int choice;
        do {
            System.out.println(
                    "Choose either:\n" + "1. Specify student name,\n" + "2. Specify student name, student number");
            choice = EasyScanner.nextInt();
            System.out.println();
            System.out.println("What is the student's name? ");
            String name = EasyScanner.nextString();
            switch (choice) {
                case 1:
                    do {
                        currStudent = new Student(name);
                    } while (studentEnrolled(currStudent));
                    validChoice = true;
                    break;
                case 2:
                    int number;
                    do{
                        System.out.println("What is the student's number? ");
                        number = EasyScanner.nextInt(); // we are not checking the number format, which means user
                                                              // could enter wrong format
                    }while(studentEnrolled(number));
                    currStudent = new Student(number,name);
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (!validChoice);
        school.add(currStudent);
    }

    static void printStudentInfo()
    {
        //check if there is a current student to modify (currStudent is set)
        if(studentEnrolled(currStudent))
        {
            System.out.println("Info for "+currStudent.getName()+" (" + currStudent.getNumber() + "):");
            System.out.println("Average marks:\t"+currStudent.calculateAverageMark());
            System.out.println("Math marks:\t"+currStudent.getMathMarks());
            System.out.println("English marks:\t"+currStudent.getEnglishMarks());
            System.out.println("Science marks:\t"+currStudent.getScienceMarks());
        }
        // print out all the student information for `student`
    }
}