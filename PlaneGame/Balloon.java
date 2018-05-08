import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ballon here.
 * 
 * @author Julia Cook
 * @version 3.0 05/08/18
 */
public class Balloon extends Actor
{
    GreenfootImage image;
    String imageName;
    int balloonSpeed;
    double width;
    double height;
    double percentChange = 0.1;
    double scalePercent = -0.9;
    double maxScalePercent = 1;
    int degrees = getRandomNumber(0,359);
    public double getScalePercent()
    {
        return scalePercent;
    }
    
    public void setMaxScalePercent(double maxScale)
    {
        this.maxScalePercent = maxScale;
    }
    
    public void setBalloon(String imageName)
    {
        this.image = new GreenfootImage(imageName);
        setImage(image); 
        this.width = (double)(image.getWidth());
        this.height = (double)(image.getHeight());
    }
   
    public void setBalloonSpeed(int speed)
    {
        this.balloonSpeed = speed;
    }
    
    public void setPercentChange(double percentChange)
    {
        this.percentChange = percentChange;
    }
    
    /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld)getWorld();
        //GreenfootImage image = new GreenfootImage("balloon1.png"); WHY DOES THIS CAUSE PIXELATION?
        scale(scalePercent);
        scalePercent += percentChange;
        moveBalloon(balloonSpeed);
        checkEdge();
        world.checkForSpawning();
    }     
    
    public void scale(double percentChange)
    {
        if (percentChange < maxScalePercent)
        {
            image.scale((int)(width + percentChange*width), (int)(height + percentChange*height)); 
            setImage(image);
        }
        else
        {
            image.scale((int)(width + maxScalePercent*width), (int)(height + maxScalePercent*height)); 
            setImage(image);
        }
    }
    
    public void moveBalloon(int balloonSpeed)
    {
        setRotation(degrees);
        turn(getRandomNumber(-20,20));
        move(balloonSpeed);
        setRotation(getRandomNumber(-20,20));
    }
    
    public int getRandomNumber(int start,int end)
    {
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal+start;
    }
    
    public void checkEdge()
    {
        if (isAtEdge())
        {
            MyWorld world = (MyWorld)getWorld();
            getWorld().removeObject(this);
            world.checkForSpawning();
        }
    }
    
    public void popBalloon()
    {
        getWorld().removeObject(this);
    }
}
