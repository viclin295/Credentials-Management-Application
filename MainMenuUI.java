
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainMenuUI
{
    
    public static void MainMenuUIView(){
        
      MainMenu frame = new MainMenu();
      frame.setTitle("Main Menu");
      frame.setSize(500, 200);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    }
}
