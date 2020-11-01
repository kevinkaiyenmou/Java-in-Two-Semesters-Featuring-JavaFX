import java.util.Calendar;
public class Vehicle
{
    final static Calendar now = Calendar.getInstance();
    final static int currYear = now.getTime().getYear();
    private String regNo;
    private String make;
    private int yearOfManufacture;
    private double value;
    public Vehicle(String regNo, String make, int yearOfManufacture, double value)
    {
        this.regNo = regNo;
        this.make = make;
        this.yearOfManutacture = yearOfManufacture;
        this.value = value;
    }
    public String getRegNo()
    {
        return regNo;
    }
    public String getMake()
    {
        return make;
    }
    public int getYearOfManufacture()
    {
        return yearOfManufacture;
    }
    public double getValue()
    {
        return value
    }
    public double setValue(double value)
    {
        this.value = value;
    }
    public int calculateAge(yearOfManufacture)
    {
        return currYear - this.getYearOfManufacture;
    }
    @Override
    public String toString()
    {
        System.out.println("Your vehicle registration signature is " + this.getRegNo() + "\nYour vehicle was made by " + this.getMake() + "\nYour Vehicle costs " this.getValue() + "\nYour vehicle is " + this.calculateAge() + " old\nYour vehicle was made in the year " + this.yearOfManufacture());
    }
}