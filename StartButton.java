import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int totalWins = 0;
    public static int totalLoss = 0;
    public static int totalPlayed = 0;
    public void act() 
    {
        click();
    }    
    
    public void click() {
        //Start Screen
        if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == StartScreen.class)) {
         Greenfoot.setWorld(new Game());   
         totalPlayed++;
        }
        
        //Instruction Screen
        else if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == Instructions.class)) {
         Greenfoot.setWorld(new Game());  
         totalPlayed++;
        }
        
        //Game Over Screen
        else if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == EndScreen.class)) {
         Greenfoot.setWorld(new StartScreen());   
         totalLoss++;
         Tracker.flag = 0;
        }        
        
        //Victory screen
        else if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == WinScreen.class)) {
         Greenfoot.setWorld(new StartScreen());   
         totalWins++;
         Tracker.flag = 0;
        }  
    }
}
