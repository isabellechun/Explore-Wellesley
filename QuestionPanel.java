import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class QuestionPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class QuestionPanel
{
    LinkedList<String> buttons;
    String lAnswer;
    String rAnswer;
    String rQ;
    String lQ;
    public QuestionPanel(Question q){
        buttons = new LinkedList<String>();
        buttons.add(q.getLeftAnswer());
        buttons.add(q.getRightAnswer());
        
        //InfoBar contents = new InfoBar()
    }
}
