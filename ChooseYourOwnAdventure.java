import javafoundations.*;

/**
 * ChooseYourOwnAdventure creates a binary tree that allows users to 
 * creae their own unique ~Wellesley experience~.
 *
 * @author Jannitta Yao, Isabelle Chun, Silvia Zeamer
 * @version 5/13/18
 */
public class ChooseYourOwnAdventure
{
    private LinkedBinaryTree<String> adventure;
    
    /**
     * Constructor method; sets up adventure database
     */
    public ChooseYourOwnAdventure(){
        String s1 = "It's 8 am and you just woke up. How do you start your day?";
        String s2 = "You got breakfast and you made it to class. What are you doing after?";
        String s3 = "Oh no! You hit snooze too many times and you woke up 5 minutes before class." 
                        + " What do you do?";
        String s4 = "Lunch with your friends was a lot of fun. What are your plans for the afternoon?";
        String s5 = "You learned a lot from the lecture! What are you doing for the rest of the afternoon?";
        String s6 = "You made it to class with 30 seconds to spare! What are you doing after class?";
        String s7 = "You went back to sleep and work up at 12 pm. What are you doing after you get up?";
        String s8 = "Studying in Clapp was very productive and you got a lot of work done." +
                    " What are your evening plans?";
        String s9 = "You bumped into a friend that you hadn't seen in weeks at Lulu, and had a great " 
                        + "time hanging out with them. What are your evening plans?";
        String s10 = "The weather was beautiful today, and the arboretum even more so. "
                        + "You saw so many cool plants and birds. What are your evening plans?";
        String s11 = "Studying in SCI was very productive and you got a lot of work done." +
                    " What are your evening plans?";
        String s12 = "Lake Waban was so beautiful today, and you got to see so many dogs on your " +
                        "walk around the lake. What are your evening plans?";
        String s13 = "You managed to get a good tan while relaxing in the academic quad with your friends." + 
                            " What are your evening plans?";
        String s14 = "You got a good workout in at the KSC. What are your evening plans?";
        String s15 = "There were a lot of cool pieces at the Davis, and you found a lot of inspiration " +
                         "just walking around the museum. What are your evening plans?";
        String s16 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n75% productive classwork\n25% self-care";
        String s17 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n50% productive classwork\n25% activities with friends\n25% self-care";       
        String s18 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n25% productive classwork\n25% activities with friends\n50% self-care";                    
        String s19 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n50% productive classwork\n50% self-care";
        String s20 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n100% productive classwork";                
        String s21 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n25% productive classwork\n75% self-care"; 
        String s22 = "The day is over! ANALYSIS \n------------\nYou spent your day on" 
                        + "\n100% self-care";  
        
        LinkedBinaryTree<String> n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14;
        
        n1 = new LinkedBinaryTree<String> (s8,
                                           new LinkedBinaryTree<String>(s16),
                                           new LinkedBinaryTree<String>(s17)); 
        n2 = new LinkedBinaryTree<String> (s9,
                                           new LinkedBinaryTree<String>(s17),
                                           new LinkedBinaryTree<String>(s18));                 
        n3 = new LinkedBinaryTree<String> (s10,
                                           new LinkedBinaryTree<String>(s16),
                                           new LinkedBinaryTree<String>(s19)); 
        n4 = new LinkedBinaryTree<String> (s11,
                                           new LinkedBinaryTree<String>(s16),
                                           new LinkedBinaryTree<String>(s20));
        n5 = new LinkedBinaryTree<String> (s12,
                                           new LinkedBinaryTree<String>(s16),
                                           new LinkedBinaryTree<String>(s17));
        n6 = new LinkedBinaryTree<String> (s13,
                                           new LinkedBinaryTree<String>(s17),
                                           new LinkedBinaryTree<String>(s18)); 
        n7 = new LinkedBinaryTree<String> (s14,
                                           new LinkedBinaryTree<String>(s21),
                                           new LinkedBinaryTree<String>(s22));     
        n8 = new LinkedBinaryTree<String> (s15,
                                           new LinkedBinaryTree<String>(s19),
                                           new LinkedBinaryTree<String>(s21));      
        n9 = new LinkedBinaryTree<String> (s4, n1, n2);     
        n10 = new LinkedBinaryTree<String> (s5, n3, n4);    
        n11 = new LinkedBinaryTree<String> (s6, n5, n6);    
        n12 = new LinkedBinaryTree<String> (s7, n7, n8);  
        n13 = new LinkedBinaryTree<String> (s2, n9, n10);
        n14 = new LinkedBinaryTree<String> (s3, n11, n12);
        
        adventure = new LinkedBinaryTree<String> (s1, n13, n14);
        
        
    }
}