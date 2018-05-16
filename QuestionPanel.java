import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class QuestionPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionPanel extends JPanel
{
    LinkedList<String> buttons;
    LinkedList<JButton> JButtons;
    String lAnswer;
    String rAnswer;
    String rQ;
    String lQ;
    ChooseYourOwnAdventure adventure;
    public QuestionPanel(Question q, ChooseYourOwnAdventure a){
        //create a ChooseYourOwnAdventure Instance to get info from
        adventure = a;
        
        //create a LinkedList of the button names
        buttons = new LinkedList<String>();
        buttons.add(q.getLeftAnswer());
        buttons.add(q.getRightAnswer());
        
        //access the place associated with this question
        
        //add the picture associated with this questionś location
        
        
        //make an InfoBar with this question
        if(q.isLeaf()){
            InfoBar contents = new InfoBar(adventure.getQueue(), q.getQuestion(),"Analysis");
            add(contents);
        }
        else{
            InfoBar contents = new InfoBar(buttons, q.getQuestion());
            contents.getButtons().get(0).setActionCommand("l");
            contents.getButtons().get(1).setActionCommand("r");
            JButtons = contents.getButtons();
            add(contents);
       }
       setLayout(new GridLayout(1,1));
    }
    
    public LinkedList<JButton> getButtons(){
        return JButtons;
    }
}
