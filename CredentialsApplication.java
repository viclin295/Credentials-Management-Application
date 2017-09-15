
package credentialsapplication;

/**
 * @author Victor
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class CredentialsApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        loginView();
    }
    
    public static void loginView()
    {
        JFrame frame = new LoginUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,175);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Enter Your Credentials");
        frame.setVisible(true);
    }
    
    
}
