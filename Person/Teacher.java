
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Teacher extends Person
{
    
    private String subjectName;
    private int salary;
    
    public Teacher(String firstName, String lastName, String subjectName, int salary)
    {
        super(firstName, lastName);
        this.subjectName = subjectName;
        this.salary = salary;
    }
    
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Subject: " + subjectName);
        System.out.println("Salary (but rude to ask): " + salary);
    }
    
}
