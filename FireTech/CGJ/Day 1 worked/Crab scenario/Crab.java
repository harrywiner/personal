import greenfoot.*;  
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveAndTurn();
        eat();
    }
    
    /**
     * Moves the crab forward then, based on input, turns it
     */
    public void moveAndTurn() {
        move(4);
        if(Greenfoot.isKeyDown("left")) {
            turn(-3);
        } else if (Greenfoot.isKeyDown("right")) {
            turn(3);
        }
    }
    
    /**
     * Hit detection for worms and crabs
     * If a worm is touching the crab, then the crab eats the worm
     */
    public void eat() {
        Actor worm = getOneObjectAtOffset(0,0,Worm.class);
        
        if (worm != null) {
            World world = getWorld();
            world.removeObject(worm);
            
            Greenfoot.playSound("sounds/eating.wav");
        }
    }
}
