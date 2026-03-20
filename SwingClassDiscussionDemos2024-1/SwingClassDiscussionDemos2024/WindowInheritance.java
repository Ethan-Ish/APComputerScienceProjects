import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class WindowInheritance extends JFrame { // WindowInheritance IS-A JFrame
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    
    public WindowInheritance(){
        //JFrame frame = new JFrame("my first GUI");
        super("my first GUI");

        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout()); // this is the default layout
        
        JButton button = new JButton("click me if you dare!");
        // register the listener to the button
        button.addActionListener(new ButtonListener(this));
        add(button, BorderLayout.SOUTH);
        setVisible(true);
        
    }
    
    public static void main(){
        new WindowInheritance();    
    }
    
    
}