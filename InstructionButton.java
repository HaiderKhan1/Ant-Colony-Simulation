import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instruction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionButton extends Actor
{
    /**
     * Act - do whatever the Instruction wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    }    
    
    public void click() {
        if ((Greenfoot.mouseClicked(this)) && (this.getWorld().getClass() == StartScreen.class)) {
         Greenfoot.setWorld(new Instructions());   
        }   
    }
}
