import greenfoot.*; 

public class AutoMover extends Mover
{
    private int     _moveCounter     = 0;
    private boolean _isMoving        = true;
    private int     _speed           = 10;
    
    public void act() 
    {
        if (_isMoving)
        {
            _moveCounter++;
            if (_moveCounter == _speed)
            {
                _moveCounter = 0;
                move();
                if (atWorldEdge())
                {
                    wrapWorld();
                }
            }
        }
    }
    
    public void enableMovement()
    {
        _isMoving = true;
    }
    
    public void disableMovement()
    {
        _isMoving = false;
    }   
}
