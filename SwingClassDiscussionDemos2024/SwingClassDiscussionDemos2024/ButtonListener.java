import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class ButtonListener implements ActionListener{
    private JFrame frame;
    
    public ButtonListener(JFrame frame){
        this.frame = frame;
    }
    
    @Override
    // actionPerformed is called an event handler
    public void actionPerformed(ActionEvent e){
        // actionPerformed gets called automatically by the GUI
        // when a button click happens 
        // how do we give ButtonListener access to the JFrame??
        //System.exit(0);
        
        frame.resize((int) (Math.random()* 800) + 50, 
                     (int) (Math.random()* 800) + 50);
    }
    
}
