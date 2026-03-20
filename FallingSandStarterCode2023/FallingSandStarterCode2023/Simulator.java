import java.awt.*;
import java.util.*;

// Main driver class
// Runs the FallingParticles simulation
public class Simulator
{
  // Main method
  // Creates and runs a new simulator
  public static void main(String[] args) {
      Simulator sim = new Simulator(125, 125);
      sim.run();
  }
  
  // Instance variables
  private Grid grid;
  private ParticleDisplay display;
  private ArrayList<String> classes;
  private int width, height;
  private int x = 125;
  private int y = 125;
  
  private HashMap<String, Color> materialColors = new HashMap<String, Color>();
  
  public Simulator(int width, int height) {
      
    this.width = width;
    this.height = height;
    
    classes = new ArrayList<String>();
    classes.add("Air");
    classes.add("Stone");
    classes.add("Sand");
    classes.add("Water");
    classes.add("Acid");
    classes.add("Wood");
    classes.add("Gravel");
    classes.add("Steam");
    
    display = new ParticleDisplay("Sim", x, y, classes);
    
    materialColors.put("Air", new Color(210, 249, 255));
    materialColors.put("Stone", new Color(166, 166, 166));
    materialColors.put("Sand", new Color(255, 249, 174));
    materialColors.put("Water", new Color(96, 162, 255));
    materialColors.put("Barrier", new Color(0, 0, 0));
    materialColors.put("Acid", new Color(96, 255, 128));
    materialColors.put("Wood", new Color(161, 115, 37));
    materialColors.put("Gravel", new Color(194, 194, 194));
    materialColors.put("Steam", new Color(207, 215, 255));

    grid = new Grid(x, y);
  }
  
  // Called when the user clicks on a location using the given tool
  private void locationClicked(int x, int y, Class tool) {
    // Barriers are permanent
    if (grid.get(x,y) instanceof Barrier) {
      return;
    }
    // Add special cases here, if any

    // Set particle at x,y to new instance of tool
    // Do not modify
    else {
      try {
        grid.set(x, y, (Particle) tool.newInstance());
        grid.get(x,y).initialize(grid, x, y);
      }
      catch (Exception e) {
        System.out.println("Error during instantiation");
        System.out.println(e);
      }
    }
  }

  // Set display colors based on grid
  public void updateDisplay()
  {
    for (int xi = 0; xi < x; xi++) {
      for (int yi = 0; yi < y; yi++) {
          Particle p = grid.get(xi, yi);
          display.setColor(xi, yi, materialColors.get(p.getClass().getSimpleName()));
      }
    }
  }

  // Called repeatedly.
  // Causes one random particle to maybe do something.
  public void step() {
      int newX = (int)(Math.random() * x);
      int newY = (int)(Math.random() * y);
      grid.get(newX, newY).step();
      
  }
  
  //do not modify
  public void run() {
    while (true) {
      for (int i = 0; i < display.getSpeed(); i++) {
        step();
      }
      updateDisplay();
      display.repaint();
      display.pause(1);  //wait for redrawing and for mouse
      int[] mouseLoc = display.getMouseLocation();
      if (mouseLoc != null)  {//test if mouse clicked
        try {
            
          locationClicked(mouseLoc[1], height - (mouseLoc[0]+1), Class.forName(classes.get(display.getTool())));
        }
        catch (Exception e) {
          System.out.println("You added an invalid class name.");
          System.out.println(e);
        }
      }
    }
  }
}
