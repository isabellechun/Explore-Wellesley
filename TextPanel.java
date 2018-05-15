import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class TextPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextPanel extends JPanel
{
    public TextPanel(String t){
        initTextPanel(t);
    }
    
    public void initTextPanel(String t){
        JLabel text = new JLabel(t, SwingConstants.CENTER);
        setForeground(Color.WHITE);
        setBackground(new Color(19,63,132));
        add(text);
    }
}
