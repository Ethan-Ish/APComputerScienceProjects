import java.awt.*;

// Water particles
public class Water extends LiquidParticle {
    
  public Water(){}
  
  public Water(Grid grid, int x, int y){
            super(grid, x, y);      
  }  
  
  public void step(){
      super.step();
  }
  
  // YOUR CODE HERE: write a color() method
}