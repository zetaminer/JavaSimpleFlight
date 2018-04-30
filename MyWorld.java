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
    private int spawnTimer = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        
        checkForSpawning();
        
        //addObject(new balloon(),300,200);
        
     }
    
 
    public void checkForSpawning() 
    {
        spawnTimer = spawnTimer+1; 
        int balloonCount = getObjects(balloon.class).size();
        if (spawnTimer%20 == 0 || balloonCount == 0 && balloonCount < 4)
        {
            addObject(new balloon(),300,200);
        }
    }
}
