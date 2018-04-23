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
       while (isAtEdge() == false)  // change to isAtEdge == False
       {
        //GreenfootImage image = new GreenfootImage("balloon1.png");
        scaling(percentChange);
        percentChange += .1;
        moveBalloon();
        Greenfoot.delay(5);
       }
       getWorld().removeObject(this);
    }     
    public void scaling(double percentChange)
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
    }
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
