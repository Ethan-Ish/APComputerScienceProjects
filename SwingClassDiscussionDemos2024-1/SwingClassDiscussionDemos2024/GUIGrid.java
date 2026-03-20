import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GUIGrid extends JFrame { // GUIGrid IS-A JFrame
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    public static final int NUM_BUTTONS = 100;
    private JButton[] buttons; // null
    
    public GUIGrid(){
        //JFrame frame = new JFrame("my first GUI");
        super("my first GUI");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLayout(new GridLayout(10,10));
        //setLayout(new BorderLayout()); // this is the default layout
        
        
        buttons = new JButton[NUM_BUTTONS]; // buttons[0] = null
        
        for (int i = 0; i < NUM_BUTTONS; i++){
            buttons[i]  = new JButton("" + i);
            this.add(buttons[i]);
        }
            
        
        //JButton button = new JButton("click me if you dare!");
        // register the listener to the button
        //button.addActionListener(new ButtonListener());
        //add(button, BorderLayout.SOUTH);
        this.setVisible(true);
        
    }
    
    public static void main(){
        new GUIGrid();    
    }
    
    
}