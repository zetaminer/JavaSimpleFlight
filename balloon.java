import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ballon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balloon extends Actor
{
    GreenfootImage image;
    //String imageName;
    private int balloonSpeed; // distance plane moves each act
    private double width; //holder for image width
    private double height; //holder for image height
    private double percentChange = 0.1; //change in image scale for each act
    private double scalePercent = -0.9; //keeps current scaling percent
    private double maxScalePercent = 1; 
    private int degrees = getRandomNumber(0,359); //used to send balloons off in all directions
            
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
        MyWorld world = (MyWorld)getWorld();
        world.popNoise.play();
        getWorld().removeObject(this);
    }
}
