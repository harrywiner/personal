import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dot  extends Actor
{
    private int x,y,d;
    private final int DOT_SIZE=20;

    /**
     * Act - do whatever the Dot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Dot(int dot)
    {
        GreenfootImage image1 = new GreenfootImage("SnakeHead.gif");
        image1.mirrorHorizontally();

        d = dot;
        if (d==0)
        {
            setImage(image1);
        }
        else
        {
            setImage("close.png");
        }
    }

    /**
     * Act - do whatever the Head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        // If you are the head you will want to lead, and eventually do things like eat,
        // check the edges etc, and if you aren't the head you just want to follow. 
    }   

    public void lead()
    {    
        x=getX();
        y=getY();

        // Add code here - based on the key that is pressed change the orientation of the 
        // head. 
        
        stayOnCourse();
        
        setLocation(x,y);
        SnakeWorld myWorld;
        myWorld= (SnakeWorld)getWorld();
        myWorld.setDX(d,x);
        myWorld.setDY(d,y);

    }

    public void follow()
    {
        SnakeWorld myWorld;
        myWorld= (SnakeWorld)getWorld();
        x=myWorld.getMyX(d);
        y=myWorld.getMyY(d);
        setLocation(x,y);
    }

    public void growTail()
    {

        // Add code here to grow the tail. (A tail is a dot in the SnakeWorld
    }

    public void lookForFood()
    {
        // Add code to see if there is food present and if there is eat, the food, grow the snake, 
        // and add more food to the SnakeWorld
        
        
            }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void eat(Class clss)
    {
        // add code to get the food and remove from the world.
    }

    public boolean atWorldEdge()
    {
        // Add code here to detect if the head is at the edge of the world, if it is 
        // return true.
            return false;
    }

    public void lookForEdge()
    {
        if (atWorldEdge())
        {
            SnakeWorld myWorld;
            myWorld= (SnakeWorld)getWorld();
            myWorld.gameOver();
        }
    }

    public void lookForDot()
    {
       // Add code here to figure out if the snake hits one of its own joints. 
       // Remember a joint is a Dot object. 
    }
    public void stayOnCourse()
    {
        double angle = Math.toRadians( getRotation() );
        x = (int) Math.round(getX() + Math.cos(angle) * DOT_SIZE);
        y = (int) Math.round(getY() + Math.sin(angle) * DOT_SIZE);
        
    }
  
}
