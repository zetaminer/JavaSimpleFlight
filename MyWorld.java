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
    
    private Counter scoreCounter;
    private ScoreBoard scoreBoard;
    private int spawnTimer = 0; //timer for when to spawn new balloons
    private int maxNumberBalloons = 4;  //set the maximum number of balloons.
    public int scenarioSpeed = 30; //set game speed
    private int score = 0; //keeps score
    
    int redScore = 10; //score for hitting red balloon
    int yellowScore = 25; //score for hitting yellow ballon
    
    GreenfootSound popNoise = new GreenfootSound("balloonPop.mp3");
    GreenfootSound birdNoise = new GreenfootSound("bird.mp3");
    Airplane airplane = new Airplane();
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 520, 350);
        addObject(airplane, 300, 350);
        checkForSpawning();
        Greenfoot.setSpeed(scenarioSpeed);
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score += score;
        scoreCounter.setValue(this.score);
    }
 
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
            else if (spawnTimer%60 == 0)
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
        
        scoreBoard = new ScoreBoard("Score: ", score);
        addObject(scoreBoard,300,200);
    }
}
