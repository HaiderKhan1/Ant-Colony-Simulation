import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CarrierAnt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarrierAnt extends AbstAnt
{
    protected int scent = 375;// increased scent to help locate food
    public boolean claimedFood = false;// for testing purposes
    Colony homeColony;    
    Food prospect;
    
    public CarrierAnt( Colony colony )
    {// allows the ant to store where it came from
        homeColony = colony;// stores the origin colony
    }

    public CarrierAnt()
    {

    }

    public void act()
    { 
        List<Food> prospects = getObjectsInRange(scent, Food.class);// gets all the food within its scent
        if (state!= AntState.IDLE)
        {// allows the ant to return to idle WHENEVER it loses the food
            if (prospect.getWorld() == null) 
            {
                prospect = null;
                state = AntState.IDLE;
                return;
            }
        }
        if (state==AntState.IDLE)
        {
            super.act();

            if(prospects.size() > 0)
            {// if there is food in range
                for(int i=0; i< prospects.size(); i ++)
                {// ant goes through list 

                    prospect= prospects.get(i);// goes through the list
                    if(prospect.getClaim() == false)
                    {// finds an unclaimed food
                        prospect.setClaim(true);
                        state= AntState.FORAGE;// goes to forage state
                    }
                    else if( prospect.getClaim()== false)
                    {
                        prospect = null;
                    }
                }
            }
        }
        /* if( state== AntState.TRACK){

        for(int i=0; i< prospects.size(); i ++){// ant goes through list 

        prospect= prospects.get(i);
        if(prospect.getClaim() == false){// finds an unclaimed food
        state= AntState.FORAGE;// goes to forage state
        }
        }

        } **/
        if ( state== AntState.FORAGE)
        {
            if (prospect.getWorld() == null) 
            {
                prospect = null;
                state = AntState.IDLE;
                return;
            }
            prospect.setClaim(true, this);// claims food, which stops other ants from going for itt
            turnTowards(prospect.getX(), prospect.getY()); // moves towards food
            move(speed);// at a set speed
            if (isTouching(Food.class)) 
            {// when ant touches the food
                state= AntState.RETURN;// goes to return state
            }
        }
        
        if( state== AntState.RETURN)
        {
            if(getX() != homeColony.getX()  && getY()!= homeColony.getY())
            {
                turnTowards(homeColony.getX(),homeColony.getY()); // turns towards home colony

                move((int)(0.5*(speed)));// slows down the ant
                prospect.setLocation(getX(),getY());// moves the food
                prospect.setDecayRate(0);// prevents food from dissapearing in its hand
            }
            else  if(getX() == homeColony.getX()  && getY()== homeColony.getY())
            {
                // drops food of at colony
                turn(180);
                move((int)(speed));// moves away from the food
                prospect = null;
                state= AntState.IDLE;
            }
        }
    }    

    public void setClaimed(boolean a)
    {// for testing purposes
        claimedFood = a; 
    }

    protected Colony getHomeColony()
    {
        return homeColony;
    }

    protected  void eat()
    {
    }

    protected  void attack()
    {
    }

    protected  void track()
    {
    }

    protected  void collectFood()
    {
    }

    protected  void leaveTrail()
    {
    }
}
