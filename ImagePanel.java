import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
/**
 * Write a description of class HomePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ImagePanel extends JPanel
{
    Image img; 
    public ImagePanel(String imageFile){
        super();
        initImagePanel(imageFile);
    }
    
    public void initImagePanel(String imageFile){
        try{
            img = ImageIO.read(new File(imageFile));
            
        }
        catch(IOException e){
            System.out.println("Image not found");
        }
        
        setBackground(new Color(19,63,132));
        setPreferredSize(new Dimension(1500,1000));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (this.getWidth() - img.getWidth(null)) / 2;
        int y = (this.getHeight() - img.getHeight(null)) / 2;
        g.drawImage(img, x, y, this);
    }
}
