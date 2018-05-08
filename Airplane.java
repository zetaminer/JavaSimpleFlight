import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class airplane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Airplane extends Actor
{
    private int redScore = 10; //score for hitting red balloon
    private int yellowScore = 25; //score for hitting yellow ballon
    
    // Images for plane 
    private GreenfootImage defaultView = new GreenfootImage("plane.png");
    private GreenfootImage rightTurn = new GreenfootImage("plane turn right.png");
    private GreenfootImage leftTurn = new GreenfootImage("plane turn left.png");
    private int planeSpeed = 15; 
    
    
   
           
    /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld)getWorld();
        checkKeypress();
        balloonCheck(); 
        world.checkForSpawning();
    }
    
    //checks to see if plane has hit a balloon  
    public void balloonCheck()
    {
        MyWorld world = (MyWorld)getWorld();
        if (isTouching(RedBalloon.class))
        {
            Balloon balloon = (RedBalloon) getOneIntersectingObject(RedBalloon.class);
            if (balloon.getScalePercent() > .1)
            {
                world.setScore(redScore);
                balloon.popBalloon();
            }
        }
        if (isTouching(YellowBalloon.class))
        {
           Balloon balloon = (YellowBalloon) getOneIntersectingObject(YellowBalloon.class);
           if (balloon.getScalePercent() > .1)
           {
               world.setScore(yellowScore);
               balloon.popBalloon();
           }
        }
        if (isTouching(AngryBird.class))
        {
           Balloon balloon = (AngryBird) getOneIntersectingObject(AngryBird.class);
           if (balloon.getScalePercent() > -.9)
           {
               world.birdNoise.play();
               world.endGame();
           }
        }
    }
    
    //method for steering plane and changing plane image.
     public void checkKeypress() //
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setImage(leftTurn);
            setLocation(getX() - planeSpeed, getY()); 
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            setImage(rightTurn);
            setLocation(getX() + planeSpeed, getY()); 
        }
        
        else if (Greenfoot.isKeyDown("up"))
        {
            setImage(defaultView);
            setLocation(getX(), getY() - planeSpeed);      
        }
        
        else if (Greenfoot.isKeyDown("down"))
        {
            setImage(defaultView);
            setLocation(getX(), getY() + planeSpeed);
        }
        else
        {
            setImage(defaultView);
        }
    }
}
