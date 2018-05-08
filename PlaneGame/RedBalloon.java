import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author Julia Cook 
 * @version 05/08/18
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

