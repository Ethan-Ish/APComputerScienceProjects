
/**
 * Write a description of class Money here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Money
{
    
    private int dollars;
    private int cents;
    
    public Money()
    {
        this.dollars = 0;
        this.cents = 0;
    }
    
    public Money(int dol)
    {
        this.dollars = dol;
    }
    
    public Money(int dol, int cen)
    {
        this.dollars = dol;
        this.cents = cen;
    }
    
    public Integer getDollars()
    {
        return dollars;
    }
    
    public Integer getCents()
    {
        return cents;
    }
    
    public void setDollars(int dol)
    {
        dollars = dol;
    }
    
    public void setCents(int cen)
    {
        cents = cen;
        while(cents >= 100)
        {
            cents -= 100;
            dollars += 1;
        }
    }
    
    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        Money testMon = new Money();
        Class monClass = testMon.getClass();
        Class objClass = obj.getClass();
        if(monClass != objClass)
        {
            return false;
            
        }
        else
        {
            Money inpMon = (Money)obj;
            return (inpMon.getDollars() == dollars && inpMon.getCents() == cents);
        }
    }
    
    public String toString()
    {
        String output = "$" + Integer.toString(dollars);
        output = output + "." + Integer.toString(cents);
        return output;
    }
    
    public static Money add(Money m1, Money m2)
    {
        int newCents = m1.getCents() + m2.getCents();
        int newDollars = m1.getDollars() + m2.getDollars();
        while(newCents >= 100)
        {
            newCents -= 100;
            newDollars += 1;
        }
        Money output = new Money(newDollars, newCents);
        return output;
    }
    
    public static Money minus(Money m1, Money m2)
    {
        int newCents = m1.getCents() - m2.getCents();
        int newDollars = m1.getDollars() - m2.getDollars();
        while(newCents <= -100)
        {
            newCents += 100;
            newDollars -= 1;
        }
        Money output = new Money(newDollars, newCents);
        return output;
    }
    
    public Money add(Money m2)
    {
        Money m1 = new Money(dollars, cents);
        return Money.add(m1, m2);
    }
    
    public Money minus(Money m2)
    {
        Money m1 = new Money(dollars, cents);
        return Money.minus(m1, m2);
    }
    
}
