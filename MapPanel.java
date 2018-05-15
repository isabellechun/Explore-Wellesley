import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class MapPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapPanel extends JPanel
{
    public MapPanel(){
        initMap(); 
    }
    
    private void initMap(){
        JPanel map = new ImagePanel("Map.jpg");
        add(map);
        
        JPanel links = new JPanel();
    }
}
