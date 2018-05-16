import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import java.io.*;

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
    ChooseYourOwnAdventure adventure;
    QuestionPanel quiz;
    JPanel map;
    JPanel home;
    JPanel about;
    
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
        home = new PlacePanel("Photographs/home.jpg", links, "");
        addPlaceListeners((PlacePanel)home);
        
        //set up the map panel
        map = new MapPanel();
        for(JButton b: ((MapPanel)map).getLinks()){
            b.addActionListener(new PlaceListener());
        }
        
        //set up the current location panel
        update();
        
        //set up the info panel
       String info = "Choose Explore mode to learn about buildings and fun places on Wellesley’s campus!" +
       "Click on buildings listed in the legend at the bottom left corner of the map to learn about them."+
       "You’ll find a fun fact and a list of other places they’re connected to!"+
       "Choose quiz mode to take a short quiz that takes you through a day of activities at Wellesley!"+
       "Click on your answer to advance to the next question."+
       "Once you’re done, you’ll find out what portion of your day was spent on academics, having fun with friends, and on self-care."+
       "You’ll also get a list of places you visited during your day at Wellesley.";
       
       //set up the choose your own adventure panel
       adventure = new ChooseYourOwnAdventure();
       quiz = new QuestionPanel(adventure.getCurrentQuestion());
       for(JButton b: quiz.getButtons()){
           b.addActionListener(new QuizListener());
        }
       
       // try{
            // Scanner scan = new Scanner(new File("about.txt"));
            // while(scan.hasNextLine()){
                // System.out.println(scan.nextLine());
                // //info = info + scan.next();
            // }
            // scan.close();
       // }
       // catch(FileNotFoundException e){
           // System.out.println("File not found.");
        // }
        
       about = new InfoBar("About",info);
        
        
        //add elements to the card layout
        content.add(home, "HOME");
        content.add(map, "MAP");
        content.add(currentPlace, "CPLACE");
        content.add(about, "ABOUT");
        content.add(quiz, "QUIZ");
        
        //start with the home page
        goHome();
        
        //set up NavBar action listeners
        nav.getHome().addActionListener(new NavListener());
        nav.getMap().addActionListener(new NavListener());
        nav.getEnter().addActionListener(new NavListener());
        nav.getAbout().addActionListener(new NavListener());
    }
    
    public void update(){
        Place cp = mapGraph.getCurrentPlace();
        
        //make a LinkedList of attached places
        LinkedList<String> linkedNames = new LinkedList<String>();
        for(Place p: mapGraph.requestNeighbors(cp)){
            linkedNames.add(p.toString());
        }
        
        //System.out.println(linkedNames);
        
        //make a PlacePanel
        currentPlace = new PlacePanel(cp.getPhoto(), linkedNames, cp.toString());
        //System.out.println(cp.getPhoto());
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
        content.removeAll();
        content.add(home, "HOME");
        cardLayout.show(content, "HOME");
        content.repaint();
        content.revalidate();
    }
    
    public void goToMap(){
        content.removeAll();
        content.add(map, "MAP");
        cardLayout.show(content, "MAP");
        content.repaint();
        content.revalidate();
    }
    
    public void returnToPlace(){
        content.removeAll();
        content.add(currentPlace, "CPLACE");
        cardLayout.show(content, "CPLACE");
        content.repaint();
        content.revalidate();
    }
    
    public void goToAbout(){
        content.removeAll();
        content.add(about, "ABOUT");
        cardLayout.show(content, "ABOUT");
        content.repaint();
        content.revalidate();
    }
    
    public void goToQuiz(){
        content.removeAll();
        quiz = new QuestionPanel(adventure.getCurrentQuestion());
        if(!adventure.getCurrentQuestion().isLeaf()){
            for(JButton b: quiz.getButtons()){
               b.addActionListener(new QuizListener());
            }
    }
        content.add(quiz);
        cardLayout.show(content, "QUIZ");
        content.repaint();
        content.revalidate();
    }
        
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
            else{
                goToAbout();
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
            else if(action=="Adventure"){
                    goToQuiz();
            }
            else{
                mapGraph.setCurrentPlace(action);
                // System.out.println(mapGraph.getCurrentPlace());
                update();
                returnToPlace();
            }
        }
    }
    
    public class QuizListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand() == "l"){
                adventure.answerQuestion("l");
                goToQuiz();
            }
            else if(e.getActionCommand() == "r"){
                adventure.answerQuestion("r");
                goToQuiz();
            }
        }
    }
}