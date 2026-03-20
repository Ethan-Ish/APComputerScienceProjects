
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    
    private String name;
    
    public Person(String theName)
    {
        this.name = theName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String theName)
    {
        name = theName;
    }
    
    public String toString()
    {
        return ("Name: " + name);
    }
    
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        Class otherClass = other.getClass();
        Class thisClass = (new Person("")).getClass();
        if(!(otherClass.getName().equals(thisClass.getName())))
        {
            return false;
        }
        Person other_person = (Person) other;
        if(!other_person.getName().equals(name))
        {
            return false;
        }
        return true;
    }
    
    public Person(Person theObject)
    {
        this.name = theObject.getName();
    }
    
}
