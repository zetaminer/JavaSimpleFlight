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
    }
       
    public void movePlane()
    {
        move(4);
        balloonCheck();
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
            
            RedBallon balloon = (Balloon) getOneIntersectingObject(RedBalloon.class);
            scale = 
            removeTouching(getOneIntersectingObject(RedBalloon.class));
            
            world.setScore(redScore);
            
        }
        if (isTouching(YellowBalloon.class))// && YellowBalloon().scalePercentage > minSize)
        {
            //removeObject(RedBalloon());
            world.setScore(yellowScore);
        }
    }
    
    public void scale(double percentChange)
    {
        image.scale((int)(width + percentChange*width), (int)(height + percentChange*height)); 
        setImage(image);
    }
    
    
}
