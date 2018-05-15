import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class InfoBar here.
 *
 * @author (your name)
 * @ 5-15-18
 */
public class InfoBar extends JPanel
{
    LinkedList<JButton> buttonList;
    
    /**
     * InfoBar constructor
     * @param buttons is a list of every button that an InfoBar will contain
     * @param title is the title of this InfoBar panel
     */
    public InfoBar(LinkedList<String> buttons, String title){
        buttonList = new LinkedList<JButton>();
        initInfo(buttons, title);
    }
    
    /**
     * initInfo is a helper method for InfoBar constructor.
     * updates the contents of an InfoBar panel.
     * 
     * @params buttons is a list of 
     * @params title is the main header of this panel.
     */
    private void initInfo(LinkedList<String> buttons, String title){
        
        //add title
        JLabel t = new JLabel(title, SwingConstants.CENTER); 
        t.setFont(new Font("Helvetica",Font.PLAIN, 35));
        t.setForeground(Color.WHITE);
        add(t);
        
        JLabel connectionsLabel = new JLabel("Connections:", SwingConstants.CENTER);
        connectionsLabel.setFont(new Font("Helvetica",Font.PLAIN, 25));
        connectionsLabel.setForeground(Color.WHITE);
        add(connectionsLabel);
        
        JPanel buttonsContainer = new JPanel(); //initialize new sub-panel for each place button
        buttonsContainer.setBackground(new java.awt.Color(19,63,132));
        //add each button from LinkedList to buttonsContainer sub-panel
        for(String s: buttons){ 
            JButton b = new JButton(s);
            b.setActionCommand(s);
            
            //style buttons
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Helvetica",Font.PLAIN, 50));
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            
            //add buttons
            buttonList.add(b);
            buttonsContainer.add(b);
        }
        add(buttonsContainer);
        
        setLayout(new GridLayout(2,0));
        setPreferredSize(new Dimension(150, 250));
        setBackground(new java.awt.Color(19,63,132));
    }
    
    public LinkedList<JButton> getButtons(){
        return buttonList;
    }
}
