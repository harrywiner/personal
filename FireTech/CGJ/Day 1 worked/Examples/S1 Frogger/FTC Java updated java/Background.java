import greenfoot.*;

public class Background extends Actor
{   
    public GreenfootImage createImage(int width, int height)
    {
        return new GreenfootImage(width, height);
    }
    
    public GreenfootImage getImage()
    {
        if (_image == null)
        {
            _image = createImage(getWorld().getCellSize()*getWorld().getWidth(), 80);
        }
        return _image;
    }
    
    protected GreenfootImage _image;
}
