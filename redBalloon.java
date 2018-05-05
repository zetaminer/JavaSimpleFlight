import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    public class RedBalloon extends Balloon
{
    public void act()
    {
       //Balloon redBalloon = new Balloon("balloon1.png",width,height,balloonSpeed); 
       setBalloon("balloon1.png");
       setBalloonSpeed(10);
       super.act();
    }
}     

