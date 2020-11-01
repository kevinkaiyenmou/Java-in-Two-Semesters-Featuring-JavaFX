package chapter09;

public class SecondHandVehicle extends Vehicle
{
    private int numberOfOwners;
    public SecondHandVehicle(String regNo, String make, int yearOfManufacture, double value, int numberOfOwners)
    {
        super(regNo, make, yearOfManufacture, value)
        this.numberOfOwners = numberOfOwners;
    }

    /**
     * @return the numberOfOwners
     */
    public int getNumberOfOwners() 
    {
        return numberOfOwners;
    }
    public boolean hasMultipleOwners()
    {
        return (this.getNumberOfOwners() > 1);
    }
    @Override
    public String toString()
    {
        return super.toString()  + "\nYour vehicle has been owned by " + getNumberOfOwners() + " owner" + ( hasMultipleOwners() ? 's':'' )  
    }
}
