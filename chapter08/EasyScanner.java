
import  java.util.Scanner;

public class EasyScanner implements AutoCloseable
{
private static boolean lastReadString = false; 
    private static Scanner keyboard = new Scanner(System.in);
    public static int nextInt()
    {
        lastReadString = false;
        return keyboard.nextInt();
    }

    public static double nextDouble()
    {
        lastReadString = false;
        return keyboard.nextDouble();
    }

    public static String nextString()
    {
        lastReadString = true;
        return keyboard.next();
    }

    public static char nextChar()
    {
        lastReadString = false;
        return keyboard.next().charAt(0);
    }
    public void close(){
        keyboard.close();
    }
}

