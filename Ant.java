
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ant extends AbstAnt
 {
    protected double energyThreshold = 45;
    protected double healthThreshold = 50;
    public boolean claimedFood = false;
    Food prospect;
    SuperFood superProspect; 
    Ant help;
    public static int antDeath = 0;
    int hearRange = 350;// how far away the ants can hear an ant attacking/ being attacked
    int helpState=1;
    
    public Ant( Colony a ) 
    {
        homeColony = a;
    }

    public Ant() 
    {

    }

    public void act()  
    {
        StateShift();
        exhaustion();
        healthBar();
    }

    public void StateShift()
     {
        List<Food> prospects = getObjectsInRange(scent, Food.class); //scent is sight range for food
        if (state == AntState.IDLE) 
        {
            super.act();
            checkHelp();
            if ((energy < energyThreshold) || (health < healthThreshold)) 
            {
                List<SuperFood> superProspects = getObjectsInRange (scent, SuperFood.class);
                
                if (superProspects.size() > 0) 
                {
                    superProspect = superProspects.get(0);
                    state = AntState.SFORAGE;
                }  
            }
          
            List<AbstAnt> targets = getObjectsInRange(sightRange, AbstAnt.class);
            if (targets.size()>0) 
            {//if the list is not empty
                    
                for(int i=0; i< targets.size(); i ++) 
                {
                    target= targets.get(i);
                    if(target.getHomeColony() != this.getHomeColony()) 
                    {
                        target = getNearestActor();
                        state = AntState.ATTACK;
                    }
                    
                    else if(target.getHomeColony() == homeColony)
                    {
                        target = null;
                        super.act();  
                    }
                }
            }
            
            if (targets.size() ==0) 
            {
                prospect = getNearestFood();
                if (prospect == null)
                {
                    return;   
                }
                else if(prospect.getClaim() == false)
                {
                    prospect.setClaim(true);
                    state = AntState.FORAGE;
                }
                else if (prospect.getClaim()== true)
                {
                    getNearestFood();
                    prospect = getNearestFood();
                }
            }
        }

            else if (state == AntState.FORAGE)  
            {
                if (prospect == null)  
                {
                    state = AntState.IDLE;
                    return;
                }
                
                if (prospect.getWorld() == null)  
                {
                    prospect = null;
                    state = AntState.IDLE;
                    return;
                }
                turnTowards(prospect.getX(), prospect.getY());
                move(speed);

            if (intersects(prospect))  
            {
                if (energy <= energyThreshold) 
                {
                    energy+=prospect.getEnergy();
                    health+=5;
                    getWorld().removeObject(prospect);
                    prospect = null;
                    state = AntState.IDLE;
                    return;
                }
            }
            
            else if (energy > energyThreshold) 
            {
                state = AntState.RETURN;
            }
        }
        
        else if (state == AntState.SFORAGE) {
            super.act();
            
            if (superProspect.getWorld() == null)
            {
                superProspect = null;
                state = AntState.IDLE;
                return;
            }
            else if (isTouching(SuperFood.class)) {
             energy+=300;
             health+=500;
             attack+=30;
             sightRange+=300;
             getWorld().removeObject(superProspect);
             superProspect = null;
             state = AntState.IDLE;
             return;
            }

            turnTowards (superProspect.getX(), superProspect.getY());
            move(speed); 
            
        }
        if( state== AntState.RETURN) {
            if(getX() != homeColony.getX()  && getY()!= homeColony.getY()) {
                turnTowards(homeColony.getX(),homeColony.getY()); // turns towards home colony

                move((int)(0.5*(speed)));// slows down the ant
                prospect.setLocation(getX(),getY());// moves the food
                prospect.setDecayRate(0);// prevents food from dissapearing in its hand
            }
            else  if(intersects(homeColony)) {
                // drops food of at colony
                turn(180);
                move((int)(speed));// moves away from the food
                prospect = null;
                state= AntState.IDLE;
            }
        }


        else if (state == AntState.ATTACK) {
                if (target == null) {
                state = AntState.IDLE;
            }
             else if (target.getWorld() == null) {
              target = null;
              state = AntState.IDLE;
            }

            //if touching the target
            else if (intersects(target)) {
                //calculate the damage done in the attack
                helpState = 2;
                double damage = Greenfoot.getRandomNumber(attack);
                //call the target's takeDamage method
                target.takeDamage(damage);
            }
            else {
                //turn toward ant ==> turntowards

                turnTowards(target.getX(), target.getY());
                //move the ant
                move(3*speed);

            }
        }
        else if(state == AntState.DEAD) {
            
            if (prospect != null){
             prospect.setClaim(false);   
            }
            getWorld().removeObject(this);
            antDeath++;
        }

    }

  //gets the nearnest actor funtion
       public AbstAnt getNearestActor() {
        List<AbstAnt> targets = getObjectsInRange(sightRange, AbstAnt.class);//here you can use the radius you want and maybe another class;
        AbstAnt nearestActor = null; //sets current nearest actor to null
        AbstAnt spider = nearestActor; //sets spider to nearnest actr
        double nearestDistance = 1000; // the distance it looks for 
        double distance;
        //uses a forloop for look for all objects in rance and determine the closet one
        if(targets.size() > 0){
            for (int i = 0; i < targets.size(); i++) {
                distance = getDistance(targets.get(i));
                if (distance < nearestDistance && target.getHomeColony() != homeColony) { //if the distance is less then nearnest distance and the target does not belong to the home colony declare it the closest target
                    nearestActor = targets.get(i);
                    nearestDistance = distance;
                }
                else{
                 super.act();   
                }
            }

        }
        return nearestActor;
    }
    
        //gets nearnest food
      public double getFoodDistance(Food prospect) { //does a calcuclutation to get the x and y values and subtract them from the current x and y vals
        return Math.hypot(prospect.getX() - getX(), prospect.getY() - getY());
    }
    
       public Food getNearestFood() 
       {
            List<Food> prospects = getObjectsInRange(scent, Food.class);//here you can use the radius you want and maybe another class;
            Food nearestFood = null; //sets food to null
            Food food = (Food)nearestFood; //delclares the food to the nearned food
            double nearestFoodDistance = 1000; //looks for 1000 sightrange (distance)
            double fooddistance;
            
            if(prospects.size() > 0)
            { //again uses a for loop to generate all possible targets in the sight range and the closet one is then declred the closet obkect 
                for (int i = 0; i < prospects.size(); i++) 
                {
                    fooddistance = getFoodDistance(prospects.get(i));
                    prospect= prospects.get(i);
                    if ((fooddistance < nearestFoodDistance)&& prospect.getClaim() == false) 
                    {
                        nearestFood = prospects.get(i);
                        nearestFoodDistance = fooddistance;
                    }
                }
            }
            return nearestFood;
       }
    
    //the move funtion removes enegergy the move the object moves
    public void move (int distance) 
    {
        energy -=(distance*0.05);
        super.move(distance);
    }

    public int getHelpState() 
    {
        return helpState;
    }
    
    protected Colony getHomeColony()
    {
        return homeColony;
    }

    
    public void setClaimed(boolean a) 
    {
        claimedFood = a; 
    }


    protected void checkHelp() 
    {
        List<Ant> helpNeeded = getObjectsInRange(hearRange, Ant.class);

        if(helpNeeded.size()>0) 
        {
            for(int i =0; i< helpNeeded.size();i++) 
            {
                help = helpNeeded.get(i);
                if (help.getHelpState() == 2) 
                {
                    int helpsX = help.getX();
                    int helpsY= help.getY(); 
                    turnTowards(helpsX,helpsY);
                    move(6*speed);// runs towards the action
                    // tester++;
                    if (getX()>= helpsX) 
                    {
                        super.act();

                    }
                }
            }
        }
    }

    public void exhaustion ()  
    {
        if (energy < 00)  
        {// removes the ant if it runs out of energy
            state= AntState.DEAD;
        }
    }

    public void limits ()  
    {// 
        if (energy > 100)  
        {
            energy = 100;
        }

        if (health > 100)  
        {
            health = 100;
        }
    }
    
    //projecrs the health bar above the objects 
    public void healthBar ()  
    {
        if (hb == null)  
        {
            hb = new HealthBar (this, (int)health);
            getWorld().addObject(hb, getX(), getY() - getImage().getHeight()/2);
        }
        else  
        {
            hb.update();
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

    public void takeDamage(double damage) 
    { //take damage funtion
        //remove the damage from the health
        health-= damage;
        //if all the health is gone 
        if (health <= 0) {
            //change it to dead
            state = AntState.DEAD;
        }
    }
}
