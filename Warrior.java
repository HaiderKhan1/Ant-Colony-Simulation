import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Warrior here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Warrior extends AbstAnt
{
     enum WarriorState {
     WIDLE, WATTACK, WDEAD
    }
    
    protected Warrior warrior;
    WarriorState  warriorstate = WarriorState.WIDLE; //sets initial warrior state to udek 
    protected double warriorhealth = 100; //warrior health range
    protected int warriorattack = 10;//warrior attack range
    protected int sightRange = 250;// larger sight range to hunt spiders
    public static int antDeath = 0;

    public Warrior( Colony a ) 
    {
        homeColony = a;
    }

    public Warrior() {

    }
    
    
    public void act() 
    {
        exhaustion();
        //looks for spiders in range 
        List<Spider> targets = getObjectsInRange(sightRange, Spider.class);
        if (warriorstate == WarriorState.WIDLE)
        {
          //if spider is found then sets state to attack 
            super.act();
            if (targets.size()>0)
            {//if the list is not empty
               target= targets.get(0);
               warriorstate = WarriorState.WATTACK;
            }
          
            
        }
        //if the state in wttack call the attack funtuon and the damage funtuon for the spider
            else if (warriorstate == WarriorState.WATTACK)
            {
            if (target.getWorld() == null)
            {
               target = null;
               warriorstate = WarriorState.WIDLE;
            }
            //if touching the target
            else if (isTouching(Spider.class))
            {
                //calculate the damage done in the attack
                double damage = Greenfoot.getRandomNumber(warriorattack);
                //call the target's takeDamage method
                target.takeDamage(damage);
            }
            else
            {
                //turn toward ant ==> turntowards
                //move towards the spider
                    turnTowards(target.getX(), target.getY());
                    //move the ant
                    move(3*speed);

            }
        }
        //if warrior stte is dead then remove this object
        else if(warriorstate == WarriorState.WDEAD)
        {
            getWorld().removeObject(this);
            antDeath++;
        }
    }    
        //move leads to removing the energy which will lead to death
    public void exhaustion ()  
    {
        if (energy < 100)  
        {
            warriorstate= WarriorState.WDEAD;
        }
    }
    
    protected void eat()
    {

    }

    protected void attack()
    {
    }

    protected void track()
    {

    }

    protected void collectFood()
    {

    }

    protected void leaveTrail()
    {

    }
    
    public void move (int distance)
    {
        energy -=(distance*0.0000000000000001);
        super.move(distance);
    }
    
    public void warriortakeDamage(double damage)
    {
        //remove the damage from the health
        warriorhealth-= damage;
        //if all the health is gone 
        if (warriorhealth <= 0)
        {
            //change it to dead
            warriorstate = WarriorState.WDEAD;
        }
    }
    
    protected Colony getHomeColony()
    {
        return homeColony;
    }
    
}



