import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplatWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SplatWorld extends World
{

    /**
     * Constructor for objects of class SplatWorld.
     * 
     */
    public SplatWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act()
    {
        if (Greenfoot.getRandomNumber(100) < 3) {
            int x = Greenfoot.getRandomNumber(600);
            int y = Greenfoot.getRandomNumber(400);
            addObject(new Rat(), x, y);
        }
    }

}
