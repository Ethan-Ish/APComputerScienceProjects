
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Date
{
    
    public static String dateConvert(int month, int day, int year){
        String output = "err";
        try{
            if(!(month > 0 && month < 12))
            {
                throw new MonthException("Invalid month! (Is it between 0 and 12?)");
            }
            if(!(year > 1000 && year < 3000))
            {
                throw new YearException("Invalid year! (Is it between 1000 and 3000?)");
            }
            int[] monthToDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if((year % 4) == 0)
            {
                monthToDay[1] = 29;
            }
            if(!(day > 0 && (day <= monthToDay[month - 1])))
            {
                throw new DayException("Invalid day! (Is it above zero and within your month?)");
            }
            String[] monthToName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String monthName = monthToName[month - 1];
            output = monthName + " " + Integer.toString(day) + ", " + Integer.toString(year);
        }
        catch(MonthException | DayException | YearException e)
        {
            System.out.println(e.toString());
        }
        return output;
    }
    
}
