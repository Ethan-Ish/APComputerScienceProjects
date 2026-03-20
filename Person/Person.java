
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private String firstName;
    private String lastName;

    /**
     * Constructor for objects of class Person
     */
    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String setFirstName(String input)
    {
        String temp = firstName;
        firstName = input;
        return temp;
    }
    
    public String setLastName(String input)
    {
        String temp = lastName;
        lastName = input;
        return temp;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void displayDetails()
    {
        String output = "Name: " + firstName + " " + lastName;
        System.out.println(output);
    }
}
