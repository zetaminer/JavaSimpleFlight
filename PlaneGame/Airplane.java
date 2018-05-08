import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the Airplane. It's the actor being controlled by the user and is tasked to pop balloons
 * and avoid the birds for as long as possible.
 * 
 * @author Dennis DeLuca Jr. 
 * @version 3.0 05/08/18
 */
public class Airplane extends Actor
{
    int redScore = 10; //score for hitting red balloon
    int yellowScore = 25; //score for hitting yellow balloon

    // Plane sprites for the different keypress
    private GreenfootImage defaultView = new GreenfootImage("plane.png");
    private GreenfootImage rightTurn = new GreenfootImage("plane turn right.png");
    private GreenfootImage leftTurn = new GreenfootImage("plane turn left.png");
    
    // Game sounds
    private GreenfootSound pop = new GreenfootSound("balloonPop.mp3"); // Plays when a ballon pops
    private GreenfootSound birdSquawk = new GreenfootSound("bird.mp3"); // Plays when a bird is hit/Game Over

    private int planeSpeed = 15; // Plane Speed 

    /**
     * Act - do whatever the ballon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld)getWorld();
        checkKeypress();
        popBalloon();
        world.checkForSpawning();
    }
    
    /**
     * Check if one of the arrow keys have been pressed and react accordingly to it.
     */
    public void checkKeypress()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setImage(leftTurn);
            setLocation(getX() - planeSpeed, getY());
        }

        else if (Greenfoot.isKeyDown("right"))
        {
            setImage(rightTurn);
            setLocation(getX() + planeSpeed, getY());
        }

        else if (Greenfoot.isKeyDown("up"))
        {
            setImage(defaultView);
            setLocation(getX(), getY() - planeSpeed);      
        }

        else if (Greenfoot.isKeyDown("down"))
        {
            setImage(defaultView);
            setLocation(getX(), getY() + planeSpeed);
        }

        else
        {
            setImage(defaultView);  
        }
    }
    
    /**
     * Checks if the airplane is touching any object from the Balloon class at a certain scale
     * and acts accordingly if both conditions are met.
     */
    public void popBalloon()
    {
        MyWorld world = (MyWorld)getWorld();
        RedBalloon red = (RedBalloon) getOneIntersectingObject(RedBalloon.class);
        YellowBalloon yellow = (YellowBalloon) getOneIntersectingObject(YellowBalloon.class);
        Balloon bird = (AngryBird) getOneIntersectingObject(AngryBird.class);
        
        // If the red ballon is not empty and the scale is greater than, or equal to .8
        if (red != null && red.scalePercent >= .8)
        {
            pop.play(); // Plays ballonPop.mp3
            world.removeObject(red); // Removes the sprite from the world.
            world.setScore(redScore); // Adds points to the score counter.
        }

        // If the yellow ballon is not empty and the scale is greater than, or equal to .8
        if (yellow != null && yellow.scalePercent >= .8)
        {
            pop.play(); // Plays ballonPop.mp3
            world.removeObject(yellow); // Removes the sprite from the world.
            world.setScore(redScore); // Adds points to the score counter.
        }

        // If the angry bird is not empty and the scale is greater than, or equal to -.5
        if (bird != null && bird.scalePercent >= -.5)
        {
            birdSquawk.play(); // Plays bird.mp3
            world.endGame(); // Ends the game and shows the Game Over Screen.
        }
    } 
}
