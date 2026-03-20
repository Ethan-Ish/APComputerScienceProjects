import java.awt.*;

// Abstract base class for particles
public abstract class Particle {
  // Instance variables
  public Grid grid;
  public int x, y;
  
  /**
   * Note: if using the default construtor, a call to the
   * initialize() method is necessary to initialize the instance variables
   */
  public Particle(){}
      
  public Particle(Grid grid, int x, int y){
            this.grid = grid;
            this.x = x;
            this.y = y;     
  }

  // Initialize instance variables: alternative to using a constructor
  public void initialize(Grid grid, int x, int y) {
    this.grid = grid;
    this.x = x;
    this.y = y;
  }

  // Update coordinates
  public void moveTo(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // Swap with another particle
  public void swapWith(int x2, int y2) {
    // YOUR CODE HERE: use grid.swap to swap with (x2, y2)
  }

  public void step() {};
  
  // Returns the current color of the particle
  // YOUR CODE HERE: add an abstract color() method
}