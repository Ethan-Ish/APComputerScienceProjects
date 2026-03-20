
/**
 * Write a description of class Rectangle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rectangle implements Shape
{
    private double width;
    private double height;
    
    public Rectangle (double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public void setWidth(double wid){
        width = wid;
    }
    
    public void setHeight(double heigh)
    {
        height = heigh;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double area() {
        return width * height;
    }
}
