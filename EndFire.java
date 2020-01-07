import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndFire extends AbstEG
{
    
    private GreenfootImage flame1 = new GreenfootImage("flame (1).png");
    private GreenfootImage flame2 = new GreenfootImage("flame (2).png");
    private GreenfootImage flame3 = new GreenfootImage("flame (3).png");
    private GreenfootImage flame4 = new GreenfootImage("flame (4).png");
    private GreenfootImage flame5 = new GreenfootImage("flame (5).png");
    private GreenfootImage flame6 = new GreenfootImage("flame (6).png");
    private GreenfootImage flame7 = new GreenfootImage("flame (7).png");
    private GreenfootImage flame8 = new GreenfootImage("flame (8).png");
    private GreenfootImage flame9 = new GreenfootImage("flame (9).png");
    private GreenfootImage flame10 = new GreenfootImage("flame (10).png");
    private GreenfootImage flame11 = new GreenfootImage("flame (11).png");
    private GreenfootImage flame12 = new GreenfootImage("flame (12).png");
    private GreenfootImage flame13 = new GreenfootImage("flame (13).png");
    private GreenfootImage flame14 = new GreenfootImage("flame (14).png");
    private int frame = 1;
    private int animationCounter = 0; 
    
    public void act() 
    {
        animationCounter++;
        animationFire();
        moFire();
    }   
    
    public void moFire ()
    {
        if(animationCounter % 15 == 0)
        {
            frame++;
            animationCounter = 0;
        }
    }    
    
    public void animationFire() 
    {
        if (frame == 1) 
        {
            setImage(flame1);
        }
        
        else if (frame == 2) 
        {
            setImage(flame2);
        }
        
        else if (frame == 3) 
        {
            setImage(flame3);
        }
        
        else if (frame == 4) 
        {
            setImage(flame4);
        }
        
        else if (frame == 5) 
        {
            setImage(flame5);
        }
        
        else if (frame == 6) 
        {
            setImage(flame6);
        }
        
        else if (frame == 7) 
        {
            setImage(flame7);
        }
        
        else if (frame == 8) 
        {
            setImage(flame8);
        }
        
        else if (frame == 9) 
        {
            setImage(flame9);
        }
        
        else if (frame == 10) 
        {
            setImage(flame10);
        }
        
        else if (frame == 11) 
        {
            setImage(flame11);
        }
        
        else if (frame == 12) 
        {
            setImage(flame12);
        }
        
        else if (frame == 13) 
        {
            setImage(flame13);
        }
        
        else if (frame == 14) 
        {
            setImage(flame14);
        }       
        
        //frame++;
        
        if (frame >= 14) 
        {
            frame = 1;
        }
    }
}
