import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A little penguin that wants to get to the other side.
 */
public class Pengu extends Mover
{
    private static final int jumpStrength = 16;
    private int level;
    private int jumped = 0;   // count how often we've jumped
    
    public Pengu()
    {
        level = 1;
    }
    
    public void act() 
    {
        checkKeys();        
        checkFall();
        checkNextLevel();
    }
    
    private void checkKeys()
    {
        // Move Pengu left or right, and display an approriate image
        // Make Pengu jump if he's on the ground
    }    
    
    private void jump()
    {
        // Move vertically up, then fall
    }
    
    private void checkFall()
    {
        // If Pengu is on the ground, keep him there, otherwise fall
    }

    private void checkNextLevel()
    {
        // Check whether we should go to the next level, and if yes, start the next level.
    }


}

    