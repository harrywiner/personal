import greenfoot.*;
//import java.awt.Color;

public class Frog extends Mover
{
    public void act() 
    {
        boolean moved = false;
        
        if (Greenfoot.isKeyDown("left"))
        {
            moveLeft();
            moved = true;
        }
        if (Greenfoot.isKeyDown("right"))
        {
            moveRight();
            moved = true;
        }
        if (Greenfoot.isKeyDown("up"))
        {
            moveUp();
            moved = true;
        }
        if (Greenfoot.isKeyDown("down"))
        {
            moveDown();
            moved = true;
        }
        
        Actor obstacle = getOneIntersectingObject(Obstacle.class);
        if (obstacle != null)
        { /* We have hit something */
            killFrog();
        }
        
        Actor target = getOneIntersectingObject(Target.class);
        if (target != null)
        { /* We have got to a home */
            frogHome();
        }
        
        if ( ! moved)
        {
            Actor grass = getOneIntersectingObject(Grass.class);
            if (grass != null)
            {
                setLocation(grass.getX(), grass.getY());
            }
        }
    }

    public void killFrog()
    {
        GreenfootImage img = getImage();
        img.setColor(Color.RED);
        img.drawLine(0, 0, img.getWidth(), img.getHeight());
        img.drawLine(0, img.getHeight(), img.getWidth(), 0);
        
        ((FroggerWorld)getWorld()).gameOver();
    }
    
    public void frogHome()
    {
        GreenfootImage img = getImage();
        img.setColor(Color.GREEN);
        img.drawLine(0, img.getHeight(), img.getWidth(), 0);
        ((FroggerWorld)getWorld()).gameOver();
    }
    
    public void moveLeft()
    {
        setFacingDirection(Mover.LEFT);
        setMovingDirection(Mover.LEFT);
        move();        
    }
    
    public void moveRight()
    {
        setFacingDirection(Mover.RIGHT);
        setMovingDirection(Mover.RIGHT);
        move();     
    }
    
    public void moveUp()
    {
        setMovingDirection(Mover.UP);
        move();
    }
    
    public void moveDown()
    {
        setMovingDirection(Mover.DOWN);
        move();      
    }
    
}
