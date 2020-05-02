import greenfoot.*;

public class River extends Background
{
    public GreenfootImage createImage(int width, int height)
    {
      GreenfootImage image;        
      image = new GreenfootImage(width, height);
      image.setColor(Color.BLUE);
      image.clear();
      image.fill();
      return image;
    }
   
}
