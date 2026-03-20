import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class Window{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 800;
    
    public static void main(){
        JFrame frame = new JFrame("my first GUI");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout()); // this is the default layout
        
        JButton button = new JButton("click me if you dare!");
        // register the listener to the button
        button.addActionListener(new ButtonListener());
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
    
    
}
   