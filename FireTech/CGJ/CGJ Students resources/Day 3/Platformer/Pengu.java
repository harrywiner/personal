import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pengu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pengu extends Mover
{
    private int level = 1;
    /**
     * Act - do whatever the Pengu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(atBottom() || onGround())
        {
            setVSpeed(0);
        } else {
            verticalMove();
        }
        
        if(Greenfoot.isKeyDown("space")) 
        {
            jump();
        }
        
        if(Greenfoot.isKeyDown("left")) {
            moveLeft();
        } else if (Greenfoot.isKeyDown("right")) {
            moveRight();
        }
        if(isAtRightEdge()) 
        {
            if(level == 1)
            {
                level = 2;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new LevelTwo(this));
            } else if (level == 2) {
                level = 1;
                getWorld().removeObject(this);
                Greenfoot.setWorld(new LevelOne(this));
            }
        }
    }   
    
    public void jump()
    {
        if (atBottom() || onGround()) 
        {
           setVSpeed(20);
           verticalMove();
        }
        
    }
    
    private boolean isAtRightEdge() {
        if(getX() >= getWorld().getWidth() - 5) 
        {
            return true;
        } else {
            return false;
        }
    }
}
