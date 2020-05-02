import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A rocket that can be controlled by the arrowkeys: up, left, right.
 * The gun is fired by hitting the 'space' key. 'z' releases a proton wave.
 * 
 * @author Poul Henriksen
 * @author Michael Kolling
 * 
 * @version 1.0
 */
public class Rocket extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    private static final int protonReloadTime = 500; // the minimum delay between firing proton waves

    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    private int protonReloadDelayCount;  // How long ago we fired the proton wave the last time.
    
    private GreenfootImage rocket = new GreenfootImage("rocket.png");    
    private GreenfootImage rocketWithThrust = new GreenfootImage("rocketWithThrust.png");

    /**
     * Initilise this rocket.
     */
    public Rocket()
    {
        reloadDelayCount = 5;
        protonReloadDelayCount = 500;
        Vector drift = new Vector(0,0.3);
        addForce(drift);
    }

    /**
     * Do what a rocket's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        protonReloadDelayCount++;
        move();
        checkCollision();
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation( getRotation() - 5 );
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setRotation( getRotation() + 5 );
        }
        
        ignite(Greenfoot.isKeyDown("up"));
        
        if (Greenfoot.isKeyDown("z"))
        {
            startProtonWave();
        }
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
            Bullet bullet = new Bullet (getMovement().copy(), getRotation());
            getWorld().addObject (bullet, getX(), getY());
            bullet.move ();
            reloadDelayCount = 0;
        }
    }
    
    /**
     * moves the rocket forward and changes its image when called.
     */
    private void ignite( boolean boosterOn )
    {
        if (boosterOn)
        {
            setImage(rocketWithThrust);
            Vector drift = new Vector(getRotation(), 0.3);
            addForce(drift);
        }
        if (!boosterOn)
        {
            setImage(rocket);
        }
    } // end  private void ignite( boolean boosterOn )
    
    /**
     * Check to see if the rocket has collided with an asteroid.
     */
    private void checkCollision()
    {
        Actor asteroid = getOneIntersectingObject(Asteroid.class);
        if (asteroid != null)
        {
            getWorld().addObject( new Explosion(), getX(), getY() );
            Space space = (Space) getWorld();
            space.gameOver();
            getWorld().removeObject(this);
        } // end  if (asteroid != null)
    } // end  private void checkCollision()
    
    /**
     * Create a proton wave to destroy the asteroids.
     */
    private void startProtonWave()
    {
        if (protonReloadDelayCount >= protonReloadTime)
        {
            getWorld().addObject( new ProtonWave(), getX(), getY() );
            protonReloadDelayCount = 0;
        }
    } // end private void startProtonWave()
    
}