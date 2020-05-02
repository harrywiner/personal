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
        if (d==0)
        {    
            lead();
            lookForFood();
            lookForEdge();
            lookForDot();
        }
        else
        {
            follow();
        }
    }   

    public void lead()
    {    
        x=getX();
        y=getY();

        if (Greenfoot.isKeyDown("left"))
        {
            //x -= DOT_SIZE;
            setRotation(180);
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            //x += DOT_SIZE; 
            setRotation(0);
        }
        else if (Greenfoot.isKeyDown("up"))
        {
            //y -= DOT_SIZE; 
            setRotation(270);
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            //y += DOT_SIZE;
            setRotation(90);
        }
        
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

        SnakeWorld myWorld;
        myWorld= (SnakeWorld)getWorld();
        myWorld.addDot();
    }

    public void lookForFood()
    {
        if (canSee(Food.class))
        {
            eat(Food.class);
            growTail();
            SnakeWorld myWorld;
            myWorld= (SnakeWorld)getWorld();
            myWorld.addFood();
        }
    }

    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }

    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
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
        if (canSee(Dot.class))
        {
            SnakeWorld myWorld;
            myWorld= (SnakeWorld)getWorld();
            myWorld.gameOver();
        }
    }
    public void stayOnCourse()
    {
        double angle = Math.toRadians( getRotation() );
        x = (int) Math.round(getX() + Math.cos(angle) * DOT_SIZE);
        y = (int) Math.round(getY() + Math.sin(angle) * DOT_SIZE);
        
    }
  
}
