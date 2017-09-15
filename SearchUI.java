
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

public class SearchUI extends JFrame {
    
    public static void SearchUIView(){
        
        Search frame = new Search();
        frame.setTitle("Search");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
