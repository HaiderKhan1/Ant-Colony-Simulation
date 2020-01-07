import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * The program seeks the closet spiders 
 * The program seeks the closet food
 * The Program sawpns a user control ant when the colony has accumalted enough energy 
 * The program launced warrior ants to back up normal ants and brings more damage with it 
 */
public class Game extends World
{

    SimpleTimer fSpawnTimer; // timer variable initilizes time
    SimpleTimer sfSpawnTimer;
    Spider spider; // iniitlizes up the spider class
    Food food; //initilizes the food class
    SuperFood superfood;
    Ant ant; //intilizes the ant class
    StatScreen statScreen;
    Colony colony; // initilizes the colony 
    protected int cSize = 55;
    LadyBug ladybug; //initllizes the lady bug class
    Warrior warrior; //initlizes the warrior class
    UcAnt ucant; //initlizes the user control ant 
    
    Labels numbAnts = new Labels ("Number of Ants: 0");
    Labels numbSpiders = new Labels ("Number of Spiders: 0");
    Labels colonyEnergy = new Labels ("Colony Energy: 0");
    int colonyX = Greenfoot.getRandomNumber(getWidth());
    int colonyY = Greenfoot.getRandomNumber(getHeight());    
    int numLadybugs = 6; //sets spawn amount for lady bugs 
    int numUcants = 1;//sets spawn amount for user control 
    int numWarriors = 4;// sets the spawn amount of the warrior ants 
    int numAnts = 25; //set the spawn of number of ants
    int numSpiders = 4; //sets the spawn of number of spiders
    int numFoods = 8; //set the spawn amount of food 
    int numSuperFood = 1;
    
    
    public GreenfootSound attackMusic = new GreenfootSound("shooter.wav"); //initillizes the shooter (attack) object
    public GreenfootSound bombMusic = new GreenfootSound("Bomb.wav"); //initlizes bomb sound object
    public GreenfootSound biteMusic = new GreenfootSound("bite.wav"); //initlizes the bite music sound object 
    
    //the attackmuic is made into functuon and called once, it will be later called used a memory refrence
    public GreenfootSound attackMusic() 
    {
     attackMusic.play();
     attackMusic.setVolume(10);
     return attackMusic;
    }
    //bomb music funtcion called in once, it will be called in later using a memory refrence 
    public GreenfootSound bombMusic() 
    {
        bombMusic.play();
        bombMusic.setVolume(100);
        return bombMusic;
    }
    //bite sound effect is called and initilized
    public GreenfootSound biteMusic() 
    {
        biteMusic.play();
        biteMusic.setVolume(100);
        return biteMusic;
    }

    public Game()
    {
        // Create a new world with 1000x750 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);

        // Construct the food spawn timer
        fSpawnTimer = new SimpleTimer();
        sfSpawnTimer = new SimpleTimer();
        
        //randomly spawn the colony
        colony = new Colony();
        addObject(colony,colonyX, colonyY);// spawns colony in random location
        colony.getImage().scale((int)cSize,(int)cSize); //sets size for the colony

        for (int i = 0; i < numFoods; i++)
        {
            food = new Food();
            addObject(new Food (50), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        
        for (int i = 0; i < numSuperFood; i++) 
        {
            superfood = new SuperFood();
            addObject (superfood, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getWidth()));
        }
        
        //spawns spiders randomly 
        for (int i = 0; i<numSpiders; i++) 
        {
            spider = new Spider();
            addObject(spider, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
   
        //spawns lady bugs randomly 
        for (int i = 0; i<numLadybugs; i++) 
        {
            ladybug = new LadyBug();
            addObject(ladybug, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }

    }
    
    public void act()
    {
        processKeys();
        spawnFood();
        spawnSuperFood();
        counterUpdate();
        prepare();
    }

    public void prepare() 
    {
        Tracker tracker = new Tracker();
        addObject(tracker, getWidth()/2, getHeight()/2);
        
        addObject(numbAnts, 300, 100);
        addObject(numbSpiders, 1000, 100);
        addObject(colonyEnergy, colonyX+50, colonyY-20);
    }
    
    public void counterUpdate ()
    {
        numbAnts.setText("Number of Ants: "+Tracker.numAnt);
        numbSpiders.setText("Number of Spiders: "+Tracker.numSpider);
        colonyEnergy.setText("Colony Energy: " +Colony.spawnEnergy);
    }
    
    public void processKeys() 
    {
        if (Greenfoot.isKeyDown("tab")) 
        {
            Greenfoot.setWorld(new StatScreen(this));
        }   
    }

    public void spawnFood() 
    {
        if(fSpawnTimer.millisElapsed()> Food.spawnTime)
        {
            // then spawn in another food
            Food temp = new Food();
            //actually adding yhe object to the world
            addObject(temp,Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            fSpawnTimer.mark();
        }   
    }
    
    public void spawnSuperFood()
    {
        if (sfSpawnTimer.millisElapsed() > SuperFood.spawnTime)
        {
            SuperFood temp = new SuperFood();
            addObject (temp, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            sfSpawnTimer.mark();
        }
    }
}   
