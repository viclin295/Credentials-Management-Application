
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class RegistrationUI extends JFrame
{
    public static void RegistrationUIView(){
        
      Registration frame = new Registration();
      frame.setTitle("Registration");
      frame.setSize(400,185);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    }
    
}
