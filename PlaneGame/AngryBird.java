import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AngryBird here.
 * 
 * @author Julia Cook
 * @version 05/08/18
 */
public class AngryBird extends Balloon
{
    /**
     * Act - do whatever the AngryBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       setBalloon("Angry_Bird.png");
       setBalloonSpeed(10);
       setMaxScalePercent(-.85); //set the maximum scale size of the image
       super.act();
    }    
}
