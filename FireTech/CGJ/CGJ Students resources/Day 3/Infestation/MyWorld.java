import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    private Counter myCounter;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        myCounter = new Counter();
        addObject(myCounter, 50, 350);
    }
    
    public void act() 
    {
        if (Greenfoot.getRandomNumber(100) < 3) 
        {
            makeAnt();
        }
    }
    
    public void addToCounter(int add) 
    {
        myCounter.add(add);
    }
    
    /**
     * Make an ant at a random location
     */
    public void makeAnt() {
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400);
        Ant ant = new Ant();
        addObject(new Ant(), x, y);
    }
}

