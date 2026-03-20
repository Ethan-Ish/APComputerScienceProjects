
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle implements Shape
{
    private double rad;
    
    public Circle(double rad){
        this.rad = rad;
    }
    
    public double getRad()
    {
        return rad;
    }
    
    public void setRadius(double inp){
        rad = inp;
    }
    
    public double area(){
        return (Math.pow(rad, 2) * Math.PI);
    }
}
