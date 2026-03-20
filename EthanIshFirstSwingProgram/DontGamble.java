import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DontGamble
{
    
    private static JFrame frame = new JFrame("MainWin");
        
    private static JLabel text = new JLabel("", SwingConstants.CENTER);
        
    private static JPanel grid = new JPanel();
    
    private static int buttonNumber = 3;
    
    private static int winnings = 0;
    
    private static int jackpotValue = 1000;
    
    private static int jackpotGoal = 50;
    
    private static int clickCount = 0;
    private static Integer[] clicks = new Integer[buttonNumber];
    private static JButton[][] buttonArray = new JButton[buttonNumber][buttonNumber];
    private static Integer[][] numberArray = new Integer[buttonNumber][buttonNumber];
    
    public static void clickButton(int i, int j)
    {
        buttonArray[i][j].setText("" + numberArray[i][j]);
        clicks[clickCount] = numberArray[i][j];
        clickCount += 1;
        if(clickCount == buttonNumber)
        {
            disableAllButtons();
            checkWin();
        }
    }
    
    public static void disableAllButtons()
    {
        for (int i = 0; i < buttonNumber; i++){
            for(int j = 0; j < buttonNumber; j++)
            {
                buttonArray[i][j].setEnabled(false);
            }
        }
    }
    
    public static void checkWin()
    {
        int oddCount = 0;
        boolean jackpot = false;
        for(int i = 0; i < buttonNumber; i++){
            if((clicks[i] % 2) != 0)
            {
                oddCount += 1;
            }
            if((clicks[i] == jackpotGoal)) { jackpot = true; };
        }
        winnings = (oddCount * 20) + (int)(Math.pow(2, (oddCount - 1)));
        if(oddCount == 1) {
            winnings -= 1;
        }
        if(jackpot)
        {
            winnings += jackpotValue;
        }
        if(winnings == 0)
        {
            JOptionPane.showMessageDialog(null, "Womp womp, you got nothing :(");
        }
        else if(jackpot)
        {
            JOptionPane.showMessageDialog(null, "OMIGOSH U GOT BIG JAKPOT LOOK $" + winnings);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "you won money yay :D $" + winnings);
        }
    }
    
    public static void main(String[] args)
    {
        //
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //
        text.setText("Select three tiles! (Gambling is injurious to financial health.)");
        //
        grid.setLayout(new GridLayout(buttonNumber, buttonNumber));
        
        for (int i = 0; i < buttonNumber; i++){
            for(int j = 0; j < buttonNumber; j++)
            {
                numberArray[i][j] = 1 + (int)(Math.round(Math.random() * 50));
                if( (int)(Math.round(Math.random() * 10)) == 1)
                {
                    numberArray[i][j] = 50;
                }
                JButton button = new JButton("");
                final int index = i;
                final int jindex = j;
                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        clickButton(index, jindex);
                    }
                });
                buttonArray[i][j] = button;
                grid.add(buttonArray[i][j]);
            }
        }
        //
        frame.add(text, BorderLayout.NORTH);
        frame.add(grid, BorderLayout.CENTER);
        frame.setVisible(true);
        //

    }
    
}
