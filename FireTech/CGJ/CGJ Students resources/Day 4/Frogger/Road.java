import greenfoot.*;  

public class Road extends Background
{
    public GreenfootImage createImage(int width, int height)
    {
      GreenfootImage image;        
      image = new GreenfootImage(width, height);
      image.setColor(Color.GRAY);
      image.clear();
      image.fill();
      image.setColor(Color.WHITE);
      for (int i=0; i<width; i+=width/10)
      {
        image.drawLine(i, height/2, i+(width/20), (height/2));
      }
      return image;
    }    
}
