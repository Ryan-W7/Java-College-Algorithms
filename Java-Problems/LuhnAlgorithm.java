import java.util.Scanner;

public class LuhnAlgorithm 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter credit card number: ");
		String cardNum = sc.nextLine();
		
		if(isValid(cardNum))
		{
			System.out.println("VALID");
		}
		else
		{
			System.out.println("INVALID");
		}
		
		sc.close();
	}
	
	
	public static boolean isValid(String cardNum)
	{
		int total = 0; // Total Digits
		boolean doubleDig = false; // Checks if a digit needs to be doubled
		
		for (int i = cardNum.length() - 1; i >= 0; i--)
		{
			// Gets the current digit as an integer
			int digit = Character.getNumericValue(cardNum.charAt(i));
			
			if (doubleDig)
			{
				digit *= 2; 
				
				if(digit > 9)
				{
					digit -= 9;
				}
			}
			
			total += digit;
			doubleDig = !doubleDig;
		}
		
		return(total % 10 == 0);
	}
}
