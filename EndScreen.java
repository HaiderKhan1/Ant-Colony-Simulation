import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        prepare();
    }
    
    private void prepare() 
    {
        //Object Spawners
        EndFire endfire = new EndFire();
        addObject (endfire, 100, getHeight()/2); 
        
        EndFire endFire2 = new EndFire();
        addObject(endFire2,900, getHeight()/2);
        
        GameOver gameover = new GameOver();
        addObject (gameover, getWidth()/2, getHeight()/2);
        
        StartButton startbutton = new StartButton();
        addObject (startbutton, getWidth()/2+10, 600);
    }
}
