/**
 * Décrivez votre classe Robot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int xPosition;
    private int yPosition;
    private String name;
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 5;
    private static int numberOfUnnamedRobots;
    private CanvasRobot canvasRobot;
    private String colourBody;
    

    /**
     * Constructeur d'objets de classe Robot
     */
    public Robot(String name, int xPosition, int yPosition, String colourBody)
    {
        name = name.trim();
        if (name.length() >= MIN_NAME_LENGTH){
            this.name = name;
        }
        else{
            numberOfUnnamedRobots++;
            this.name ="iRobot" + numberOfUnnamedRobots;
        }
        if ((xPosition >= MIN_POSITION)&&(xPosition <= MAX_POSITION)){
            this.xPosition = xPosition;
        }
        else{
            this.xPosition = 0;
        }
        if ((yPosition >= MIN_POSITION)&&(yPosition <= MAX_POSITION)){
            this.yPosition = yPosition;
        }
        else{
            this.yPosition = 0;
        }
        this.colourBody = colourBody;
        CanvasRobot canvasRobot = new CanvasRobot(this.colourBody);
        this.canvasRobot = canvasRobot;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    }
    public String getName()
    {
        return name;
    }
    public void setName(String newName){
        newName = newName.trim();
        if(newName.length() >= MIN_NAME_LENGTH){
        this.name = newName;
    }
        
    }
    public int getXPosition()
    {
        return this.xPosition;
    }
    public void setXPosition(int newXPosition){
        this.xPosition = newXPosition;  
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    }
    public int getYPosition()
    {
        return this.yPosition;
    }
    public void setYPosition(int newYPosition){ 
        this.yPosition = newYPosition;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    }
    public String getColourBody(){
        return this.colourBody;
    }
    public void setColourBody(String newColorBody){
        this.canvasRobot.setColourBody(newColorBody);
    }
    public void move(){
        this.yPosition +=1;
        this.xPosition +=1;
        this.canvasRobot.drawRobot(this.xPosition,this.yPosition);
    }
    

}
