import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
/**
 * Class representing a panel in the GUI with a photograph of a place and the 
 * vertices it connects to.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlacePanel extends JPanel
{
    InfoBar info;
    JPanel img;
    
    /**
     * Constructor for the PlacePanel which takes a String with the name
     */
    public PlacePanel(String placePic, LinkedList<String> links, String title){
        initPlace(placePic, links, title);
    }
    
    /**
     * Helper method to initialize the PlacePanel with an ImagePanel
     */
    private void initPlace(String placePic, LinkedList<String> links, String title){
        
        //add image to top
        img = new ImagePanel(placePic);
        add(img);
        
        //add info and navigation to bottom
        info = new InfoBar(links, title);
        add(info);
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    
    public LinkedList<JButton> getButtons(){
        return info.getButtons();
    }
    
    public InfoBar getInfoBar(){
        return info;
    }
}