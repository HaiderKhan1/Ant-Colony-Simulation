import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundmusic.wav");
    public GreenfootSound deadspiderMusic = new GreenfootSound("deadspiders.wav"); 
    CarrierAnt ant;
    
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1); 
        backgroundMusic.playLoop();
        backgroundMusic.setVolume(5);
          ant = new CarrierAnt();
            addObject(ant, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Clickeroo clickeroo = new Clickeroo();
        //addObject(clickeroo,302,195);
        
        StartButton start = new StartButton();
        addObject(start, getWidth()/2, 500);
        
        InstructionButton instruction = new InstructionButton();
        addObject (instruction, getWidth()/2, 650);
        
        Title title = new Title();
        addObject (title, getWidth()/2, 200);
    }
}
