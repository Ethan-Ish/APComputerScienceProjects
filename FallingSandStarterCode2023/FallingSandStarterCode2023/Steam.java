import java.awt.*;

// Steam particles
public class Steam extends GasParticle {
    
  public Steam(){}
  
  public  Steam(Grid grid, int x, int y){
            super(grid, x, y);      
  }
  
  public void step(){
      super.step();
      Particle above = grid.get(x, y + 1);
      double rand = Math.random();
      double rand1 = Math.random();
      if(above.getClass().getSimpleName().equals("Steam"))
      {
          if(rand < 0.01 && rand1 < 0.01)
          {
              Particle newPart;
              newPart = new Water(grid, x, y);
              grid.set(x, y, newPart);
          }
      }
  }
  // YOUR CODE HERE: write a color() method
}
