import java.awt.*;
/**
 * Write a description of class Acid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Acid extends LiquidParticle 
{
    public Acid(){}
  
  public Acid(Grid grid, int x, int y){
            super(grid, x, y);      
  }  
    
  public String getName(Particle par)
  {
      return par.getClass().getSimpleName();
  }
  
      private boolean canMelt(Particle par)
      {
          return (par instanceof GravityParticle || ((par instanceof FixedParticle) && !(getName(par).equals("Air") || getName(par).equals("Barrier"))));
      }
      
    public void step(){
        Particle below = grid.get(x, y - 1);
        Particle above = grid.get(x, y + 1);
        Particle left = grid.get(x-1, y);
        Particle right = grid.get(x+1, y);
        double rand = Math.random();
        boolean used;
        
        // If it's above a solid particle and it's not air or barrier
        if(canMelt(below))
        {
            Air newAir = new Air(grid, x, y - 1);
            grid.set(x, y-1, newAir);
            used = true;
        }
        else if(canMelt(above))
        {
            Air newAir = new Air(grid, x, y + 1);
            grid.set(x, y+1, newAir);
            used = true;
        }
        else if(canMelt(right))
        {
            Air newAir = new Air(grid, x, y);
            grid.set(x+1, y, newAir);
            used = true;
        }
        else if(canMelt(left))
        {
            Air newAir = new Air(grid, x, y);
            grid.set(x-1, y, newAir);
            used = true;
        }
        else
        {
            super.liquidSim("Air", true);
            super.liquidSim("Water", false);
            used = false;
        }
        if(used)
        {  
            Particle newPart;
            newPart = new Air(grid, x, y);
            /*if(rand > 0.5)
            {
                newPart = new Water(grid, x, y);
            }
            else
            {
                newPart = new Air(grid, x, y);
            }*/
            grid.set(x, y, newPart);
        }
    }
}
