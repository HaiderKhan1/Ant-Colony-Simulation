import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class UcAnt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class UcAnt extends AbstAnt
{
    /**
     * Act - do whatever the UcAnt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     enum UcState {
     UCIDLE, UCDEAD, UCATTACK 
    }
  //all varaibles for the UC ant
  boolean usercontrol = true; //booleant if its alive
  protected int ucattack = 500; //sets enough attack power to obliderte the spider in one hit 
  protected UcState uCState = UcState.UCIDLE; //sets initial state to idle 
  public GreenfootSound bombMusic = new GreenfootSound("Bomb.wav"); //calls the bomb sound
  protected UcAnt uctarget;  
  public static int antDeath = 0;
  
    public UcAnt( Colony a ) 
    {
        homeColony = a;
    }

    public UcAnt() 
    {

    }
  
  
    public void act() 
    {
        //makes the meomory refrence for the bomb music 
         if(bombMusic == null) 
         {
             bombMusic = ((Game)getWorld()).bombMusic();
         }
        
        //if the state is set to dead then remove the object and the boolen to false
         if(uCState == UcState.UCDEAD)
         {
             getWorld().removeObject(this);
             antDeath++;
             boolean usercontrol = false; 
         }
         
        //look for souders in range, if the spider is in range then attack it
         if(uCState == UcState.UCIDLE)
         {
             List<Spider> targets = getIntersectingObjects(Spider.class);
             
             if (targets.size()>0)
             {//if the list is not empty
                 target = targets.get(0);
                 uCState = UcState.UCATTACK;
             }
         }
         
            //if the UCant is touching the spider class then play the bomb music 
         if(uCState == UcState. UCATTACK)
         {
             if(isTouching(Spider.class))
             {
                 double damage = Greenfoot.getRandomNumber(ucattack);
                 target.takeDamage(damage); //call the objects take damage funtion
                 bombMusic.play();
                 uCState = UcState.UCDEAD; //set the state to dead 
             }
         }
        
        //if the user control is trrue then allow the user controls 
        if(usercontrol == true)
        {
        // Add your action code here.
        if (Greenfoot.isKeyDown("up"))
        {
            move(20);  
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            move(-20);  
        }
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-10);  
        }
        if (Greenfoot.isKeyDown("right"))
        {
            turn(10);  
        }
    }
  }
  //take damage from moving funtion
    public void move (int distance)
    {
        energy -=(distance*0.15);
        super.move(distance);
        
        if(energy < 0)
        {
            uCState = UcState.UCDEAD;
        }
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
    public void takeDamage(double damage)
    {

    }
    
    protected Colony getHomeColony()
    {
    return homeColony;
    }
}



