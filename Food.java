
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends AbstFood
{
    public static long spawnTime = 1000;
    public double decayRate   = 0.1;
    public double energy = 100;
    private double size = 30;
    private double weight = 10;
    public boolean isClaimed = false;
    public AbstAnt claimer;

    public Food(){
        setEnergy();
    }

    public Food(double energy){

     setEnergy(energy);
    }

    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       // if (claimer ==null){
         //   this.setClaim(false);
        //}
        if(claimer == null){
            setClaim(false);
        }
        if (energy>0){
        
            removeEnergy(decayRate);

        }
        else {
        // getWorld().removeObject(this);

        }
      
        //check the energy decay
        //change size and weight
        //
    }
    public void removeEnergy(double amount){
        energy -= amount;
        size = 10+ energy*0.2;
        weight =  5 + energy*1;
        setEnergy();
    }

    public void setEnergy(){
     getImage().scale((int)size,(int)size);
        size = 10+ energy*0.2;
        weight =  5 + energy*1;
    }

    public void setEnergy(double energy){
        this.energy = energy;
        setEnergy();
    }
public double getEnergy(){
   return energy; 
}
    public boolean stillAvailable(){
        return getWorld() != null;
    }
public boolean getClaim(){// allows ants to check whether or not the food is claimed
    return isClaimed;
}
public void setClaim(boolean a,AbstAnt ant){// allows the ant to  claim the target
    isClaimed= a;
     claimer= ant;
}
public void setClaim(boolean a){// allows the ant to  claim the target
    isClaimed= a;
  
}
public void setDecayRate(double newDecayRate ){// used for the food not to decay in the ants hand

    decayRate= newDecayRate;
}
}
