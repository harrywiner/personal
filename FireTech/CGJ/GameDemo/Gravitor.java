




import greenfoot.*;
/**
 * 
 * Write a description of class Gravitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Gravitor extends Actor 
{
    // instance variables - replace the example below with your own
    
    int gravity;
    int yVelocity;
    int xVelocity;
    /**
     * Constructor for objects of class Gravitor
     */
    public Gravitor(int gravity)
    {
        this.gravity = gravity;
        yVelocity = 0;
        xVelocity = 5;
    }
    
    public Gravitor() 
    {
        this.gravity = 0;
     }

    /**
     * An implementation of the act method in Actor
     * Should be called as super then executed after
     */
    public void act() {
        this.setLocation(getX() + xVelocity, getY() - yVelocity);
        System.out.println(xVelocity + ", " + yVelocity);
        if(getY() >= getWorld().getHeight() - 1)
        {
            yVelocity = 0;
        } else {
            yVelocity -= gravity;
        }
        
    }
    
    /**
     * If the Gravitor is on the ground then add an amount to the 
     * vertical velocity
     * TODO: make it amount jumped using an equation
     */
    public void jump(int dy) 
    {
        if(getY() == getWorld().getWidth())
            yVelocity += dy;
        //this.setLocation(getX(), getY() - 6);
    }
    
}
