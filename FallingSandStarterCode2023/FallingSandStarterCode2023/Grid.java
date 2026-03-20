// A grid of particles
public class Grid {
  // Instance Variables
  private Particle[][] world;
  private int width, height;

  // Main constructor
  public Grid(int width, int height) {
    this.width = width;
    this.height = height;

    world = new Particle[height][width];

    // fill with air particles
    // and add barriers along edges
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
          world[y][x] = new Air(this, x, y);
          if(x == 0 || x == width - 1)
          {
              world[y][x] = new Barrier(this, x, y);
          }
          if(y == 0 || y == height - 1)
          {
              world[y][x] = new Barrier(this, x, y);
          }
      }
    }
  }

  // Grid accessor and mutator
  public Particle get(int x, int y) {
    return world[y][x];
  }
  public void set(int x, int y, Particle value) {
    world[y][x] = value;
  }

  // Utility method to swap particles
  public void swap(int x1, int y1, int x2, int y2) {
    Particle p1 = get(x1, y1);
    Particle p2 = get(x2, y2);
    set(x1, y1, p2);
    set(x2, y2, p1);

    // Pass new coords (do not edit)
    get(x1, y1).moveTo(x1,y1);
    get(x2, y2).moveTo(x2, y2);
  }
}