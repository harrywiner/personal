import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOne extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public LevelOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public LevelOne(Pengu pengu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(pengu, 0, 0);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Pengu pengu = new Pengu();
        addObject(pengu,142,188);
        pengu.setLocation(103,193);
        Building building = new Building();
        addObject(building,101,357);
    }
}
