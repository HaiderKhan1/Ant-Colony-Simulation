import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperFood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperFood extends AbstFood
{
    /**
     * Act - do whatever the SuperFood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static long spawnTime = 10000;
    private static double decayRate   = 0.1;
    public double energy = 100;
    private double size = 30;
    private double weight = 10;

    public SuperFood(){
        setEnergy();
    }

    public SuperFood(double energy){

     setEnergy(energy);
    }

    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (energy>0){
            removeEnergy(decayRate);

        }
        else {
         getWorld().removeObject(this);

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

}
