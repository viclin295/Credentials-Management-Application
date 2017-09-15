
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class readDatabase extends Database {
    
    ArrayList<Database> userList = new ArrayList();
    
    public readDatabase(String usernameIn, String passwordIn)
    {
        super(usernameIn, passwordIn);
    }
    
    readDatabase()
    {
    }
    
    public void readToArray() throws FileNotFoundException
    {
        String inputFileName = "UsersList.txt";
        String readUsername = "";
        String readPassword = "";
        int i = 1;
        
        File inputFile = new File(inputFileName);
        Scanner inFile = new Scanner(inputFile);

        while(inFile.hasNextLine())
        {
            readUsername = inFile.next();
            readPassword = inFile.next();
            
            Database userPass = new Database(readUsername, readPassword);
            userList.add(userPass);
        }
        inFile.close();
    }
    
    public void writeToText() throws IOException
    {
        String outputFileName = "UsersList.txt";

        File outputFile = new File(outputFileName);
        PrintWriter out = new PrintWriter(new FileWriter(outputFile, true));
        out.println();
        out.printf("%s %15s", username, password);
        System.out.printf("%s %15s", username, password);
        out.close();
    }
    
    public void setUsernamePassword() throws FileNotFoundException
    {
        readToArray();
    }
    
    public ArrayList<Database> getUsernamePassword() throws FileNotFoundException
    {
        return userList;
    }
    
}
