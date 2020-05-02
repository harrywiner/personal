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

        for (int i=0; i<1; i++)
        {
            addObject(new Food(),Greenfoot.getRandomNumber(12)*50+25,Greenfoot.getRandomNumber(8)*50+25); 
        }
        
        for (int z = 0; z < dots; z++) {
            x[z] = 100 - z*20;
            y[z] = 20;
        }
        makeSnakeHead();
        makeSnake();
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
            
            Dot no=new Dot(z);
            addObject(no, x[z], y[z]);
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
        for (int i=0; i<Greenfoot.getRandomNumber(2)+1;i++)
        {
            addObject(new Food(),Greenfoot.getRandomNumber(12)*50+25,Greenfoot.getRandomNumber(8)*50+25); 
        }
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
        //setBackground("GameOver.jpg");
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
