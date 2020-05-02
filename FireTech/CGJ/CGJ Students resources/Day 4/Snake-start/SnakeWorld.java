import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld  extends World
{
    private final int MAX_DOTS = (600*400)/(20*20);

    private int x[] = new int[MAX_DOTS];
    private int y[] = new int[MAX_DOTS];
    //public Dot po, no;
    private Dot po, no;
    private int dots = 4;
    private boolean firstTime=true;

    /**
     * Constructor for objects of class snakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        // Add code here to put the initial food in the World and the 
        // dots that makeup the snake's body. 
    }
    public void act()
    {
        for (int z = dots; z > 0; z--) 
        {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }
    }


    public void makeSnakeHead()
    {
        po = new Dot(0);
        addObject(po, x[0], y[0]);
    }

    public void makeSnake()
    {
        for (int z = 1; z < dots; z++) 
        {
            
            // Add code here to add the segements of the snake. Model this code after 
            // makeSnakeHead()
        }
    } 

    public void addDot()
    {
        int parentX= x[dots-1];
        int parentY= y[dots-1];

        no = new Dot(dots);
        addObject(no,parentX, parentY);
        dots ++;

    }


    public void addFood()
    {
        // Add food to random locations
        System.out.println("You need to add some food");  // Delete this line when done
    }
    
    public void setDX(int d, int dx)
    {
        x[d]=dx;
    }
    public void setDY(int d, int dy)
    {
        y[d]=dy;
    }
    
    public void gameOver()
    {
    
        Greenfoot.stop();
    }
    
    public int getMyX(int d)
    {
        return x[d];
    }
    public int getMyY(int d)
    {
        return y[d];
    }
    


}
