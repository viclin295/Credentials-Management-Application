
package credentialsapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.regex.*;

/**
 *
 * @author Victor
 */
public class Registration extends JFrame
{
    JPanel registerPanel = new JPanel(); 
    
    public Registration()
    {
        placeComponents();
    }
    
    public void placeComponents()
    {
        registerPanel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		registerPanel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		registerPanel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		registerPanel.add(passwordLabel);

		JTextField passwordText = new JTextField(20);
		passwordText.setBounds(100, 40, 160, 25);
		registerPanel.add(passwordText);
                
                JLabel passwordLabel2 = new JLabel("Re-enter");
		passwordLabel2.setBounds(10, 70, 80, 25);
		registerPanel.add(passwordLabel2);
                
                JTextField passwordText2 = new JTextField(20);
		passwordText2.setBounds(100, 70, 160, 25);
		registerPanel.add(passwordText2);

		JButton backButton = new JButton("go back");
		backButton.setBounds(10, 100, 80, 25);
		registerPanel.add(backButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(100, 100, 80, 25);
		registerPanel.add(registerButton);
                
                add(registerPanel);
                
                backButton.addActionListener((ActionEvent e) -> 
                {
                    CredentialsApplication.loginView();
                    dispose();
                    
                });
                
                registerButton.addActionListener((ActionEvent e) -> {
                    
                try {
                    readDatabase r = new readDatabase(userText.getText(), passwordText.getText());
                    CheckUsers k = new CheckUsers();
                    String username = userText.getText().trim();
                    String password = passwordText.getText().trim();
                    
                    
                           if(!(username.equals("") ||password.equals("")))
                           {
                                if (passwordText.getText().equals(passwordText2.getText()))
                                {
                                    if (!(k.userTaken(username, password))){
                                        r.writeToText();
                                        JOptionPane.showMessageDialog(null,
                                        "User has been created.",
                                        "Success!",
                                        JOptionPane.PLAIN_MESSAGE);
                                        userText.setText("");
                                        passwordText.setText("");
                                        passwordText2.setText("");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,
                                        "The username is taken!",
                                        "ERROR",
                                        JOptionPane.WARNING_MESSAGE);
                                        userText.setText("");
                                        passwordText.setText("");
                                        passwordText2.setText("");
                                    }
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
