
public class Student
{
    private String studentNumber; //format 0123456789 max is 9999999999 min is 0000000000
    private String studentName;
    private int markForMath;
    private int markForEnglish;
    private int markForScience;
    private static double fee; //I don't know what fee means. Is it the tuition fee?
    public Student(String studentName)
    {
        //No studentNumber specified, so generate random number
        this(Math.random()*(Math.pow(10,11)-1),studentName);
    }
    public Student(double studentNumber, String studentName){
        this((int)studentNumber,studentName);
    }
    public Student(int studentNumber, String studentName){
        this(String.format("%010d",studentNumber), studentName);
    }
    public Student(String studentNumber, String studentName)
    {
        this.studentNumber = studentNumber;
        this.studentName = studentName;
    }
    public String getNumber()
    {
        return studentNumber;
    }
    public String getName()
    {
        return studentName;
    }
    public void enterMarks(int markForMath, int markForEnglish, int markForScience)
    {
        this.markForMath = markForMath;
        this.markForEnglish = markForEnglish;
        this.markForScience = markForScience;
        
    }
    public int getMathMarks()
    {
        return markForMath;
    }
    public int getEnglishMarks()
    {
        return markForEnglish;  
    }
    public int getScienceMarks()
    {
        return markForScience;
    }
    public double calculateAverageMark()
    {
        return (markForScience + markForEnglish + markForMath) / 3.0;
    }
    public static double getFee()
    {
        return fee;
    }
    public /* static */ void setFee(double fee)
    {
        this.fee = fee; //I don't know how to access fee in a static way because you can't use this.fee in a static context
    }
} 