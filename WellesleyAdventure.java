import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;

/**
 * Write a description of class NavBar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WellesleyAdventure extends JFrame
{
    JPanel content;
    CardLayout cardLayout;
    JPanel currentPlace;
    JPanel currentQuestion;
    NavBar nav;
    WellesleyMap mapGraph;
    
    public WellesleyAdventure(){
        initUI();
    }

    private void initUI() {
        //set up the underlying graph
        mapGraph = new WellesleyMap();
        
        //set up the window
        setTitle("Choose Your Wellesley Adventure");
        setSize(2000, 1400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new java.awt.Color(19,63,132));
  
        //add the navigation bar
        nav = new NavBar();
        add(nav, BorderLayout.LINE_START);
        
        //set up the content
        content = new JPanel();
        cardLayout = new CardLayout();
        content.setLayout(cardLayout);
        add(content);
        
        //set up the home panel
        LinkedList<String> links = new LinkedList<String>(Arrays.asList("Explore", "Adventure"));
        JPanel home = new PlacePanel("Photographs/home.jpg", links, "");
        addPlaceListeners((PlacePanel)home);
        
        //set up the map panel
        JPanel map = new MapPanel();
        for(JButton b: ((MapPanel)map).getLinks()){
            b.addActionListener(new PlaceListener());
        }
        
        //set up the current location panel
        update();
        
        //add elements to the card layout
        content.add(home, "HOME");
        content.add(map, "MAP");
        content.add(currentPlace, "CPLACE");
        
        //start with the home page
        goHome();
        
        //set up NavBar action listeners
        nav.getHome().addActionListener(new NavListener());
        nav.getMap().addActionListener(new NavListener());
        nav.getEnter().addActionListener(new NavListener());
        
    }
    
    public void update(){
        Place cp = mapGraph.getCurrentPlace();
        
        //make a LinkedList of attached places
        LinkedList<String> linkedNames = new LinkedList<String>();
        for(Place p: mapGraph.requestNeighbors(cp)){
            linkedNames.add(p.toString());
        }
        
        System.out.println(linkedNames);
        
        //make a PlacePanel
        currentPlace = new PlacePanel(cp.getPhoto(), linkedNames, cp.toString());
        System.out.println(cp.getPhoto());
        //add actionlisteners to all the buttons
        addPlaceListeners((PlacePanel)currentPlace);
    }
    
    public void addPlaceListeners(PlacePanel p){
        for(JButton j: ((PlacePanel)p).getButtons()){
            j.addActionListener(new PlaceListener());
        }
       
    }
    
    public NavBar getNav(){
        return nav;
    }
    
    public void goHome(){
        cardLayout.show(content, "HOME");
    }
    
    public void goToMap(){
        cardLayout.show(content, "MAP");
    }
    
    public void returnToPlace(){
        content.add(currentPlace, "CPLACE");
        cardLayout.show(content, "CPLACE");
    }
    
    // public void setPlaceListeners(){
        // //get the pannel in content
        // PlacePanel currentPlace = content.
        // //for each link in it, add a listener
    // }
        
    public class NavListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            returnToPlace();
            //handle actionsevents from the nav bar
            if(e.getSource() == nav.getHome()){
                goHome();
            }
            else if(e.getSource() == nav.getMap()){
                goToMap();
            }
            else if(e.getSource() == nav.getEnter()){
                returnToPlace();
            }
        }
    }
    
    public class PlaceListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action=="Explore"){
                   update();
                   returnToPlace();
                } 
            // else if(action=="Adventure"){
                
            // }
            else{
                mapGraph.setCurrentPlace(action);
                // System.out.println(mapGraph.getCurrentPlace());
                update();
                returnToPlace();
            }
        }
    }
}
