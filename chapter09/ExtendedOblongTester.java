import java.util.Scanner;

public class ExtendedOblongTester
{
	public static void main(String[] args)
	{
		char symbol;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the symbol for the shape ");
		symbol = scanner.next().charAt(0); //gets the first char of the string. 
		ExtendedOblong extOblong = new ExtendedOblong(10.2,5.3,'*');
		System.out.println(extOblong.draw());
		extOblong.setSymbol(symbol);
		System.out.println(extOblong.draw());
	}
}
