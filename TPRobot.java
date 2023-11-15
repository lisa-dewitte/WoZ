import java.util.Random;

/**
 * Décrivez votre classe TPRobot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TPRobot extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int MIN_POSITION = -5;
    private int MAX_POSITION = 5;
    private World world;
    
    /**
     * Constructeur d'objets de classe TPRobot
     */
    public TPRobot(String name, int xPosition, int yPosition, String colourBody, World world)
    {
        // initialisation des variables d'instance
       super(name, xPosition, yPosition, colourBody);
       this.world = world;
       //world.addRobot(this.getName(), this.getXPosition(), this.getYPosition(), this.getColourBody());
    }
    
    public void addRobotToWorld() {
        this.world.addRobot(super.getName(), super.getXPosition(), super.getYPosition(), super.getColourBody());
    }
    
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void randomTP()
    {
        // Create a random number generator
        Random random = new Random();

        int newX, newY;

        // Repeat until a collision-free position is found
        do {
            // Generate random X and Y coordinates within the canvas boundaries
            newX = random.nextInt(MAX_POSITION - MIN_POSITION + 1) + MIN_POSITION;
            newY = random.nextInt(MAX_POSITION - MIN_POSITION + 1) + MIN_POSITION;
        } while (world.verifPlace(newX, newY));

        // Teleport the robot to the new position
        setXPosition(newX);
        setYPosition(newY);
    }
}
