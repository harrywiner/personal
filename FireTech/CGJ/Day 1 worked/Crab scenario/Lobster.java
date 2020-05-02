import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(atWorldsEdge()) {
            turn(180);
            move(10);
        } else {
            move(4);
            if(Greenfoot.getRandomNumber(100) < 5) {
                turn(Greenfoot.getRandomNumber(360));
            }
        }
        eat();
    }
    
    /**
     * A method to hit detect and remove a Crab object 
     */
    public void eat() {
        Actor crab = getOneObjectAtOffset(0,0,Crab.class);
        if (crab != null) {
            getWorld().removeObject(crab);
        }
    }
    /**
     * A method to detect if the location is near or at the World Edge
     */
    public boolean atWorldsEdge() {
        if (getX() < 5 || getX() >= getWorld().getWidth() - 5) {
            return true;
        } else if (getY() < 5 || getY() >= getWorld().getWidth() - 5) {
            return true;
        } else {
            return false;
        }
    }
}
