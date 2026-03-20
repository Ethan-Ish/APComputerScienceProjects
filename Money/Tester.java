
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    
    public static void print(Object obj){
        System.out.println(obj);
    }
    
    public static void main(String[] args){
        Money musk = new Money(1000, 24);
        Money ethan = new Money (9000, 43);
        Money blank = new Money();
        print(musk.toString());
        print(ethan.toString());
        print(blank.toString());
        blank.setDollars(9000);
        print(blank.getDollars());
        blank.setCents(43);
        print(blank.getCents());
        String counterfeit = "$9000.43";
        print(blank.equals(counterfeit));
        print(blank.equals(ethan));
        print(ethan.equals(musk));
        print(Money.add(ethan, blank));
        print(Money.minus(ethan, blank));
        print(ethan.add(blank));
        print(ethan.minus(blank));
        Money slenderman = null;
        print(ethan.equals(slenderman));
        print("Keep the change, ya filthy animal!");
    }
    
}
