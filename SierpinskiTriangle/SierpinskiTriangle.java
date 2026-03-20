import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.*;

public class SierpinskiTriangle
{
    
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1200;
    private JFrame window;
    private JButton startButton;
    private JPanel buttonPanel, textPanel;
    private JTextField text;
    private JTextArea textArea;
    private GraphicsPanel graphicsPanel;
    private Timer timer;
    private int depth = 1;
    
    private class GraphicsPanel extends JPanel{
        private int x = 15, y = 15, deltax = 1, deltay = 1;
        
        public GraphicsPanel(){
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            draw(g,depth,((getWidth()-20)/2) + 10, 10, 10, getHeight() - 10, getWidth() - 10, getHeight() - 10);
   
        }     
    }
    
    public static int[] midpoint(int x0, int y0, int x1, int y1)
    {
        int newX = (x1 + x0)/2;
        int newY = (y1 + y0)/2;
        return new int[]{newX, newY};
    }
    
    /**
     *  draw an H tree
     *  @param n  the depth of the tree
     *  @param length the length of the line segments that form the H
     *  @param x the x coordinate of the center of the H
     *  @param y the y coordinate of the center of the H
     */ 
    public static void draw(Graphics g, int n, int x0, int y0, int x1, int y1, int x2, int y2){
        if (n == 0) return;        
        // draw an H
        g.drawLine(x0,y0, x1, y1);
        g.drawLine(x1,y1, x2, y2);
        g.drawLine(x2,y2,x0,y0);
        
        /*draw(g,n-1,length/2, x1,y1);  // draw H-Tree on upper right corner
        draw(g,n-1,length/2, x1,y0);  // draw H-Tree on  lower right corner
        draw(g,n-1,length/2, x0,y0);  // draw H-Tree on lower left corner
        draw(g,n-1,length/2, x0,y1);  // draw H-Tree on  upper left corner*/
        int[] point0 = midpoint(x0, y0, x1, y1);
        int[] point1 = midpoint(x1,y1, x2, y2);
        int[] point2 = midpoint(x2,y2,x0,y0);
        draw(g, n-1, point0[0], point0[1], x1, y1, point1[0], point1[1]);
        draw(g, n-1, x0, y0, point0[0], point0[1], point2[0], point2[1]);
        draw(g, n-1, point2[0], point2[1], point1[0], point1[1], x2, y2);
    }
    
    private class ButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            //graphicsPanel.setVisible(true);
            depth = Integer.parseInt(text.getText());
            window.repaint();
        }
    
    }

    public SierpinskiTriangle(){
        window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setTitle("Sierpinski Triangle");
        
        window.setLayout(new BorderLayout()); // default 

        // add a JPanel containing a button to the SOUTH region of the JFrame
        JPanel buttonPanel = new JPanel();
        startButton = new JButton("draw");
        startButton.setSize(5,15);
        startButton.addActionListener(new ButtonListener());
        buttonPanel.add(startButton);
        window.add(buttonPanel, BorderLayout.SOUTH);
        
     
        // add the JPannel containing the JButton and JLabel to the NORTH region of the JFrame
        textPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("depth: ");
        text = new JTextField(10); // at least 15 characters
        textPanel.add(nameLabel);
        textPanel.add(text);
        window.add(textPanel, BorderLayout.NORTH);

        // add the JPanel used for drawing to the CENTER region of the JFrame
        graphicsPanel = new GraphicsPanel();
        //graphicsPanel.setDoubleBuffered(false);
        window.add(graphicsPanel, BorderLayout.CENTER);

        // When you create the timer, you specify an action listener to be notified 
        // when the timer "goes off". The actionPerformed method in this listener 
        // should contain the code for whatever task you need to be performed.
        //timer = new Timer(100, graphicsListener);
        //timer.start();
        
        //graphicsPanel = new GraphicsPanel();
        //window.add(graphicsPanel, BorderLayout.CENTER);
        //window.add(textArea, BorderLayout.CENTER);
         
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
 
    }
     
    public static void main(String[] args){
        RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);

        SierpinskiTriangle gui = new SierpinskiTriangle();
    }
    
}
