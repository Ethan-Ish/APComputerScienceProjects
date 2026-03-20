import java.awt.*;

// Abstract base class for fixed particles
public abstract class GasParticle extends Particle {
    
  public GasParticle(){}
  
  public GasParticle(Grid grid, int x, int y){
            super(grid, x, y);
  }
  
  public void step(){
      Particle below = grid.get(x, y - 1);
      Particle above = grid.get(x, y + 1);
      double rand = Math.random();
      if(above.getClass().getSimpleName().equals("Air"))
      {
          
          if(rand > 0.1)
          {
              grid.swap(x, y, x, y + 1);
          }
          
      }
      else if(below.getClass().getSimpleName().equals("Air"))
      {
          
          if(rand <= 0.1)
          {
              grid.swap(x, y, x, y - 1);
          }
          
      }
      else if(above instanceof FixedParticle || above instanceof GravityParticle)
      {
          int offset = -1;
          if(rand < 0.5){
              offset *= -1;
          }
          if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
          {
              grid.swap(x, y, x + offset, y);
          }
          else
          {
              offset *= -1;
              if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
              {
                  grid.swap(x, y, x + offset, y);
              }
          }
      }
      else if(above instanceof GasParticle)
      {
              int offset = -1;
              if(rand < 0.5){
              offset *= -1;
              }
              if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
              {
                  grid.swap(x, y, x + offset, y);
              }
              else
              {
                  offset *= -1;
                  if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
                  {
                      grid.swap(x, y, x + offset, y);
                  }
              }
      }
      else
      {
          int offset = -1;
          if(rand < 0.5){
          offset *= -1;
          }
          if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
          {
              grid.swap(x, y, x + offset, y);
          }
          else
          {
              offset *= -1;
              if(grid.get(x + offset, y).getClass().getSimpleName().equals("Air"))
              {
                  grid.swap(x, y, x + offset, y);
              }
          }
      }
  }
  // Does nothing when stepped
  // YOUR CODE HERE: write an empty step() method
}
