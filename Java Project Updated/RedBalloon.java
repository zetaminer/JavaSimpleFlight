import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RedBalloon is subclass of Ballon
 * 
 * @author (Julia Cook) 
 * @version (v2)
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
  

