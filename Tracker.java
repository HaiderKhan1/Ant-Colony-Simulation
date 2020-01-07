import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Tracker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tracker extends Actor
{
    Ant numAnts;
    CarrierAnt numCAnts;
    Warrior numWAnts;
    Spider numSpiders;
    Food numProspects;
    UcAnt numUcAnts;
    
    private int global = 1000;
    public static int numAnt = 0;
    public static int numCAnt = 0;
    public static int numWAnt = 0;
    public static int numSpider = 0;
    public static int numProspect =0;
    public static int numUcAnt = 0;
    public static int totalAntDeath = 0;
    
    public static int flag = 0;
    public static int flag2 =0;
    public void act() 
    {
        invis();
        statTrak();
        calculator();
        endGame();
        winGame();
    }   
    
    public void invis ()
    {
        getImage().setTransparency(0);
    }
    
    public void statTrak()
    {
        List<Ant> numAnts = getObjectsInRange (global, Ant.class); 
        numAnt = numAnts.size();
        
        List<CarrierAnt> numCAnts = getObjectsInRange (global, CarrierAnt.class);
        numCAnt = numCAnts.size();
 
        List<Warrior> numWAnts = getObjectsInRange (global, Warrior.class);
        numWAnt = numWAnts.size();

        List<UcAnt> numUcAnts = getObjectsInRange (global, UcAnt.class);
        numUcAnt = numUcAnts.size();
        
        List<Spider> numSpiders = getObjectsInRange (global, Spider.class); 
        numSpider = numSpiders.size();

        List<Food> numProspects = getObjectsInRange (global, Food.class); 
        numProspect = numProspects.size();        
    }
    
    public void endGame()
    {
        if ((numUcAnt == 0) && (numWAnt == 0) && (numAnt == 0) && (flag == 0))
        {
            Greenfoot.setWorld(new EndScreen());    
            flag = 1;
        }
    }   
    
    public void calculator()
    {
        totalAntDeath = Ant.antDeath+UcAnt.antDeath+Warrior.antDeath;
    }
    
    public void winGame()
    {
        if ((numSpider == 0) && (flag == 0))
        {
            Greenfoot.setWorld(new WinScreen());    
            flag = 1;
        }        
    }    
}
