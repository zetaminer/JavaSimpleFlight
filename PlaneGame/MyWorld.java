import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Dennis DeLuca Jr. and Julia Cook 
 * @version 3.0 05/08/18
 */

public class MyWorld extends World
{  
    private Counter scoreCounter;
    private ScoreBoard scoreBoard;
    private int spawnTimer = 0; // timer for when to spawn new balloons
    private int maxNumberBalloons = 4;  // set the maximum number of balloons.
    public int scenarioSpeed = 30; // set game speed
    private int score = 0; // keeps score
    int redScore = 10; // score for hitting red balloon
    int yellowScore = 25; // score for hitting yellow ballon
    double minSize = -.1; // minimum size for balloon to be popped
    double maxSize = 1.2; // maximum size for balloon to be popped
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setPaintOrder(ScoreBoard.class, Counter.class, Airplane.class, Balloon.class); // Used to make sure that objects are always in front of others.
        prepare();
        checkForSpawning();
        Greenfoot.setSpeed(scenarioSpeed);
    }
   
    /**
     * Getters
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Setters
     */
    public void setScore(int score)
    {
        this.score += score;
        scoreCounter.setValue(this.score);
    }
    
    /**
     * Worked on by Julia Cook
     */
    public void checkForSpawning() 
    {
        spawnTimer = spawnTimer+1; 
        int balloonCount = getObjects(Balloon.class).size();
        if ((spawnTimer%20 == 0 || balloonCount == 0) && balloonCount < maxNumberBalloons)
        {
            if (spawnTimer%50 == 0)
            {
                YellowBalloon yellowBalloon = new YellowBalloon();
                addObject(yellowBalloon,300,200);
            }
            else if (spawnTimer%30 == 0)
            {
                AngryBird angryBird = new AngryBird();
                addObject(angryBird, 300, 200);
            }
            
            else
            {
                RedBalloon redBalloon = new RedBalloon();
                addObject(redBalloon,300,200);
            }
        }
        
    }
    
    public void endGame()
    {
        Greenfoot.stop();
        scoreBoard = new ScoreBoard("         Game Over" + System.lineSeparator() + "           Score: ", score);
        addObject(scoreBoard,300,200);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        scoreCounter = new Counter("Score: ");
        Airplane airplane = new Airplane();
        
        addObject(scoreCounter, 520, 350);
        addObject(airplane, 300, 200);
    }
   
}
