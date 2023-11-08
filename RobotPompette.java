import java.util.Random;
/**
 * Le RobotPompette se déplace en diagonale. Il peut prendre a boire (de la menthe pastille) se qui le rend pompette. 
 * Plus le robot est pompette, plus il a de chances de ne pas pouvoir bouger. Il peut égallement redevenir sobre 
 * (quand le robot ne peut plus bouger)
 *
 * @Nathan Aubineau
 * @Group 5 18/10/2023
 */
public class RobotPompette extends Robot{
    private int pompette;
    /**
     * Constructeur d'objets de classe RobotPompette
     */
    public RobotPompette(){
        // initialisation des variables d'instance
        pompette = 0; //initial level of pompette
        setColourBody("BLUE"); //set the color of the robot
        redraw(); //draw the robot
    }
    /**
     * Being more pompette
     *for each method call: 20% of not moving
     */
    public void getMenthePastille()
    {
         pompette = pompette +2;
    }
    /**
     * Set the level of pompette
     */
    public void setPompette(int Pompette) {
    this.pompette = Pompette;
    }
    /**
     * Evaluate the level of pompette
     *
     * @return level of pompette
     */
    public int getPompette()
    {
        return pompette;
    }
    /**
     * Reset the level of pompette
     *
     */
    public void DevenirSobre()
    {
        this.pompette = 0;
    }
    /**
     * Move the robot in diagonal. There's a probability of not moving (pompette*10 %)
     *
     */
    public void move() {
    getMenthePastille();
    if (super.getXPosition() < super.getMaxPosition() && super.getYPosition() < super.getMaxPosition()) {
        if (pompette >= 10) {
            DevenirSobre();
            System.out.println("Sobre");
        }        
        int chanceDeNePasBouger = (pompette * 10); // probabilité de ne pas bouger
        int randomMove = new Random().nextInt(2); // Génère un nombre aléatoire 0 ou 1

        if (Math.random() * 100 >= chanceDeNePasBouger) {
            if (randomMove == 0) {
                // Avancer en diagonale
                if(getWorld().canItMove(super.getXPosition() + 1, (super.getYPosition() + 1))){
                super.setYPosition(super.getYPosition() + 1);
                super.setXPosition(super.getXPosition() + 1);
                super.getCanvasRobot().drawRobot(super.getXPosition(), super.getYPosition());
            }               
            } else {
                //reculer en diagonale
             if(getWorld().canItMove(super.getXPosition() -1, (super.getYPosition() -1))){
                super.setYPosition(super.getYPosition() - 1);
                super.setXPosition(super.getXPosition() - 1);
                super.getCanvasRobot().drawRobot(super.getXPosition(), super.getYPosition());
            }
        }
    }
    redraw();
    }
    }
}