import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The class Mover provides some basic movement methods. Use this as a superclass
 * for other actors that should be able to move left and right, jump up and fall 
 * down.
 */
public class Mover extends Actor
{
    private static final int ACCELERATION = 1;      // down (gravity)
    private static final int RUNNING_SPEED = 7;             // running speed (sideways)
    
    private int vSpeed = 0;                         // current vertical speed
    
    /**
     * Move a bit to the right.
     */
    public void moveRight()
    {
        setLocation ( getX() + RUNNING_SPEED, getY() );
    }
    
    /**
     * Move a bit to the left.
     */
    public void moveLeft()
    {
        setLocation ( getX() - RUNNING_SPEED, getY() );
    }
    
    /** 
     * Use the vSpeed by adding to the vertical location 
     * Then subtract the acceleration every time called
     * Ideally put in act()
     */
    public void verticalMove() 
    {
        setLocation(getX(), getY() - vSpeed);
        vSpeed -= ACCELERATION;
    }
    
    /**
     * Return true if we're on firm ground that we can stand on.
     */
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2-8, null);
        return under != null;
    }

    /**
     * Set a speed for a vertical movement. Positive values go down, negative values
     * go up.
     */
    public void setVSpeed(int speed)
    {
        vSpeed = speed;
    }
    
    /**
     * Apply gravity and fall downwards until we hit ground or the bottom of the screen.
     * 
     * DEPRICATED use verticalMove
     */
    public void fall()
    {
        setLocation ( getX(), getY() + vSpeed);
        vSpeed = vSpeed + ACCELERATION;
    }
    
    /**
     * Return true if we're at the bottom of the screen.
     * 
     * I edited this and cba to revert it sorry
     */
    public boolean atBottom()
    {
        return getY() >= getWorld().getHeight() - getImage().getHeight()/2-8;
    }
    
    /**
     * End this game (that is: stop the simuation).
     */
    private void gameEnd()
    {
        Greenfoot.stop();
    }


}