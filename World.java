import java.util.ArrayList;
/**
 * Décrivez votre classe World ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class World
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 5;
    private ArrayList<Robot> robotList;

    /**
     * Constructeur d'objets de classe World
     */
    public World()
    {
        // initialisation des variables d'instance
        robotList = new ArrayList<Robot>();
    }

    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void addRobot(String name, int xPosition, int yPosition, String colourBody)
    {
        if (verifPlace(xPosition,yPosition)==false){
            Robot robot = new Robot(name,xPosition,yPosition,colourBody);
            this.robotList.add(robot);
        }
        else{
            System.out.println("Position déjà prise ou hors du monde");
            afficheContraintes();
        }
    }
    public boolean verifPlace(int x, int y){
        if((x<=MAX_POSITION)&&(x>=MIN_POSITION)&&(y<=MAX_POSITION)&&(y>=MIN_POSITION)){
            for(Robot r:robotList){
                if((x==r.getXPosition())
                &&(y==r.getYPosition())){
                return true; 
                }
            }
        }
        else{
            return true;
        }
        return false;
    }
    public void afficheContraintes(){
        System.out.println("Les limites maximales de ce monde sont :"+MAX_POSITION);
        System.out.println("Les limites minimales de ce monde sont :"+MIN_POSITION);
        System.out.println("Les positions déjà occupées sont :");
        for(Robot r:robotList){
            System.out.println("(x,y) : "+"("+r.getXPosition()+","
            +r.getYPosition()+")");
        }
    }
    public void moveUp(Robot robot){
        boolean trouve = false;
        if ((robot.getYPosition()-1)>=MIN_POSITION){
            for(Robot robots:robotList){
                if ((robot.getYPosition()-1 == robots.getYPosition())
                &&(robot.getXPosition()==robots.getXPosition())){
                   trouve=true; 
                   break;
                }
            }
            if (trouve==false){
                robot.setYPosition(robot.getYPosition()-1); 
            }
        }   
    }
    public void moveDown(Robot robot){
        boolean trouve = false;
        if ((robot.getYPosition()+1)<=MAX_POSITION){
            for(Robot robots:robotList){
                if ((robot.getYPosition()+1 == robots.getYPosition())
                &&(robot.getXPosition()==robots.getXPosition())){
                   trouve=true; 
                   break;
                }
            }
            if (trouve==false){
                robot.setYPosition(robot.getYPosition()+1);
            }  
        }
    }
        
    public void moveLeft(Robot robot){
        boolean trouve = false;
        if ((robot.getXPosition()-1)>=MIN_POSITION){
            for(Robot robots:robotList){
                if ((robot.getXPosition()-1 == robots.getXPosition())
                &&(robot.getYPosition()==robots.getYPosition())){
                   trouve=true; 
                   break;
                }
            }
            if (trouve==false){
                robot.setXPosition(robot.getXPosition()-1);
            }
        }
    }
        
    public void moveRight(Robot robot){
        boolean trouve = false;
        if ((robot.getXPosition()+1)<=MAX_POSITION){
            for(Robot robots:robotList){
                if ((robot.getXPosition()+1 == robots.getXPosition())
                &&(robot.getYPosition()==robots.getYPosition())){
                   trouve=true; 
                   break;
                }
            }
            if (trouve==false){
                robot.setXPosition(robot.getXPosition()+1);
            }
        }
    }

    public int getNumberOfRobot(){
        return robotList.size();
    }
    
}
