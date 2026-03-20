import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;


public class WindowComposition   // WindowComposition HAS-A JFrame
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    private JFrame frame;
    private JButton button;
    
    public WindowComposition(){
        frame = new JFrame("my first GUI");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout()); // this is the default layout
        
        button = new JButton("click me if you dare!");
        // register the listener to the button
        button.addActionListener(new ButtonListener(frame));
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    public static void main(){
         new WindowComposition();
        
    }
    
}
