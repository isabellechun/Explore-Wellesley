import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class PlacePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlacePanel extends JPanel
{
    InfoBar info;
    JPanel img;
    
    public PlacePanel(String placePic, LinkedList<String> links, String title){
        initPlace(placePic, links, title);
    }
    
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