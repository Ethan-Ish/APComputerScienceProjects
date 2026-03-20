import java.util.*;
import java.awt.*;

// Abstract base class for liqudid particles
public abstract class LiquidParticle extends Particle {
    
  public LiquidParticle(){}
  
  public LiquidParticle(Grid grid, int x, int y){
            super(grid, x, y);      
  }  
  // Randomly move left, right, or down
  public void step() {
      liquidSim("Air", true);
  }

  public void liquidSim(String air, boolean grav)
  {
      Particle below = grid.get(x, y - 1);
      Particle above = grid.get(x, y + 1);
      if(below.getClass().getSimpleName().equals(air) || below instanceof GasParticle)
      {
          if(!grav)
          {
              double rand = Math.random();
            if(rand < 0.5){
                  grid.swap(x, y, x, y - 1);
              }
            }
            else
            {
                grid.swap(x, y, x, y - 1);
            }
          
      }
      else if(above.getClass().getSimpleName().equals(air) && !grav)
      {
          double rand = Math.random();
          if(above.getClass().getSimpleName().equals(air))
              {
                  grid.swap(x, y, x, y + 1);
              }
      }
      else if(below instanceof FixedParticle || below instanceof GravityParticle)
      {
          double rand = Math.random();
          int offset = -1;
          if(rand < 0.5){
              offset *= -1;
          }
          if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
          {
              grid.swap(x, y, x + offset, y);
          }
          else
          {
              offset *= -1;
              if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
              {
                  grid.swap(x, y, x + offset, y);
              }
          }
      }
      else if(below instanceof LiquidParticle || below instanceof GasParticle)
      {
              double rand = Math.random();
              int offset = -1;
              if(rand < 0.5){
              offset *= -1;
              }
              if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
              {
                  grid.swap(x, y, x + offset, y);
              }
              else
              {
                  offset *= -1;
                  if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
                  {
                      grid.swap(x, y, x + offset, y);
                  }
              }
      }
      else
      {
      double rand = Math.random();
      int offset = -1;
      if(rand < 0.5){
      offset *= -1;
      }
      if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
      {
          grid.swap(x, y, x + offset, y);
      }
      else
      {
          offset *= -1;
          if(grid.get(x + offset, y).getClass().getSimpleName().equals(air))
          {
              grid.swap(x, y, x + offset, y);
          }
      }
      }
  }
  
  // Note: you may want to write a trySwap() helper method here
  // to make your code more concise, but you don't need to.
}