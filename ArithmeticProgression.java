import java.util.*;

public class ArithmeticProgression
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        char repeat = 'y';
        while(repeat == 'y' || repeat == 'Y')
        {
            int number = -1; // Arbitrary value to enter loop
            while(number <= 0)
            {
                System.out.println("Enter a positive integer:");
                number = keyboard.nextInt();
            }
            System.out.println("The sum of the first " + number
                         + " of integers is " + sumInts(number) + ".");
            System.out.println();
            System.out.println("Do again? Enter 'y' for yes.");
            repeat = keyboard.next().charAt(0);
        }
    }
    private static int sumInts(int n)
    {
        if (n == 1)
        {
        	return 1;
        }
        return (n+(sumInts(n-1)));
    }
}

