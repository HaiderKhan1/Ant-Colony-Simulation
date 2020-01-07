import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatScreen extends World
{
    World world;
    Game game;
    /**
     * Constructor for objects of class StatScreen.
     * 
     */
    public StatScreen(World returnWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        world = returnWorld;
    }
    
    public void act()
    {
        processKeys();
        text();
    }    
    
    public void processKeys() 
    {
        if (Greenfoot.isKeyDown("q")) 
        {
            Greenfoot.setWorld(world);
        }   
    }    
    
    public void text() 
    {
        showText("Total Stats", getWidth()/2, 100);
        showText("Total Wins: "+StartButton.totalWins, 200, 200);
        showText("Total Losses: "+StartButton.totalLoss, 800, 200);
        showText("Total Spider Kills: "+Spider.spiderDeath, 200, 300);
        showText("Total Ant Kills: "+Tracker.totalAntDeath, 800, 300);
        showText("Total Times Played: "+StartButton.totalPlayed, 200, 400);   
    }
}
