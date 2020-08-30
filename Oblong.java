import java.util.Scanner;

public class Oblong {
    private double length;
    private double height;

    public Oblong() {
        length = 0;
        height = 0;
    }

    public Oblong(double length, double height) {
        this.length = length;
        this.height = height;
    }
    public double getLength(){
        return length;
    }
    public double getHeight(){
        return height;
    }
    public void setLength(double length){
        this.length = length;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double calculateArea(){
        return (length * height);
    }
    public double calculatePerimeter(){
        return ((length + height) * 2);
    }
    public static Oblong build(){ 
        return new Oblong();
    }
    public static void main(String[] args) {
        Oblong myObby = new Oblong();
    }
}