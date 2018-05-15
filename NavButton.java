import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Write a description of class NavButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NavButton extends JButton
{
    public NavButton(String title){
        super(title);
        initNavButton();
    }
    
    public void initNavButton(){
        //style the button
        setForeground(Color.WHITE);
        setFont(new Font("Helvetica",Font.PLAIN, 50));
        setBackground(new Color(216, 207, 195));
    }
}
