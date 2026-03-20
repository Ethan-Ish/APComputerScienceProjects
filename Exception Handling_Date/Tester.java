
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args)
    {
        System.out.println(Date.dateConvert(13, 20, 2006));
        System.out.println(Date.dateConvert(-1, 20, 2006));
        System.out.println(Date.dateConvert(2, 29, 2025));
        System.out.println(Date.dateConvert(2, 29, 2024));
        System.out.println(Date.dateConvert(4, 32, 2006));
        System.out.println(Date.dateConvert(4, 20, 2006));
        System.out.println(Date.dateConvert(4, -2, 2006));
        System.out.println(Date.dateConvert(4, 20, 3001));
        System.out.println(Date.dateConvert(4, 20, 999));
        System.out.println(Date.dateConvert(4, 20, 2006));
    }
}
