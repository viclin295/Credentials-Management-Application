
package credentialsapplication;
import java.io.*; 
/**
 *
 * @author Victor
 */
public class CheckUsers {
    
    public boolean userTaken(String usernameIn, String PasswordIn) throws FileNotFoundException, IOException
    {
        boolean used = false;
        readDatabase j = new readDatabase();
        j.setUsernamePassword();
        
        for(int i = 0; i < j.getUsernamePassword().size(); i++)
        {
            if (usernameIn.equals(j.getUsernamePassword().get(i).getUsername()))
            {
                used = true;
            }
        }

        return used;
    }
}
