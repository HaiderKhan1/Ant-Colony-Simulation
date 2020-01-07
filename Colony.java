    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.*;
    /**
     * Write a description of class Colony here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Colony extends Actor
    {
        int tester=1;
        protected int energyNeeded= 15;
        public static int spawnEnergy=350;
        protected int warriorSpawnEnergy=151;
        protected int warriorSpawnEnergyNeeded=150;
        protected int UserSpawnEnergy=350;
        protected int UserSpawnEnergyNeeded=350;
        protected int antSpawnTime= 5000;
        protected int beginWorldTime = 5000;
        Game myWorld;
        SimpleTimer antSpawnTimer;
        SimpleTimer beginWorldSpawnTimer;    
        Food colonyFood;
        
        public Colony()
        {          
            antSpawnTimer= new SimpleTimer();
            beginWorldSpawnTimer= new SimpleTimer();
        }
        
        public void act() 
        {
            List<Food> prospects = getIntersectingObjects( Food.class);
            if( prospects.size()>0)
            {
                colonyFood= prospects.get(0);
            }
        
            if (isTouching(Food.class))
            {
                spawnEnergy+=0.6*(colonyFood.getEnergy());
                warriorSpawnEnergy+= 0.3*(colonyFood.getEnergy());
                UserSpawnEnergy+= 0.1*(colonyFood.getEnergy());
                getWorld().removeObject(colonyFood);
                colonyFood= null;
            }
            
            if(tester==1)
            {
                 CarrierAnt testCarrier= new CarrierAnt(this);
                 getWorld().addObject(testCarrier, getX(),getY());
                 tester++;
            }
            
            if(beginWorldSpawnTimer.millisElapsed()< beginWorldTime)
            {// allows for an initial burst of ants
                if(spawnEnergy > energyNeeded)
                {
                    Ant cAnt= new Ant(this);
                    getWorld().addObject(cAnt, getX(),getY());
                    spawnEnergy -= 10; 
                }
            }
            
            else  if (beginWorldSpawnTimer.millisElapsed()> beginWorldTime)
            {// after the initial burst
                if(spawnEnergy > energyNeeded)
                {// when the colony has enough energy
        
                    if (antSpawnTimer.millisElapsed()> antSpawnTime)
                    {// spawn ants every few seconds
                        Ant cAnt= new Ant(this);// make ant and put in the colony reference
                        getWorld().addObject(cAnt, getX(),getY());
                        spawnEnergy -= energyNeeded;// reduce the energy from the colony
                        antSpawnTimer.mark();// resets the few second timer
                    }
                }   
            }
            
            if(warriorSpawnEnergy > warriorSpawnEnergyNeeded )
            {
                Warrior wAnt= new Warrior(this);// make ant and put in the colony reference
                getWorld().addObject(wAnt, getX(),getY());
                warriorSpawnEnergy -=warriorSpawnEnergyNeeded;
            }
        
            if(UserSpawnEnergy > UserSpawnEnergyNeeded )
            {
                UcAnt uAnt= new UcAnt(this);// make ant and put in the colony reference
                getWorld().addObject(uAnt, getX(),getY());
                UserSpawnEnergy -= UserSpawnEnergyNeeded;
            }
        }
}

