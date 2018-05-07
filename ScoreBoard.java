import greenfoot.*;


import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and several numbers.
 * 
 * @author M Kölling
 * @version 1.0.1
 */
public class ScoreBoard extends Actor
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    
    public ScoreBoard()
    {
        makeImage("Score: ",100);
    }

    
    
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(String title,int score)
    {
         makeImage(title, score);
        
    }
    
    /**
     * Make the score board image.
     */
    private void makeImage(String title,int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);

        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(0, 0, 0, 128));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
        image.drawString(title + score, 60, 100);
       
        setImage(image);
    }
    
    
    
   
}