import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class AdventurePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdventurePanel extends JPanel
{
    String text;
    ChooseYourOwnAdventure adventure;
    
    public AdventurePanel(String s, ChooseYourOwnAdventure c){
        text = s;
        adventure = c;
        
        String left = "";
        
        JLabel textLabel = new JLabel(text);
        add(textLabel);
    }
}
