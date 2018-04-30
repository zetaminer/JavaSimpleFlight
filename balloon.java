import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ballon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class balloon extends Actor
{
    GreenfootImage image = new GreenfootImage("balloon1.png");
    double percentChange = -0.9;
    double width = (double)(image.getWidth());
    double height =(double)(image.getHeight());
    int degrees = getRandomNumber(0,359);
    
    
     /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
       MyWorld world = (MyWorld)getWorld();
       //GreenfootImage image = new GreenfootImage("balloon1.png"); WHY DOES THIS CAUSE PIXELATION?
        scale(percentChange);
        percentChange += .1;
        moveBalloon();
        checkEdge();
        world.checkForSpawning();
        Greenfoot.delay(1);
       
       
           }     
    public void scale(double percentChange)
    {
        GreenfootImage image = new GreenfootImage("balloon1.png");
        image.scale((int)(width + percentChange*width), (int)(height + percentChange*height)); 
        setImage(image);
    }
    public void moveBalloon()
    {
        setRotation(degrees);
        turn(getRandomNumber(-20,20));
        move(10);
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
            getWorld().removeObject(this);
            MyWorld world = (MyWorld)getWorld();
            world.checkForSpawning();
            // world.addObject(new balloon(),300,200);
        }
    }
}
