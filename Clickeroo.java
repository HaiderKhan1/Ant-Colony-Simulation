
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Clickeroo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Clickeroo extends Actor
{
    public static int totalLoss = 0;
    
    public void act() 
    {
        click();
    }       
    
    public void click() {
        if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == StartScreen.class)) {
         Greenfoot.setWorld(new Game());   
        }
        
        else if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == Game.class)) {
         Greenfoot.setWorld(new StartScreen());   
        }
        
        else if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == Instructions.class)) {
         Greenfoot.setWorld(new EndScreen());   
         totalLoss++;
        }
    }
}
