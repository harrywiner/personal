import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ant extends Actor
{
    /**
     * If the mouse clicks the ant remove the ant from the world
     */
    public void act() 
    {
        
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this)) {
            world.removeObject(this);
            world.addToCounter(1);
        }
    }    
}
