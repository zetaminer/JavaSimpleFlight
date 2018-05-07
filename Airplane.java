import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class airplane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Airplane extends Actor
{
    GreenfootImage image = new GreenfootImage("airplane.png");
    int planeSpeed;
    double width = image.getWidth();
    double height = image.getHeight();
    double scalePercent = -0.4;
    int redScore = 10; //score for hitting red balloon
    int yellowScore = 25; //score for hitting yellow ballon
    double minSize = -.1; //minimum size for balloon to be popped
    double maxSize = 1.2; //maximum size for balloon to be popped
     
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
        scale(scalePercent);
        movePlane();
        balloonCheck();
        world.checkForSpawning();
    }
       
    public void movePlane()
    {
        move(4);
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-3);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
    }
    
    public void balloonCheck()
    {
        MyWorld world = (MyWorld)getWorld();
        double scale;
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
    
    
    public void scale(double percentChange)
    {
        image.scale((int)(width + percentChange*width), (int)(height + percentChange*height)); 
        setImage(image);
    }
    
    
}
