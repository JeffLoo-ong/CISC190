import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;

public class TextCopier {

	public static void main(String[] args) {

		boolean done = false;

		//Exits entire program once done is true
		while (!done) {

			// Obtain the old file to be copied and make sure it exists before
			// moving on with program
			System.out.print("Enter the name of an existing file: ");
			Scanner keyboard = new Scanner(System.in);
			String fileName = keyboard.next();
			Scanner inputStream = null;
			
			try {
				inputStream = new Scanner(new File(fileName));
			} catch (FileNotFoundException e) {
				System.out.println(fileName
						+ " does not exist\nExiting program.");
				System.exit(0);
			}

			// Create a new file and provide options in case the file name
			// already exists
			System.out.print("Enter the name of the new file: ");
			String toFileName = keyboard.next();

			// Create a file object with the new file's name
			File fileObject = new File(toFileName);

			// If a file already exist for new file allow for options
			if (fileObject.exists()) {

				System.out.println(toFileName + " already exists.\n");

				boolean exit = false;
				// Loop does not exit until
				while (exit != true) {

					System.out.println("Choose from the following choices:\n"
							+ "1 - Exit the program\n"
							+ "2 - Overwrite the existing file\n"
							+ "3 - Enter a new name for the file");

					int choice = keyboard.nextInt();

					switch (choice) {
					case 1:
						System.out.println("System exiting.");
						System.exit(0);
						break;
					case 2:
						System.out.println("Overwriting " + toFileName);
						try {
							BufferedReader in = new BufferedReader(
									new FileReader(fileName));
							PrintWriter out = new PrintWriter(new FileWriter(
									toFileName));

							String inLine = null;

							while ((inLine = in.readLine()) != null) {
								out.println(inLine);
							}

							out.close();
							in.close();
						} catch (IOException e) {
							System.out.println("IOException: ");
							e.printStackTrace();
						}
						exit = true;
						break;
					case 3:
						System.out.print("Enter a new name for the file ");
						String newestFileName = keyboard.next();
						System.out.println("Copying " + fileName + " into "
								+ newestFileName);
						try {
							BufferedReader in = new BufferedReader(
									new FileReader(fileName));
							PrintWriter out = new PrintWriter(new FileWriter(
									newestFileName));

							String inLine = null;

							while ((inLine = in.readLine()) != null) {
								out.println(inLine);
							}

							out.close();
							in.close();
						} catch (IOException e) {
							System.out.println("IOException: ");
							e.printStackTrace();
						}
						exit = true;
						break;
					default:
						System.out
								.println("Invalid entry, select 1, 2, or 3.\n");
						break;
					}
				}

			}
			// If the file does not exist... Make a new file.
			else {
				try {
					BufferedReader in = new BufferedReader(new FileReader(
							fileName));
					PrintWriter out = new PrintWriter(
							new FileWriter(toFileName));

					String inLine = null;

					while ((inLine = in.readLine()) != null) {
						out.println(inLine);
					}

					out.close();
					in.close();
				} catch (IOException e) {
					System.out.println("IOException: ");
					e.printStackTrace();
				}
				System.out.println("Copying " + fileName + " into "
						+ toFileName);
			}
			
			//Prompts user to copy more files if desired.
			boolean over = false;
			while (!over) {
				System.out
						.println("Would you like to copy another file (y/n)?");
				Scanner key = new Scanner(System.in);
				String goOn = key.next();

				switch (goOn) {
				case "y":
				case "Y":
					over = true;
					break;
				case "n":
				case "N":
					System.out.println("Thanks for playing :)");
					over = true;
					done = true;
					break;
				default:
					System.out.println("Invalid entry, try again.");
				}
			}
		}
	}
}
