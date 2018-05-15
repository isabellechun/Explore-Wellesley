import java.awt.*;
import javax.swing.*;
import java.util.*;
/**
 * Write a description of class MapPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapPanel extends JPanel
{
    WellesleyMap mapGraph;
    LinkedList<JButton> linklist;
    
    public MapPanel(){
        initMap(); 
    }
    
    private void initMap(){
        mapGraph = new WellesleyMap();
        linklist = new LinkedList<JButton>();
        
        setBackground(new Color(19,63,132));
        
        //set up the image of the map
        JPanel map = new ImagePanel("Map.jpg");
        map.setOpaque(false);
        add(map);
        
        //set up the buttons
        JPanel links = new JPanel();
        links.setBackground(new Color(19,63,132));
        links.setLayout(new GridLayout(5, 10));
        for(Place p: mapGraph.getPlaces()){
            JButton b = new JButton(p.toString());
            
            b.setForeground(Color.WHITE);
            b.setFont(new Font("Helvetica",Font.PLAIN, 25));
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            
            linklist.add(b);
            links.add(b);
        }
        
        add(links);
    }
    
    public LinkedList<JButton> getLinks(){
        return linklist;
    }
}
