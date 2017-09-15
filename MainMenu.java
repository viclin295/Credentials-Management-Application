
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

public class MainMenu extends JFrame {
    
   private static final int FRAME_WIDTH = 500;
   private static final int FRAME_HEIGHT = 500;
   
   JPanel MainMenuPanel = new JPanel();
   JPanel northPanel = new JPanel();
   
   public MainMenu()
   {
       createComponents();
   }
   
   private void createComponents()
   {
       MainMenuPanel.setLayout(new BorderLayout());
       
       JButton logoutButton = new JButton("Logout");
       northPanel.add(logoutButton, BorderLayout.NORTH);
       
       JButton generateButton = new JButton("Generate Password");
       northPanel.add(generateButton, BorderLayout.NORTH);
       
       JButton accountButton = new JButton("Store Credentials");
       northPanel.add(accountButton, BorderLayout.NORTH);
       
       JButton searchButton = new JButton("Search");
       northPanel.add(searchButton, BorderLayout.NORTH);
       
       MainMenuPanel.add(northPanel, BorderLayout.NORTH);
       add(MainMenuPanel);
       
       logoutButton.addActionListener((ActionEvent e)->
       {
           CredentialsApplication.loginView();
           
           LoginUI gui = new LoginUI();
           AESCrypt ae = null;
           try {
               File originalFile = new File("AccountList.txt");
               ae = new AESCrypt(gui.getPasswordIn());
               ae.encrypt(1, "AccountList.txt", "encryptAccountList.txt");
               originalFile.delete();
               
               ae = new AESCrypt(gui.getPasswordIn());
           } catch (GeneralSecurityException ex) {
               Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedEncodingException ex) {
               Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           dispose();
               
       });
       
       generateButton.addActionListener((ActionEvent e)->
       {
           GeneratePasswordUI.GeneratePasswordView();
           dispose();
       });
       
       accountButton.addActionListener((ActionEvent e)->
       {
           AccountUI.AccountUIView();
           dispose();
               
       });
       
       searchButton.addActionListener((ActionEvent e)->
       {
           SearchUI.SearchUIView();
           dispose();
               
       });
   }
   
   
}
