/**
 *
 * @author Victor
 */
package credentialsapplication;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AccountUI extends JFrame {
    
    public static void AccountUIView(){
        
        Account frame = new Account();
        frame.setTitle("Add Accounts");
        frame.setSize(400,250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
