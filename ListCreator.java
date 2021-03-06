import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> toDoList = new ArrayList<String>();
		System.out.println("Enter items for the list, when prompted.");
		boolean done = false;
		Scanner keyboard = new Scanner(System.in);

		while (!done) {
			System.out.println("Type an entry:");
			String entry = keyboard.nextLine();
			toDoList.add(entry);
			System.out.print("More items for the list?(yes/no)");

			String ans = keyboard.nextLine();
			if (!ans.equalsIgnoreCase("yes"))
				done = true;
		}
		System.out.println("The list contains:");
		int listSize = toDoList.size();
		for (int position = 0; position < listSize; position++)
			System.out.println(toDoList.get(position));

		System.out.println("Enter a String to search for:");
		String search = keyboard.nextLine();
		// System.out.println(toDoList.indexOf(search));
		System.out.println("Enter a String to replace with:");
		String replace = keyboard.nextLine();

		if (toDoList.contains(search)) {
			System.out.println(search + " found!");
		} else {
			System.out.println(search + " not here!");
		}

		toDoList.set(toDoList.indexOf(search), replace);

		System.out.println("The list contains:");
		for (String element : toDoList)
			System.out.println(element);

	}
}
