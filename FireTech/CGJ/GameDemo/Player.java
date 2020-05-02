import greenfoot.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Gravitor
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        super(1);
        
        setRotation(0);
    }

    public void act()
    {
        super.act();
        jump(10);
    }
}
