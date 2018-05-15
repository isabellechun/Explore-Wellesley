import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class WellesleyGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WellesleyGUI
{
    
        public static void main(String[] args) {
        //start a new window
        EventQueue.invokeLater(() -> {
            
            WellesleyAdventure w = new WellesleyAdventure();
            w.setVisible(true);
        });
    }
}
