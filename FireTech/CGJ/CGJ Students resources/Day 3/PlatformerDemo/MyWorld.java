import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
    }
    
    public MyWorld(Pengu pengu) 
    {
        super(600,400,1);
        addObject(pengu, 0, 0);
        pengu.setLocation(100,100);
    }
}
