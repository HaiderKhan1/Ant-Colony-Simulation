
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class AbstAnt here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class AbstAnt extends Actor
{
    enum AntState
    {
       IDLE, HUNT, FEED, ATTACK, DEAD, TRACK, FOLLOW, FORAGE, SFORAGE, RETURN, DEADWFOOD
    }
    
    enum SpiderState 
    {
     IDLE, DEAD, FIGHT   
    }
    
    //Properties : what an ant has
    protected int speed =5;
    protected Colony homeColony;// stores which colony spawned the ant
    protected int size = 20;
    protected int sightRange =150; // how far the ant can see targets
    protected int scent = 150;// how far the ant sees food
    protected double energy = 100;//the amount of energy, if < 0, it starves
    protected double health = 100;//if < 0, it dies
    protected double spiderHealth = 300;// the spiders health
    protected int capacity  = 100;//max an ant can carry
    protected int weight = 20;//what the ant presently weighs
    protected int attack = 5;/// the max dmg the ants can do
    protected int spiderAttack = 25;// the max dmg the spider can do
    protected AntState state = AntState.IDLE;// start the ant with the basic commands
    protected SpiderState spiderState = SpiderState.IDLE;
    AbstAnt target;// will hold which spider/ ant it attacks
    boolean spiderdead = false;
    protected HealthBar hb;
    protected SpiderHealthBar shb;

    public void act()
    {
        turn(Greenfoot.getRandomNumber(60)-30);
        move(Greenfoot.getRandomNumber(8*((5)-2)));
    }

   public void takeDamage(double damage) 
   {
        health-= damage;
        
        //if all the health is gone 
        if (health <= 0) 
        {
            //change it to dead
            state = AntState.DEAD;
        }
    }
    
   public double getDistance(AbstAnt spider) 
   {    // calculates the distance using pythagorean theorum
       return Math.hypot(spider.getX() - getX(), spider.getY() - getY());
   }
    
   public AbstAnt getNearestActor() {// gets nearest actor
   List<AbstAnt> targets = getObjectsInRange(sightRange, AbstAnt.class);//here you can use the radius you want and maybe another class;
   AbstAnt nearestActor = null; // at first it isnull
   AbstAnt spider = nearestActor;// 
   double nearestDistance = 1000;// starts high so it an get lower
   double distance;
   if(targets.size() > 0)
   {
        for (int i = 0; i < targets.size(); i++) 
        {
            distance = getDistance(targets.get(i));// gets their distance
            if (distance < nearestDistance ) 
            {// if it is lower than the current lowest distance
                nearestActor = targets.get(i);// this is the current nearest actor
                nearestDistance = distance;// replace the distance
            }
            else
            {
             super.act();   
            }
        }

   }
    return nearestActor;// returns the nearest actor
}

    //Methods : what the ant does
    protected abstract void eat();
    
    protected abstract Colony getHomeColony();
    
    protected abstract void attack();
    
    protected abstract void track();
    
    protected abstract void collectFood();
    
    protected abstract void leaveTrail();

}
