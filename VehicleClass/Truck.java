
/**
 * Write a description of class Truck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Truck extends Vehicle
{
    
    private double loadCap = 0;
    private int towCap = 0;
    
    public Truck(String name, int cyl, Person own, double loadCapacity, int towingCapacity)
    {
        super(name, cyl, own);
        this.loadCap = loadCapacity;
        this.towCap = towingCapacity;
    }
    
    public String toString(){
        String ret = "Name: " + this.getName() + ", Cylinders: " + Integer.toString(this.getCylinders()) + ", Owner: " + this.getOwner().toString();
        ret = ret + ", load capacity in tons: " + Double.toString(loadCap) + ", towing capacity in pounds: " + Integer.toString(towCap);
        return ret;
    }
    
    public double getLoadCapacity()
    {
        return loadCap;
    }
    
    public double getTowCapacity()
    {
        return towCap;
    }
    
    public void setLoadCapacity(double numInp)
    {
        loadCap = numInp;
    }
    
    public void setTowCapacity(int numInp)
    {
        towCap = numInp;
    }
    
}
