
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

public class Account extends JFrame{

   JPanel accountPanel = new JPanel();
   
   public Account()
   {
        createComponents();
   }
   
   public void createComponents(){
       
       accountPanel.setLayout(null);
            
            //user field
            JLabel userLabel = new JLabel("User");
            userLabel.setBounds(10, 10, 80, 25);
            accountPanel.add(userLabel);

            JTextField userText = new JTextField(20);
            userText.setBounds(100, 10, 160, 25);
            accountPanel.add(userText);
               
            //password fields
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(10, 40, 80, 25);
            accountPanel.add(passwordLabel);

            JTextField passwordText = new JTextField(20);
            passwordText.setBounds(100, 40, 160, 25);
            accountPanel.add(passwordText);

            JLabel passwordLabel2 = new JLabel("Re-enter");
            passwordLabel2.setBounds(10, 70, 80, 25);
            accountPanel.add(passwordLabel2);

            JTextField passwordText2 = new JTextField(20);
            passwordText2.setBounds(100, 70, 160, 25);
            accountPanel.add(passwordText2);
            
            //description field
            JLabel descriptionLabel = new JLabel("Description");
            descriptionLabel.setBounds(10, 100, 80, 25);
            accountPanel.add(descriptionLabel);
            
            JTextField descriptionText = new JTextField(20);
            descriptionText.setBounds(100, 100, 160, 25);
            accountPanel.add(descriptionText);
               
            //back button
            JButton backButton = new JButton("Go back");
            backButton.setBounds(10, 150, 80, 25);
            accountPanel.add(backButton);

            JButton registerButton = new JButton("Store");
            registerButton.setBounds(100, 150, 80, 25);
            accountPanel.add(registerButton);

            add(accountPanel);
            
            backButton.addActionListener((ActionEvent e) -> 
            {
                MainMenuUI.MainMenuUIView();
                dispose();
            });
            
            registerButton.addActionListener((ActionEvent e) -> {
                    
                try {
                    
                  
                    String username = userText.getText().trim();
                    String password = passwordText.getText().trim();
                    String description = descriptionText.getText().trim();
                    
                    Database d = new Database();
                    readAccountDatabase p = new readAccountDatabase(username, password,description);
                    
                           if(!(username.equals("") ||password.equals("") || description.equals("")))
                           {
                                if (passwordText.getText().equals(passwordText2.getText()))
                                {
                                    
                                    p.writeToText();
                                    JOptionPane.showMessageDialog(null,
                                    "Account has been created.",
                                    "Success!",
                                    JOptionPane.PLAIN_MESSAGE);
                                    userText.setText("");
                                    passwordText.setText("");
                                    passwordText2.setText("");
                                    descriptionText.setText("");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null,
                                    "Password does not match!",
                                    "ERROR",
                                    JOptionPane.WARNING_MESSAGE);
                                    passwordText.setText("");
                                    passwordText2.setText("");
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(null,
                                "You have blank fields!",
                                "ERROR",
                                JOptionPane.WARNING_MESSAGE);
                           }
                           
                       } catch (IOException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
   }
    
}
