
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.regex.*;

public class GeneratePassword extends JFrame
{
    private JButton generate;
    private JButton backButton;
    private JLabel passLength;
    private JTextField length;
    private JTextArea resultArea;
    private JCheckBox symbols;
    
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 150;
    
    public GeneratePassword(){
        resultArea = new JTextArea(2,26);
        resultArea.setEditable(false);
        
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    class generatePassword implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            
            int passwordLength = Integer.parseInt(length.getText());
            
            if (e.getSource() == generate)
            {
                makePassword(passwordLength);
            }
            else
            {
                resultArea.setText("Please enter a value.");
            }
            resultArea.setText(makePassword(passwordLength));
        }
    }
    
    private void createComponents(){
        
        JPanel genPanel = new JPanel();
        passLength = new JLabel("Enter length of password");
        length = new JTextField(10);
        generate = new JButton("Generate");
        symbols = new JCheckBox("Symbols");
        
        ActionListener listener = new generatePassword();
        generate.addActionListener(listener);
        symbols.addActionListener(listener);
        
        //add button and panels
        genPanel.add(length);
        genPanel.add(passLength);
        genPanel.add(resultArea);
        genPanel.add(generate);
        genPanel.add(symbols);
        
        JButton backButton = new JButton("Go Back");
        backButton.setBounds(10, 150, 80, 25);
        genPanel.add(backButton);
        
        add(genPanel);
        
        backButton.addActionListener((ActionEvent e) -> 
        {
            MainMenuUI.MainMenuUIView();
            dispose();
        });
    }
    
    public String makePassword(int passwordLength)
    {
        String password = "";
		
	for (int i = 0; i < passwordLength - 2; i++)
	{
		password = password + randomCharacter("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                        
                String randomDigit = randomCharacter("0123456789");
                password = insertAtRandom(password, randomDigit);
                
                if (symbols.isSelected()){
                String randomSymbol = randomCharacter("+-*/?!@#$%&");
                password = insertAtRandom(password, randomSymbol);
                }
                
        }
                
        return password;
    }
	
    //character creation
    public static String randomCharacter(String characters)
    {
            int n = characters.length();
            int r = (int) (n * Math.random());
            return characters.substring(r, r + 1);
    }

    //digit insertion
    public static String insertAtRandom(String str, String toInsert)
    {
        int n = str.length();
        int r = (int) ((n+ 1) * Math.random());
        return str.substring(0, r) + toInsert + str.substring(r);

    }
}
