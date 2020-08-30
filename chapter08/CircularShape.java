import java.lang.Math;


public class CircularShape 
{
    private double radius;

    public CircularShape(double radius)
    {
        this.radius = radius;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public double calculateArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }
    public double calculateCircumference()
    {
        return Math.PI * 2 * radius;
    }
    public double calculateDiameter()
    {
        return 2 * radius;
    }
}
