import java.util.Arrays;
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String[] args)
{

    InventoryItem item1 = new InventoryItem("pizza!", 3);
    InventoryItem item2 = new InventoryItem("mmm chezburgers", 5);
    InventoryItem item3 = new InventoryItem("*soda crack* ah", 2);
    InventoryItem[] inventory = {item1, item2, item3};
    for(int i = 0; i < inventory.length; i++){
        System.out.println(inventory[i].toString());
    }
    Arrays.sort(inventory);
    System.out.println("Break!");
    for(int i = 0; i < inventory.length; i++){
        System.out.println(inventory[i].toString());
    }
       Circle c = new Circle(4); // Radius of 4 
       Rectangle r = new Rectangle(4,3); // Height = 4, Width = 3 
       showArea(c);
       showArea(r);
}
public static void showArea(Shape s)
{     
      double area = s.area();
      System.out.println("The area of the shape is " + area);
}
}
