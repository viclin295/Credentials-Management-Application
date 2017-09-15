
package credentialsapplication;

/**
 *
 * @author Victor
 */
public class Database {
    
    String username;
    String password;
    String description;
    
    public Database(String usernameIn, String passwordIn)
    {
        username = usernameIn;
        password = passwordIn;
      
    }
    
    public Database(String usernameIn, String passwordIn, String descriptionIn)
    {
        username = usernameIn;
        password = passwordIn;
        description = descriptionIn;
      
    }
    
    public Database()
    {
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getDescription()
    {
      return description;   
    }
}
