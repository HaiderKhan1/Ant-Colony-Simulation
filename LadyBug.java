import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LadyBug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LadyBug extends AbstAnt
{
    //ladstate declares all actions of the ladybug
     enum LadyState 
     {
     IDLE, DEAD 
     }

     protected double ladybugHealth = 50; //sets health of the lady bug
     LadyState ladystate = LadyState.IDLE; //sets the lady bug state to idle 

    public void act() 
    {
        //the lady bug jsut moves around 
        super.act();
        turn(Greenfoot.getRandomNumber(60)-30);
        move(Greenfoot.getRandomNumber(5)-2); 
        //if the state is dead, remove the object 
        if(ladystate == LadyState.DEAD)
        {
           getWorld().removeObject(this);
                
        }  
    }
    
    public void move (int distance)
    {

    }

    public void exhaustion () 
    {

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
    
    public void healthBar () 
    {

        
    }
    //take damage funtion of LB
    public void takeDamage(double damage)
    {
        ladybugHealth-= damage;
        //take LB health and subtract damage
        
        //if the health is less than zero set state to dead
        if (ladybugHealth < 0) {
            ladystate = LadyState.DEAD;
        }
    }
    //a funtiion that must belong all subclasses of the abstant
       protected Colony getHomeColony()
       {
        return homeColony;
    }

}




