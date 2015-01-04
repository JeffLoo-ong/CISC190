import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;


public class InputOutputStream {
	public static void main(String[] args) throws IOException
	{
		boolean done = false;
		while(done != true)
		{
			//Use an Array based Data Structure to store list of integers
			ArrayList<Integer> list = new ArrayList<Integer>();
		
			System.out.println("Please enter the file name including type (.txt, etc): ");
			Scanner keyboard = new Scanner(System.in);
			String fileName = keyboard.nextLine();
		
			Scanner inputStream = null;
		
		
			//Attempt to read the file. If file does not exist, exit the program.
			try
			{
				inputStream = new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening file " + fileName);
				System.exit(0);
			}
		
			//Handles Empty Files (Taken from StackOverFlow 7190618)
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			if(br.readLine() == null)
			{
				System.out.println("File is Empty");
				System.exit(0);
			}
			
			//If File is not empty, print next statement and continue
			System.out.println("The file " + fileName + " contains the following lines:\n");
			//Read until all characters have been read and all integers are stored in list
			while(inputStream.hasNext())
			{
				if(inputStream.hasNextInt())
				{
					list.add(inputStream.nextInt());
				}
				else
				{
					inputStream.next();
				}
			}
		
			//Sort the data in list through ascending order
			Collections.sort(list);
			
			//Print each integer on a newline in ascending order
			for (Integer x: list)
			{
				System.out.println(x);
			}	
			 
			ArrayList clone = new ArrayList(list.size());
			
			int j = 0;
			int i = 1;
			 
			while (i < list.size()) 
			{
				if (list.get(i) == list.get(j)) 
				{
					i++;
				} 
				else 
				{
					j++;
					clone.set(j, i);
					i++;
				}
				clone.trimToSize();
			}
				
			System.out.println(clone);
		
			System.out.println("Do you have more files to parse? (Yes/No)");
			Scanner keyboard2 = new Scanner(System.in);
			String parse = keyboard.next();	
		
			switch (parse)
			{
				case "No":
					System.out.println("See ya later!");
					done = true;
					break;
			}
		}
	}

}
