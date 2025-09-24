import java.util.Scanner;

public class SortStringByLength 
{
	public static void sortList(String[] words)
	{
		for (int i = 0; i < words.length -1; i++)
		{
			for (int j = i + 1; j < words.length; j++)
			{
				if (words[i].length() > words[j].length() || 
					(words[i].length() == words[j].length() && words[i].compareTo(words[j]) > 0))
				{
					String temp = words[i];
					words[i] = words[j];
					words[j] = temp;
				}
			}
		}
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		
		String[] words = new String[num];
		
		for (int i = 0; i < num; i++)
		{
			words[i] = sc.nextLine();
		}
		
		
		sortList(words);
		
		for (String word : words)
		{
			System.out.print(word + " ");
		}
		
		sc.close();
	}
}
