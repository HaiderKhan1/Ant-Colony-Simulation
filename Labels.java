import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Labels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Labels extends Actor
{
    
    public Labels(String text)
    {
        // Set Color/Size
        GreenfootImage img = new GreenfootImage(text.length()*20, 30);
        img.setColor(Color.RED);
        img.drawString(text, 2, 20);
        setImage(img);
    }
    
    public void setText(String text) 
    {
        // Set Image
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text, 2, 20);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
