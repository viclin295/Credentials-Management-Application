
package credentialsapplication;



/**
 *
 * @author Victor
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
   
public class readAccountDatabase extends Database {
    
    ArrayList<Database> accountList = new ArrayList(); 
    
    public readAccountDatabase(String usernameIn, String passwordIn, String descriptionIn)
    {
        super(usernameIn, passwordIn, descriptionIn);
         
    }
    
    readAccountDatabase()
    {
    }
    
    public void readToArray() throws FileNotFoundException
    {
        String inputFileName = "AccountList.txt";
        String readUsername = "";
        String readPassword = "";
        String readDescription = "";
        int i = 1;
        
        File inputFile = new File(inputFileName);
        Scanner inFile = new Scanner(inputFile);

        while(inFile.hasNextLine())
        {
            readUsername = inFile.next();
            readPassword = inFile.next();
            readDescription = inFile.next();
            
            Database userPass = new Database(readUsername, readPassword, readDescription);
            accountList.add(userPass);
        }
        inFile.close();
    }
    
    public void writeToText() throws IOException
    {
        String outputFileName = "AccountList.txt";

        File outputFile = new File(outputFileName);
        PrintWriter out = new PrintWriter(new FileWriter(outputFile, true));
        out.println();
        out.printf("%s %15s %15s", username, password, description);
        System.out.printf("%s %15s %15s", username, password, description);
        out.close();
    }
    
    public void setUsernamePassword() throws FileNotFoundException
    {
        readToArray();
    }
    
    public ArrayList<Database> getUsernamePassword() throws FileNotFoundException
    {
        return accountList;
    }
    
}
    

