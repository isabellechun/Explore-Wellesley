import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class InfoBar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InfoBar extends JPanel
{
    LinkedList<JButton> buttonList;
    
    public InfoBar(LinkedList<String> buttons, String title){
        buttonList = new LinkedList<JButton>();
        initInfo(buttons, title);
    }
    
    private void initInfo(LinkedList<String> buttons, String title){
        
        
        //add elements
        JLabel t = new JLabel(title, SwingConstants.CENTER);
        t.setFont(new Font("Helvetica",Font.PLAIN, 35));
        t.setForeground(Color.WHITE);
        add(t);
        
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setBackground(new java.awt.Color(19,63,132));
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
