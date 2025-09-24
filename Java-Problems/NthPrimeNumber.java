import java.util.Scanner;

public class NthPrimeNumber 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		
		int count = 0;
		int num = 2;
				
				
		while (count < n)
		{
			boolean isPrime = true;
			
			for (int i = 2; i * i <= num; i++)
			{
				if (num % i == 0)
				{
					isPrime = false;
					break;
				}
			}
			
			if(isPrime)
			{
				count++;
				
				if (count == n)
				{
					System.out.println(num);
				}
			}
			
			num++;
		}
		
		
	}
}
