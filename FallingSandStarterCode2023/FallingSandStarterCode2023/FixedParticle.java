import java.awt.*;

// Abstract base class for fixed particles
public abstract class FixedParticle extends Particle {
    
  public FixedParticle(){}
  
  public FixedParticle(Grid grid, int x, int y){
            super(grid, x, y);      
  }
  // Does nothing when stepped
  // YOUR CODE HERE: write an empty step() method
}