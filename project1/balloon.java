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
     /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       //image.scale(10,10);
       //setImage(image);
       while (isAtEdge() == false)
       {
        setImage(image);
        GreenfootImage image = new GreenfootImage("balloon1.png");
        scaling(percentChange);
        percentChange += .1;
        Greenfoot.delay(1);
       }
        
    } 
    public void scaling(double percentChange)
    {
        image.scale((int)(width + percentChange*width), (int)(height + percentChange*height)); 
    }
    public void moving()
    {
        
    }
}
