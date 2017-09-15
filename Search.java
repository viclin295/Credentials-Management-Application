
package credentialsapplication;

/**
 *
 * @author Victor
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.regex.*;

public class Search extends JFrame {
    
    JPanel searchPanel = new JPanel();
    JTextArea textArea;
    private JScrollPane scrollPane;
    
    public Search(){
        createComponents();
    }
    
    public void createComponents(){
        
        searchPanel.setLayout(null);
        
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(10, 10, 80, 25);
        searchPanel.add(searchButton);

        JTextField searchText = new JTextField(20);
        searchText.setBounds(100, 10, 160, 25);
        searchPanel.add(searchText);
        
        JButton backButton = new JButton("Go back");
        backButton.setBounds(10, 300, 80, 25);
        searchPanel.add(backButton);
        
        JTextArea textArea = new JTextArea(5,5);
        textArea.setBounds(100, 40, 250, 250);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setEditable(false);
        textArea.setVisible(true);
        
        searchPanel.add(textArea);
        searchPanel.add(scrollPane);
       
        
        add(searchPanel);
                
        backButton.addActionListener((ActionEvent e) -> 
        {
            MainMenuUI.MainMenuUIView();
            dispose();

        });
        
        searchButton.addActionListener((ActionEvent e) -> 
        {
            try{
                SearchDescription q = new SearchDescription();
                String description = searchText.getText().trim();
                readAccountDatabase g = new readAccountDatabase();
                g.setUsernamePassword();
                int i = 0;
                
                if(!(description.equals("")))
                {
                    textArea.setText(null);
                    for (i = 0; i < g.getUsernamePassword().size(); i++)
                    {
                      textArea.append(q.searchDescription(description.toUpperCase())+ "\n");
                    }
                }
                
                else
                {
                    JOptionPane.showMessageDialog(null,
                    "You have blank fields!",
                    "ERROR",
                    JOptionPane.WARNING_MESSAGE);
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}
