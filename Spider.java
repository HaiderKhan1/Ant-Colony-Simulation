
        import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        import java.util.*;
        /**
         * Write a description of class Spider here.
         * 
         * @author (your name) 
         * @version (a version number or a date)
         */
        public class Spider extends AbstAnt
        {
            public GreenfootSound attackMusic = new GreenfootSound("shooter.wav");//makes a meoery refrence to the attack music 
            AbstAnt targetAnt; //sets all abst ants as target
            public static int spiderDeath = 0;

            public void act() 
            {
                
                healthBar();
               
                if(attackMusic == null) 
                { //makes the refrence to the attack music 
                    attackMusic = ((Game)getWorld()).attackMusic();
                }
                
                //if the spider state is dead, then remove the object 
                if(spiderState == SpiderState.DEAD)
                {
                    getWorld().removeObject(this);
                    spiderDeath++;
                }
                
                //if in idle state, walk around randomly
               if(spiderState==SpiderState.IDLE)
               {
                   move(8*speed);
                   turn(Greenfoot.getRandomNumber(60)-30);
                
             //if touching ant class the set state to fight
                   if(isTouching(Ant.class))
                   {// only fights back, and does not hunt
                        spiderState= SpiderState.FIGHT;
                         List<AbstAnt> targetAnts = getIntersectingObjects(AbstAnt.class);
                        
                        if(targetAnts.size()>0)
                        {
                            targetAnt = targetAnts.get(0);
                        }
                   }
               }
            
            //when the state is set to fith, then see if the target is null else sttack it anf class it's take damage funtion 
               if(spiderState== SpiderState.FIGHT)
               {
                   if (targetAnt.getWorld() == null)
                   {
                       targetAnt = null;
                       spiderState = SpiderState.IDLE;
                   }
                   else
                   {
                    double damage = Greenfoot.getRandomNumber(10+spiderAttack);
                    targetAnt.takeDamage(damage);
                   }
               }    
            }    
        
        
    public void move (int distance)
    {

    }
    
    protected Colony getHomeColony()
    {// returns the origin of this spider
        return homeColony;
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
    //sets the health bar for the spider 
    public void healthBar () 
    {
        if (shb == null) 
        {
            shb = new SpiderHealthBar (this, (int)spiderHealth);
            getWorld().addObject(shb, getX(), getY() - getImage().getHeight()/2);
        }
        else 
        {
            shb.update();
        }       
    }
    
    //take damage funtion of the spider
    public void takeDamage(double damage){
        spiderHealth-= damage;
        attackMusic.play();
        //remove damage dealt from health 
        
        if (spiderHealth < 0) {
            spiderState = SpiderState.DEAD;
            //if health is less than 0, then send spider to dead 
        }
    }
}

