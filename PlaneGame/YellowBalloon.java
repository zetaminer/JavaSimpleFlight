import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ballon here.
 * 
 * @author Julia Cook 
 * @version 3.0 05/08/18
 */
public class YellowBalloon extends Balloon
{
    public void act()
    {
        setBalloon("balloon3.png");
        setBalloonSpeed(15);
        setPercentChange(.15);
        super.act();
    }
}
