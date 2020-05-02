import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rat extends Actor
{
    /**
     * Act - do whatever the Rat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        
        if (Greenfoot.mouseClicked(this)) {
            
            getWorld().removeObject(this);
        }

    }    
}
