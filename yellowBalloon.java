import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ballon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
