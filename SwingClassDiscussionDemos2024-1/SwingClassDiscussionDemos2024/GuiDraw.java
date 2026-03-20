import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// example overriding the paintComponent method to draw on a JPanel
public class GuiDraw extends JFrame{
    
    private DrawPanel drawPanel;
    private JButton button;
    
    public static void main(String[] args){
        new GuiDraw();
    }
    public GuiDraw(){
        setTitle("The Puzzling Plotting Pastel Pink Pterodactyl Peril");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        drawPanel = new DrawPanel();
        
        add(drawPanel, BorderLayout.CENTER);
        
        button = new JButton("click me");
        button.addActionListener( new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e){
                    // instead of invoking paintComponent, call repaint()
                    drawPanel.repaint(); // repaint() calls paintComponent()
                }
                
            });
    
        
        add(button, BorderLayout.NORTH);
        
        // make this JFrame visible
        setVisible(true);
        // drawing happens on components: e.g. 
        // JFrame or JPanel 
        
        // a JPanel already has some drawing that happens: background color, border
        
        
    }
    
    private class DrawPanel extends JPanel{ // use inheritance to change the way it draws
                                            // do all the default draw stuff, and then
                                            // add our own drawing on top of that
                                            
            // paintComponent() is automatically invoked for you by the GUI                                
            @Override
            public void paintComponent(Graphics g){ // Graphics has the fun drawing methods
                // do all drawing stuff from the superclass's paintComponent method
                super.paintComponent(g);
                g.setColor(Color.PINK);
                int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);
                int d = (int) (Math.random() * 100 + 5);
                g.fillOval(x, y, d, d);
            }
                                            
        
    }
}
    