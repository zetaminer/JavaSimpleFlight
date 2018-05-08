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
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setPaintOrder(Plane.class, RedBalloon.class, YellowBalloon.class);
        checkForSpawning();
        Greenfoot.setSpeed(scenarioSpeed);

        prepare();
    }
    
    public void checkForSpawning() 
    {
        spawnTimer = spawnTimer+1; 
        int balloonCount = getObjects(Balloon.class).size();
        if ((spawnTimer%20 == 0 || balloonCount == 0) && balloonCount < maxNumberBalloons)
        {
            if (spawnTimer%50 == 0)
            {
                addObject(new YellowBalloon(),300,200);
            }
            else
            {
            addObject(new RedBalloon(),300,200);
            }
        }
        
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Plane plane = new Plane();
        addObject(plane,300,300);
        plane.setLocation(300,300);
    }
}
