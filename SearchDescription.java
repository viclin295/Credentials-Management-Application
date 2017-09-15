
package credentialsapplication;
import java.io.*; 

/**
 *
 * @author Victor
 */
public class SearchDescription {
    
    public String searchDescription(String descriptionIn) throws FileNotFoundException, IOException
    {
        String found = "";
        readAccountDatabase o = new readAccountDatabase();
        o.setUsernamePassword();
        
        for(int i = 0; i < o.getUsernamePassword().size(); i++)
        {
            if (descriptionIn.equals(o.getUsernamePassword().get(i).getDescription().toUpperCase()) || descriptionIn.equals(o.getUsernamePassword().get(i).getUsername().toUpperCase())
                    || descriptionIn.equals(o.getUsernamePassword().get(i).getPassword().toUpperCase()))
            {
                found = "" + o.getUsernamePassword().get(i).getDescription() + " " + o.getUsernamePassword().get(i).getUsername()
                        + o.getUsernamePassword().get(i).getPassword();
            }
            else
            {
                found += "Information not found!";
            }
            
        }

        return found;
    }
    
}
