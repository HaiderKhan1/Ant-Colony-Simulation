import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{
    public Instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        prepare();
    }
    
    public void prepare() 
    {
        
        //Spawn Objects
        Clickeroo clickeroo = new Clickeroo();
        addObject (clickeroo, 100, 100);
        
        StartButton startButton = new StartButton();
        addObject (startButton, getWidth()/2+10, 675);
        
        // Text
        showText("Instructions", getWidth()/2, 100);
        showText("Press Tab in-game to view total statistics and q to return", getWidth()/2, 200);
        showText("Use Left and Right arrow keys to turn crab", getWidth()/2, 235);
        showText("Use Up and Down arrow keys to control crab movement", getWidth()/2, 270);
        showText("If all spiders are wiped out then you will win!", getWidth()/2, 305);
        showText("However, if all ants are dead you lose...", getWidth()/2, 340);
        showText("Have fun!", getWidth()/2, 375);
        showText("Instructions", getWidth()/2, 100);
    }
}
