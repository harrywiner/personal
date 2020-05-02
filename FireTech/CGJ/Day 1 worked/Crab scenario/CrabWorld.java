import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab();
        addObject(crab,84,445);
        crab.setLocation(53,274);
        Worm worm = new Worm();
        addObject(worm,333,109);
        Worm worm2 = new Worm();
        addObject(worm2,423,413);
        Worm worm3 = new Worm();
        addObject(worm3,273,463);
    }
}
