
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.io.*;

public class Authenticate {
    
    public boolean authenticate(String usernameIn, String passwordIn) throws FileNotFoundException 
    {
        readDatabase userList = new readDatabase();
        userList.setUsernamePassword();
        boolean authenticated = false;
        
        for(int i = 0; i < userList.getUsernamePassword().size(); i++)
        {
            if (usernameIn.equals(userList.getUsernamePassword().get(i).getUsername()) && passwordIn.equals(userList.getUsernamePassword().get(i).getPassword()))
            {
                authenticated = true;
                break;
            }
        }
        return authenticated;
    }
    
}
