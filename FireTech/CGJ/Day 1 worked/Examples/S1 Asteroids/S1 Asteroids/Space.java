import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
//import java.awt.Color;
import java.util.List;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;

    public Space() 
    {
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        createStars( 300 );
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    /**
     * Add a number of stars into the scene. number is used to determine how many stars are created.
     */
    private void createStars( int number )
    {
        GreenfootImage background = getBackground();
        for ( int i = 0; i < number; i++ )
        {
            int x = Greenfoot.getRandomNumber( getWidth() );
            int y = Greenfoot.getRandomNumber( getHeight() );
            int color = Greenfoot.getRandomNumber( 256 );
            background.setColor( new Color(color, color, color) );
            background.fillOval(x, y, 2, 2);
        } // end for ( int i = 0; i < number; i++ )
    }
    
    /**
     * Counts the score
     */
    public void countScore()
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            s.add(100);
        }
    }
    
    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        List<Counter> score = getObjects(Counter.class);
        for (Counter s : score)
        {
            int finalScore = s.getValue();
            addObject( new ScoreBoard( finalScore ), getWidth()/2, getHeight()/2 );
        }

    }

}