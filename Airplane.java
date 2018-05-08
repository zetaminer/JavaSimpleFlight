import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class airplane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Airplane extends Actor
{
    int redScore = 10; //score for hitting red balloon
    int yellowScore = 25; //score for hitting yellow ballon
    
    // Images to 
    private GreenfootImage defaultView = new GreenfootImage("plane.png");
    private GreenfootImage rightTurn = new GreenfootImage("plane turn right.png");
    private GreenfootImage leftTurn = new GreenfootImage("plane turn left.png");
    private int planeSpeed = 15; 
    
    
    public void setPlaneSpeed(int speed)
    {
        this.planeSpeed = speed;
    }
           
    /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld)getWorld();
        
        checkKeypress();
        //popBalloon(); //Dennis's 
        balloonCheck(); //julia's
        world.checkForSpawning();
    }
      
      
    public void balloonCheck()
    {
        MyWorld world = (MyWorld)getWorld();
        if (isTouching(RedBalloon.class))
        {
            Balloon balloon = (RedBalloon) getOneIntersectingObject(RedBalloon.class);
            if (balloon.scalePercent > .1)
            {
                world.setScore(redScore);
                balloon.popBalloon();
            }
        }
        if (isTouching(YellowBalloon.class))//&& YellowBalloon().scalePercentage > minSize)
        {
           Balloon balloon = (YellowBalloon) getOneIntersectingObject(YellowBalloon.class);
           if (balloon.scalePercent > .1)
           {
               world.setScore(yellowScore);
               balloon.popBalloon();
           }
        }
        if (isTouching(AngryBird.class))//&& YellowBalloon().scalePercentage > minSize)
        {
           Balloon balloon = (AngryBird) getOneIntersectingObject(AngryBird.class);
           if (balloon.scalePercent > -.9)
           {
               world.endGame();
           }
        }
    }
        
   
     public void checkKeypress()
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
    
    public void popBalloon()
    {
        RedBalloon red = (RedBalloon) getOneIntersectingObject(RedBalloon.class);
        if (red != null && red.percentChange > 1.0)
        {
            getWorld().removeObject(red);
        }
        
        YellowBalloon yellow = (YellowBalloon) getOneIntersectingObject(YellowBalloon.class);
        if (yellow != null && yellow.percentChange > 1.0)
        {
            getWorld().removeObject(yellow);
        }
    } 
}
