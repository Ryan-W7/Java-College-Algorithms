import java.util.Scanner;
import java.util.Stack; 

public class LIFO_Directions 
{
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		Stack<String> stack = new Stack<String>();
		
		while (true)
		{
			String direction = sc.nextLine();
			
			if(direction.equals("Arrived"))
			{
				break;
			}
			else if (direction.equals("Go Back"))
			{
				if (!stack.isEmpty())
				{
					stack.pop();
				}
			}
			else
			{
			    stack.push(direction);
			}
		}
		
		sc.close();
		
		while(!stack.isEmpty())
		{
			String lastDirect = stack.pop();
			
			switch (lastDirect) 
			{
			    case "Go South":
			    	System.out.println("Go North"); 
			    	break;
			    case "Go North":
			    	System.out.println("Go South");
			    	break;
			    case "Go West":
			    	System.out.println("Go East");
			    	break;
			    case "Go East":
			    	System.out.println("Go West");
			    	break;
			}
			
		}
	}	
}