
 

/**
 * Question class creates Question objects that have a question and a Place 
 * associated with them 
 *
 * @author Jannitta Yao
 * @version 5/14/18
 */
public class Question
{
    String question, Lanswer, Ranswer;
    Place Lplace, Rplace;
    
    /**
     * Constructor method 
     */
    public Question(String q, String a1, String a2, Place p1, Place p2){
        question = q;
        Lplace = p1;
        Rplace = p2;
        Lanswer = a1;
        Ranswer = a2;
    }
    
    /**
     * getQuestion returns the question associated with the Question class
     * 
     * @return String question
     */
    public String getQuestion(){
        return question;
    }
    
    public Place getLeftPlace(){
        return Lplace;
    }
    
    public Place getRightPlace(){
        return Rplace;
    }
    
    public String getRightAnswer(){
        return Ranswer;
    }
    
    public String getLeftAnswer(){
        return Lanswer;
    }
}