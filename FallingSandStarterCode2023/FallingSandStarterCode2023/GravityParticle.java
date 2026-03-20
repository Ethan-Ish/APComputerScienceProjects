import java.awt.*;

// Abstract base class for gravity particles
public abstract class GravityParticle extends Particle {
    
  public GravityParticle(){}
    
  public GravityParticle(Grid grid, int x, int y){
            super(grid, x, y);      
  }  
  
  public void step() {
      Particle below = grid.get(x, y - 1);
      if(below.getClass().getSimpleName().equals("Air") || below instanceof LiquidParticle)
      {
          grid.swap(x, y, x, y - 1);
      }
  }
}