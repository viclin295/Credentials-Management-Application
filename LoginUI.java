
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LoginUI extends JFrame
{
    JPanel loginPanel = new JPanel();
    JPasswordField passwordText;
    
    public LoginUI()
    {
        placeComponents();
    }
    
      public void placeComponents() 
      {
		loginPanel.setLayout(null);

		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		loginPanel.add(userLabel);

		JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		loginPanel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		loginPanel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		loginPanel.add(passwordText);

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		loginPanel.add(loginButton);
		
		JButton registerButton = new JButton("register");
		registerButton.setBounds(100, 80, 80, 25);
		loginPanel.add(registerButton);
                
                add(loginPanel);
                
                loginButton.addActionListener((ActionEvent e) -> 
                {
                String password = new String(passwordText.getPassword());
                Authenticate a = new Authenticate();
                
                LoginUI gui = new LoginUI();
                AESCrypt de = null;
                    
                    try {
                    File originalFile = new File("encryptAccountList.txt");
                    de = new AESCrypt(gui.getPasswordIn());
                    de.decrypt("encryptAccountList.txt", "AccountList.txt");
                    originalFile.delete();
                    } catch (GeneralSecurityException ex) {
                         Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                         Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                    try {
                        if (a.authenticate(userText.getText(), password))
                        {
                            MainMenuUI.MainMenuUIView();
                            JOptionPane.showMessageDialog(null,
                            "Login Success.",
                            "Success!",
                            JOptionPane.PLAIN_MESSAGE);
                            dispose();
                            
                        }   
                        else {
                            JOptionPane.showMessageDialog(null,
                            "Incorrect Username or Password.",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                            userText.setText("");
                            passwordText.setText("");
                        }
                        } catch (FileNotFoundException ex) {
                        Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                   
                });
                
                registerButton.addActionListener((ActionEvent e) -> 
                {
                    RegistrationUI.RegistrationUIView();
                    dispose();
                    
                });
	}
        
        public String getPasswordIn()
        {
            return new String (passwordText.getPassword()).trim();
        }

}
