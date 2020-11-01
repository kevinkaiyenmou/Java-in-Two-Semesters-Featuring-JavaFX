public class SelfTestQuestions{
    static int hi = 0;
    static double bye = 0.1;
    private static void testingTypeCast(){
        double tryingHi = (double)hi;
        int tryingBye = (int)bye; //I thought this wouldn't work
        System.out.println("'hi' is "+hi);
        System.out.println("'tryingHi' is "+tryingHi);
        System.out.println("'bye' is "+bye);
        System.out.println("'tryingBye' is "+tryingBye);
    }
    public static void main(String[] args) {
        testingTypeCast();
    }
}
/*
//2
public abstract class Shape {
    
}

public class Circle extends Shape {

}

public class Square extends Shape {

}

public class FilledCircle extends Circle {

}

/* I think the abstract modifier makes it so that you can not directly create an instance of the class 
and that you need to use one of its subclasses. I think that the Shape class should be an abstract class */

//3.b)
/*
public SafeSensor(double maxIn){
    super(10);
    max = maxIn;
}*/