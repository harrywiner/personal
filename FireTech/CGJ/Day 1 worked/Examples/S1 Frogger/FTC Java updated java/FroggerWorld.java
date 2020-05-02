import greenfoot.*;

public class FroggerWorld extends World
{
    public static final int WIDTH     = 100;
    public static final int HEIGHT    = 60;
    public static final int CELL_SIZE = 10;

    public static final int ENDPOS        = HEIGHT * 5  / 100;
    public static final int GAP1POS       = HEIGHT * 20 / 100;
    public static final int ROADPOS       = HEIGHT * 35 / 100;
    public static final int ROADTOPPOS    = HEIGHT * 32 / 100;
    public static final int ROADBOTTOMPOS = HEIGHT * 39 / 100;
    public static final int GAP2POS       = HEIGHT * 50 / 100;
    public static final int RIVERPOS      = HEIGHT * 65 / 100;
    public static final int GAP3POS       = HEIGHT * 80 / 100;
    public static final int STARTPOS      = HEIGHT * 95 / 100;

    public FroggerWorld()
    {    
        super(WIDTH, HEIGHT, CELL_SIZE);
        
        addObject(new House1(), 30, ENDPOS);
        
        Ladybird ladybird = new Ladybird();
        ladybird.setSpeed(1.5);
        
        Bee bee = new Bee();
        
        Hedgehog hedgehog = new Hedgehog();
        
        addObject(ladybird, 10, GAP1POS);
        addObject(bee, 30, GAP1POS);
        addObject(hedgehog, 70, GAP1POS);

        drawRoad(WIDTH/2, ROADPOS);
        
        Car car = new Car();
        addObject(car, 10, ROADTOPPOS);
        car = new Car();
        addObject(car, 30, ROADTOPPOS);
        car = new Car();
        addObject(car, 60, ROADTOPPOS);
        

        car = new Car();
        car.setFacingDirection(Mover.LEFT);
        addObject(car, 10, ROADBOTTOMPOS);
        
        car = new Car();
        car.setFacingDirection(Mover.LEFT);
        addObject(car, 30, ROADBOTTOMPOS);
        
        car = new Car();
        car.setFacingDirection(Mover.LEFT);
        addObject(car, 60, ROADBOTTOMPOS);
        
        
        Turtle turtle = new Turtle();
        addObject(turtle, 15, GAP2POS);

        drawRiver(WIDTH/2, RIVERPOS);

        Fish fish = new Fish();
        addObject(fish, 10, RIVERPOS);
        
        Grass grass = new Grass();
        addObject(grass, 20, RIVERPOS);

        Aligator aligator = new Aligator();
        addObject(aligator, 50, RIVERPOS);

        grass = new Grass();
        addObject(grass, 90, RIVERPOS);

        Spider spider = new Spider();
        addObject(spider, 30, GAP3POS);

        Frog frog = new Frog();
        addObject(frog, 5, STARTPOS);
    }
    
    public void drawRoad(int xpos, int width)
    {
        addObject(new Road(), xpos, width);
    }

    public void drawRiver(int xpos, int width)
    {
        addObject(new River(), xpos, width);
    }
    
    public void gameOver()
    {
        Greenfoot.stop();
    }
}
