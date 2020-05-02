import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    
    public Level2()
    {
        super(600,400,1);
    }
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(Pengu pengu)
    {    
        super(600, 400, 1); 
        addObject(pengu, 0, 0);
    }
}
