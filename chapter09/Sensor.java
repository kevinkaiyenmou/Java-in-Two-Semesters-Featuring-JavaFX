package chapter09;

public class Sensor 
{
    private double pressure;
    public Sensor()
    {
        this.pressure = 0;
    }
    public Sensor(double pressure)
    {
        if(!(pressure < 0)){ 
            this.pressure = pressure;
        }
    }
    public boolean setPressure(double pressure)
    {
        if(pressure < 0)
        {
            return false;
        }
        else
        {
            this.pressure = pressure;
            return true;
        }
    }
    public double getPressure()
    {
        return pressure;
    } 
    @Override
    public String toString()
    {
        return String.format("sensor pressure: %f", this.getPressure());
    }
}
