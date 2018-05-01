import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private int spawnTimer = 0; //timer for when to spawn new balloons
    private int maxNumberBalloons = 4;  //set the maximum number of balloons.
    public int scenarioSpeed = 30; //set game speed
    public int balloonSpeed = 10;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        checkForSpawning();
        Greenfoot.setSpeed(scenarioSpeed);
    }
    
 
    public void checkForSpawning() 
    {
        spawnTimer = spawnTimer+1; 
        int balloonCount = getObjects(balloon.class).size();
        if ((spawnTimer%20 == 0 || balloonCount == 0) && balloonCount < maxNumberBalloons)
        {
            if (spawnTimer%50 == 0)
            {
                addObject(new yellowBalloon(),300,200);
            }
            else
            {
            addObject(new redBalloon(),300,200);
            }
        }
        
    }
}
