import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pengu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pengu extends Mover
{
    private final int JUMP_STRENGTH = 20;
    private int level;
    
    public Pengu(int level) {
        this.level = level;
    }
    
    /**
     * Act - do whatever the Pengu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!onGround() && !atBottom())
            verticalMove();
        else 
            setVSpeed(0);
        checkKey();
        if(atEdge()) 
        {
            if(level == 1)
            {
                level = 2;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new Level2(this));
            } else if (level == 2) {
                level = 1;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new MyWorld(this));
            }
        }
        
        
    }    
    
    private void checkKey() 
    {
        if(Greenfoot.isKeyDown("space"))
            jump();
        if (Greenfoot.isKeyDown("left"))
            moveLeft();
        else if (Greenfoot.isKeyDown("right"))
            moveRight();
    }
    
    private boolean atEdge() {
        if(getX() >= getWorld().getWidth() - 5) 
        {
            return true;
        } else {
            return false;
        }
    }
    
    
    
    /**
     * Check if pengu is on the ground then execute a jump accordingly
     */
    public void jump() {
        if(onGround() || atBottom()) {
            setVSpeed(JUMP_STRENGTH);
            verticalMove();
        }
        
    }
}
