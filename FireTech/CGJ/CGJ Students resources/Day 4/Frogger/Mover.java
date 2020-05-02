import greenfoot.*;  

public class Mover extends Actor
{
    public static final int RIGHT = 0;
    public static final int DOWN  = 90;
    public static final int LEFT  = 180;
    public static final int UP    = 270;
    public static final double WALKING_SPEED = 1.0;
    
    private static final int _MARGIN = 2;
    private double _speed            = WALKING_SPEED;
    private boolean _isMirrored      = false;
    private int _facingDirection     = RIGHT;
    private int _movingDirection     = RIGHT;
       
    public void faceOppositeDirection()
    {
        if (_facingDirection > 180)
        {
            setFacingDirection(_facingDirection - 180);
        }
        else
        {
            setFacingDirection(_facingDirection + 180);
        }
    }
    
    public void setFacingDirection(int direction)
    {    
        updateMirror(direction);
        _facingDirection = direction;
        _movingDirection = direction;
        setRotation(direction);
    }
    
    public void setMovingDirection(int direction)
    {
        _movingDirection = direction;
    }
   
    public void mirrorImage()
    {
        GreenfootImage img = getImage();
        img.mirrorVertically();
    }

    
    public void updateMirror(int direction)
    {
        if (direction > 90 && direction < 270)
        { /* Should be mirrored */
            if (! _isMirrored)
            {
                mirrorImage();
                _isMirrored = true;
            }
        }
        else
        { /* Should be unmirrored */
            if (_isMirrored)
            {
                mirrorImage();
                _isMirrored = false;
            }
        }
    }

    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(_movingDirection + angle);
    }
    

    /**
     * Move a bit forward in the current direction.
     */
    public void move()
    {
        move(_speed);
    }

    
    /**
     * Move a specified distance forward in the current direction.
     */
    public void move(double distance)
    {
        double angle = Math.toRadians( _movingDirection );
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        
        setLocation(x, y);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true if we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < _MARGIN || getX() > getWorld().getWidth() - _MARGIN)
            return true;
        if(getY() < _MARGIN || getY() > getWorld().getHeight() - _MARGIN)
            return true;
        else
            return false;
    }
    
    public void setSpeed(double speed)
    {
        _speed = speed;   
    }
    
    public void wrapWorld()
    {
        if (getX() < _MARGIN)
        {
            setLocation(getWorld().getWidth()- _MARGIN, getY());
        }
        else if (getX() > getWorld().getWidth()- _MARGIN)
        {
            setLocation(_MARGIN, getY());
        }
        
        if (getY() < _MARGIN)
        {
            setLocation(getX(), getWorld().getHeight()- _MARGIN);
        }
        else if (getY() > getWorld().getHeight()- _MARGIN)
        {
            setLocation(getX(), _MARGIN);
        }
    }
}
