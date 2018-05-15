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
        t.setFont(new Font("Helvetica",Font.PLAIN, 50));
        t.setForeground(Color.WHITE);
        add(t);
        
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setBackground(new java.awt.Color(19,63,132));
        for(String s: buttons){
            JButton b = new JButton(s);
            
            //style buttons
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Helvetica",Font.PLAIN, 25));
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            
            //add buttons
            buttonsContainer.add(b);
            buttonList.add(b);
        }
        add(buttonsContainer);
        
        setLayout(new GridLayout(2,0));
        setPreferredSize(new Dimension(150, 250));
        setBackground(new java.awt.Color(19,63,132));
    }
    
    public InfoBar(String title, String info){
        buttonList = new LinkedList<JButton>();
        
        JLabel t = new JLabel(title, SwingConstants.CENTER);
        t.setFont(new Font("Helvetica",Font.PLAIN, 50));
        t.setForeground(Color.WHITE);
        add(t);
        
        JTextArea i = new JTextArea(info);
        i.setEditable(false);
        i.setFont(new Font("Helvetica",Font.PLAIN, 25));
        i.setForeground(Color.WHITE);
        i.setBackground(new Color(19,63,132));
        i.setLineWrap(true);
        i.setWrapStyleWord(true);
        i.setPreferredSize(new Dimension(500, 500));

        add(i);
        
        setLayout(new GridLayout(2,1));
        setPreferredSize(new Dimension(150, 250));
        setBackground(new java.awt.Color(19,63,132));
    }
    
    public LinkedList<JButton> getButtons(){
        return buttonList;
    }
}
