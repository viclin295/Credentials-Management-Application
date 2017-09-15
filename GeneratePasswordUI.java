
package credentialsapplication;

/**
 *
 * @author Victor
 */
import javax.swing.*;

public class GeneratePasswordUI extends JFrame
{
    public static void GeneratePasswordView()
    {
       GeneratePassword frame = new GeneratePassword();
       frame.setTitle("Generate Password");
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
        
    }
    
}
