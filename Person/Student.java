
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person
{
    
    private String studentId;
    private String course;
    private String teacherName;
    
    public Student(String firstName, String lastName, String studentId, String course, String teacherName)
    {
        super(firstName, lastName);
        this.studentId = studentId;
        this.course = course;
        this.teacherName = teacherName;
    }
    
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Id: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Teacher: " + teacherName);
    }
    
}
