import java.util.Random;
/**
 * Décrivez votre classe DashBot ici.
 *The DashBot is just a basical robot that can move 1 square by 1. 
 * He also has a little probability to move of 3 square 
 * @Nicolas Bonneau
 * @Group 5 01/11/2023
 */
public class DashBot extends Robot
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int xPos = getXPosition();
    private int yPos = getYPosition();
    private int Max = getMaxPosition();
    private int Min = getMinPosition();
    private Random random = new Random();
    private double proba;
    /**
     * Constructeur d'objets de classe DashBot
     */
    public DashBot()
    {
        // initialisation des variables d'instance
        super();
        setColourBody("RED");
        
    }
    
    /**
     * Method that give that choose randomly the type of movement of the bot in function of a probability
     */
    public void move(){
        
        proba = random.nextInt(100);
        //System.out.println(proba);
        if (proba >= 40 ) {
            if(getWorld() != null && getWorld().canItMove((getXPosition()+1) , (getYPosition()+1)) && ((getYPosition()+1) <= Max && (getXPosition()+1) <= Max)){
                setYPosition(getYPosition()+1); 
                setXPosition(getXPosition()+1);
                redraw();
            }   
        }
        else if(proba >= 0 && proba < 10){
            dashBas();
        }else if(proba >= 10 && proba < 20){
            dashHaut();
        }else if(proba >= 20 && proba < 30){
            dashGauche();
        }else if(proba >= 30 && proba < 40){
            dashDroite();
        }
        
    }
    
    /**
     * Robot can dash up
     */
    public void dashHaut()
    {
        if ((getYPosition()-3) > Min) {
            if (getWorld() != null && getWorld().canItMove(getXPosition(), (getYPosition()-3))){
            setYPosition(getYPosition()-3);
            redraw();
            }
        }
    }
    
    /**
     * Robot can dash down
     */
    public void dashBas()
    {
        if ((getYPosition()+3) < Max) {
            if (getWorld() != null && getWorld().canItMove(getXPosition(),(getYPosition()+3))){
            setYPosition(getYPosition()+3);
            redraw();
            }
        }
    }
    
    /**
     * Robot can dash right
     */
    public void dashDroite()
    {
        if ((getXPosition() + 3) < Max) {
            if (getWorld() != null && getWorld().canItMove((getXPosition()+3), getYPosition())){
               setXPosition(getXPosition()+3);
               redraw(); 
            }
        }
    }
    
    /**
     * Robot can dash left
     */
    public void dashGauche()
    {
        if ((getXPosition()-3) > Min) {
            if (getWorld() != null && getWorld().canItMove((getXPosition()-3), getYPosition())){
               setXPosition(getXPosition()-3);
               redraw();
            }
        }
    }
}