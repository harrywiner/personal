import greenfoot.*;
public class Turtle extends Obstacle
{   
    public static final int INITIAL_TURN_COUNT = 200;
    public static final int TURN_COUNT_MIN     = 50;
    public static final int TURN_COUNT_RANGE   = 500;
    
    public void act()
    {
        if (_count == 0)
        {
            faceOppositeDirection();
            _count = Greenfoot.getRandomNumber(TURN_COUNT_MIN + TURN_COUNT_RANGE);
        }
        else
        {
            _count--;
        }
        super.act();
    }
    
    private int _count = INITIAL_TURN_COUNT;
}
