import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

// example using an inner ActionListener class and JTextField and JLabel
public class TemperatureConverter extends JFrame {
    private JTextField fField;
    private JTextField cField;
    
    
    
    private class ButtonListener implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent e){
            // take the input from fField
            try{
                double fahrenheit = Double.parseDouble(fField.getText());
                double celsius = (fahrenheit - 32)*5/9;    // wait....5/9 = 0 in Java   
                // F = 9/5C + 32
                cField.setText("" + celsius); // Double.toString(celsius);
            }
            catch (NumberFormatException exception){
                cField.setText("What do you think a number IS??? Fool!");
                JOptionPane.showMessageDialog(cField, "not a number");
            }
        }
        
    }
    
    public TemperatureConverter(){
        setTitle("Tremilliamilliamilliatrecentretriginmilliamilliatrecentretriginmilliatrecendotrigintillion by Tremilliamilliamilliatrecentretriginmilliamilliatrecentretriginmilliatrecendotrigintillion");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));
        
        // components
        JLabel fLabel = new JLabel("Faherenheit: ");
        fField = new JTextField(10);
        JLabel cLabel = new JLabel("Celsius: ");
        cField = new JTextField(10);
        JLabel emptyLabel = new JLabel("");
        JButton button = new JButton("convert");
        button.addActionListener(new ButtonListener());
  
        // add the components to this JFrame
        add(fLabel);
        add(fField);
        add(cLabel);
        add(cField);
        add(emptyLabel);
        add(button);
        
        
        setVisible(true);
        
        
        
        
    }
    
    public static void main(String[] args){
        TemperatureConverter tc = new TemperatureConverter(); 
    }
    
}