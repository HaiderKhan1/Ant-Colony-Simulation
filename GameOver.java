import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends AbstEG
{ 
    private GreenfootImage gv1 = new GreenfootImage("gv (1).png");
    private GreenfootImage gv2 = new GreenfootImage("gv (2).png");
    private GreenfootImage gv3 = new GreenfootImage("gv (3).png");
    private GreenfootImage gv4 = new GreenfootImage("gv (4).png");
    private GreenfootImage gv5 = new GreenfootImage("gv (5).png");
    private GreenfootImage gv6 = new GreenfootImage("gv (6).png");
    private GreenfootImage gv7 = new GreenfootImage("gv (7).png");
    private GreenfootImage gv8 = new GreenfootImage("gv (8).png");
    private GreenfootImage gv9 = new GreenfootImage("gv (9).png");
    private GreenfootImage gv10 = new GreenfootImage("gv (10).png");
    private GreenfootImage gv11 = new GreenfootImage("gv (11).png");
    private int frame = 1;
    private int animationCounter = 0;
    
    public void act() 
    {
        animationCounter++;
        animationGV();
        GV();
    }   
    
    public void GV ()
    {
        if(animationCounter % 15 == 0)
        {
            frame++;
            animationCounter = 0;
        }
    } 
    
 public void animationGV() 
    {
        if (frame == 1) 
        {
            setImage(gv1);
        }
        
        else if (frame == 2) 
        {
            setImage(gv2);
        }
        
        else if (frame == 3) 
        {
            setImage(gv3);
        }
        
        else if (frame == 4) 
        {
            setImage(gv4);
        }
        
        else if (frame == 5) 
        {
            setImage(gv5);
        }
        
        else if (frame == 6) 
        {
            setImage(gv6);
        }
        
        else if (frame == 7) 
        {
            setImage(gv7);
        }
        
        else if (frame == 8) 
        {
            setImage(gv8);
        }
        
        else if (frame == 9) 
        {
            setImage(gv9);
        }
        
        else if (frame == 10) 
        {
            setImage(gv10);
        }
        
        else if (frame == 11) 
        {
            setImage(gv11);
        }
        
        if (frame >= 11) 
        {
            frame = 1;
        }    
    }
    
}
