import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

// using inner classes for our ActionListener's
public class GUInner //implements ActionListener   // GUI HAS-A JFrame; GUI IS-A ActionListener
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private JFrame frame;
    private JButton buttonOne, buttonTwo, buttonThree;
    private JPanel panel;
    
    private class FirstButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.resize((int) (Math.random()* 800) + 50, 
                    (int) (Math.random()* 800) + 50);            
        }   
    }
    
    private class SecondButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.getContentPane().setBackground(new Color(150, 255, 150));
        }   
    }
    
    private class ThirdButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);    
        }   
    }
   
    
    public GUInner(){
        frame = new JFrame("my first GUI");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout()); // this is the default layout
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        buttonOne = new JButton("one");
        //buttonOne.setActionCommand("arugula");
        buttonTwo = new JButton("two");
        buttonThree = new JButton("three");
        buttonOne.addActionListener(new FirstButtonListener());
        buttonTwo.addActionListener(new SecondButtonListener());
        buttonThree.addActionListener(new ThirdButtonListener());        
        //buttonOne.addActionListener(this);
        //buttonTwo.addActionListener(this);
        //buttonThree.addActionListener(this);
        
        
        panel.add(buttonOne);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        
        // add panel to the SOUTH region of frame's GridLayout
        
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
        
        
        //button = new JButton("click me if you dare!");
        // register the listener to the button
        //button.addActionListener(new ButtonListener(frame));
        //button.addActionListener(this);
        //frame.add(button, BorderLayout.SOUTH);
        
    }
    
    
    /*
    @Override
    // actionPerformed is called an event handler
    public void actionPerformed(ActionEvent e){
        // actionPerformed gets called automatically by the GUI
        // when a button click happens 
        // how do we give ButtonListener access to the JFrame??
        //System.exit(0);
        //frame.resize(0,0);
        
        // how do we distunguish between which button fires the event
        if (e.getActionCommand().equals("one"))
            frame.resize((int) (Math.random()* 800) + 50, 
                    (int) (Math.random()* 800) + 50);
        else if (e.getActionCommand().equals("two"))
            frame.getContentPane().setBackground(new Color(150, 255, 150));
        else if (e.getActionCommand().equals("three"))
            frame.getContentPane().setBackground(Color.LIGHT_GRAY);
            
    }*/
    
    
    public static void main(){
         new GUInner();
        
    }
    
}
