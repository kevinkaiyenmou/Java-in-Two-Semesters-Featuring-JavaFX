package chapter09;

public class SafeSensor extends Sensor 
{
    private static final double DEFAULT_PRESSURE = 10;
    public class SafeSensorException extends ExceptionInInitializerError{
        public SafeSensorException(String details){
            super(details);
        }
    }
    private double max;

    public SafeSensor(double max) throws SafeSensorException
    {
        super(DEFAULT_PRESSURE);
        if(max < DEFAULT_PRESSURE){
            throw new SafeSensorException("Cheeky monkey! 🐒");
        }
        this.max = max;
        //book says this constructor is supposed to set maximum value and set value of sensor to 10
        //I don't understand what it means by setting the value of sensor to 10. Set the pressure to 10 maybe?
        //I don't think I can set pressure to 10 because pressure isn't a parameter for this constructor
    }
    public SafeSensor(double max, double pressure) throws SafeSensorException
    {
        super(pressure);
        this.max = max;
        if(pressure > max || pressure < 0){
            throw new SafeSensorException("You fool!");
        }
    }
    public boolean setPressure(double pressure)
    {
        if(pressure < 0 || pressure > max)
        {
        
            return false;
        }
        else
        {
            super.setPressure(pressure); //How do I set the pressure if it's a private variable here?
            return true;
        }
    }
    public double getMax()
    {
        return max;
    }
    @Override
    public String toString(){
        return super.toString() + String.format("\nsensor max pressure: %f", this.getMax());
    }
}
