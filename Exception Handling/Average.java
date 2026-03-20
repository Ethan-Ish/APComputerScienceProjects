import java.util.Scanner;
import java.util.Arrays;
/**
 * Write a description of class Average here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Average
{
    
    public static double Average() throws InvalidInputException{
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        boolean worked = false;
        int n = 0;
        while(!worked)
        {
            try{
                System.out.println("Enter N value:");
                String input = scan.nextLine();
                int output = 0;
                output = Integer.parseInt(input);
                if(output < 0)
                {
                    throw new InvalidInputException("N must be positive.");
                }
                n = output;
                worked = true;
            }
            catch(NumberFormatException | InvalidInputException e)
            {
                System.out.println(e.toString());
                if (e instanceof NumberFormatException) {
                    System.out.println("Did you input an integer?");
                }
                System.out.println("Please try again!");
            }
        }
        worked = false;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            while(!worked){
                int output = 0;
                try {
                    if(i == 0)
                    {
                        System.out.println("Enter first value:");
                    }
                    else if((i + 1) == n)
                    {
                        System.out.println("Enter last value:");
                    }
                    else
                    {
                        System.out.println("Enter next value:");
                    }
                    String input = scan.nextLine();
                    output = Integer.parseInt(input);
                    arr[i] = output;
                    worked = true;
                }
                catch (NumberFormatException e) {
                    System.out.println(e.toString());
                    System.out.println("Did you input an integer?");
                }
            }
            worked = false;
            System.out.println("Index " + Integer.toString(i) + " set to " + Integer.toString(arr[i]) + "; Array currently " + Arrays.toString(arr));
        }
        worked = false;
        double sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += (double)arr[i];
        }
        double output = sum / (double)n;
        return output;
    }
    
}
