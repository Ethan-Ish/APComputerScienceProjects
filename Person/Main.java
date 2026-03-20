
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    
    public static void main(String args[])
    {
        Student ethan = new Student("Ethan", "Ish", "1", "Comp Sci A", "Dr. Polacco");
        Student baxter = new Student("Baxter", "Ish", "2", "ODFRL", "Dr. Rees");
        Teacher pol = new Teacher("Joseph", "Polacco", "Comp Sci A", 99999);
        Teacher ree = new Teacher("Joseph", "Rees", "ODFRL", 34);
        ethan.displayDetails();
        baxter.displayDetails();
        pol.displayDetails();
        ree.displayDetails();
    }
    
}
