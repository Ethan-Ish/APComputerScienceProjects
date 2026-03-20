import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.util.Arrays;

public class DiceRollHist
{
    
    private static JFrame frame = new JFrame("MainWin");
    
    //
        
    private static JLabel inputTitle = new JLabel("Number of rolls: ");
    
    private static JTextField inputField = new JTextField(10);
        
    private static JPanel input = new JPanel();
    
    private static Color background1 = Color.decode("#52489C");
    private static Color background2 = Color.decode("#4062bb");
    private static Color textColor = Color.decode("#f45b69");
    private static Color barColor = Color.decode("#59c3c3");
    
    //
    
    private static int[] rolls = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    
    private static void roll()
    {
        int roll1 = (int) (Math.floor(Math.random() * 6));
        roll1 += 1;
        int roll2 = (int) (Math.floor(Math.random() * 6));
        roll2 += 1;
        int fullRoll = roll1 + roll2;
        rolls[fullRoll - 2] = rolls[fullRoll - 2] + 1;
    }
    
    //
    
    private static int barSize = 50;
    private static int space = 5;
    
    private static int counter = 0;
    
    private static JButton button = new JButton("Roll dice");
    
    private static int tryParse(String in)
    {
        int output = 0;
        try {
            output = Integer.parseInt(in);
        }
        catch(Exception e) {
            output = -1;
        }
        return output;
    }
    
    public static void main(String[] args){
        //
        class drawPanel extends JPanel{ // use inheritance to change the way it draws
            @Override
            public void paintComponent(Graphics g){ // Graphics has the fun drawing methods
                // do all drawing stuff from the superclass's paintComponent method
                super.paintComponent(g);
                //setBackground(background2);
                int x = 0;
                x += space * 4;
                int max = -1;
                int maxI = -1;
                for(int i = 0; i < rolls.length; i++)
                {
                    if(rolls[i] >= max)
                    {
                        max = rolls[i];
                        maxI = i;
                    }
                }
                for(int i = 0; i < rolls.length; i++)
                {
                    int roll = rolls[i];
                    int h = 0;
                    if(max != 0){
                        h = (int) Math.round(200 * ((double)roll / (double)max));
                    }
                    g.setColor(barColor);
                    g.fillRect(x, getHeight() - 20 - h, barSize, h);
                    g.setColor(Color.black);
                    g.drawString(Integer.toString(i + 2), x + (barSize / 2) - 4, getHeight() - 5);
                    x += barSize + space;
                }
            }
        }
        //
        
        //
        frame.setSize(((barSize * 11) + (space * (rolls.length + 8))), 300); //1084 is a specific number, dont question it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        drawPanel display = new drawPanel();
        input.add(inputTitle);
        input.add(inputField);
        frame.add(input, BorderLayout.NORTH);
        //input.setBackground(background1);
        //inputTitle.setForeground(textColor);
        button.setOpaque(true);
        //button.setBackground(background1);
        //button.setForeground(textColor);
        frame.add(display, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        
        button.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                int tryCount = tryParse(inputField.getText());
                if(tryCount >= 0)
                {
                    rolls = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    counter = tryCount;
                }

            }
        });
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(counter > 0)
                {
                    counter -= 1;
                    roll();
                }
                display.repaint();
            }
        };
        Timer timer = new Timer(10 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();
        
        frame.setVisible(true);
        
        //
    }
    
}
