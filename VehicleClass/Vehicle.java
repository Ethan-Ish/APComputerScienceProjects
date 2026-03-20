
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    // instance variables - replace the example below with your own
    private String name;
    private int cylinders;
    private Person owner;
    
    public Vehicle(String name, int cyl, Person own)
    {
        this.name = name;
        this.cylinders = cyl;
        this.owner = own;
    }
    
    public String getName(){
        return name;
    }
    
    public Integer getCylinders(){
        return cylinders;
    }
    
    public Person getOwner(){
        return owner;
    }
    
    public void setName(String newName){
        name = newName;
    }
    
    public void setCylinders(int input){
        cylinders = input;
    }
    
    public void setOwner(Person input){
        owner = input;
    }
    
    public String toString(){
        String output = "Name: " + name + ", Cylinders: " + cylinders + ", Owner: " + owner.toString();
        return output;
    }
    
}

