/**
 * The WorldOfRobot class is a class that will create the world in which the robots will be displayed.
 * 
 * @Group 5
 * @version 18/10/2023
 */

public abstract class Robot 
{
    // horinzontal position of the robot
    private int xPosition; 
    // vertical position of the robot
    private int yPosition; 
    // allows one function to return both coordinates
    private int[] coord;
    private int direction = 0; 
    private String name ; 
    private static int numero = 0 ;
    private static int MIN_NAME_LENGTH = 3;
    // set the minimal position of the canva
    private static int MIN_POSITION = 0;
    // set the maximal position of the canva   
    private static int MAX_POSITION = 11; 
    //This attribute uses the CanvasRobot class to draw the robot on the canvas
    private CanvasRobot canvasRobot;
    // set the colour of the robot
    private String colourBody;
    // allows to access the world of the robots
    private static WorldOfRobot world = new WorldOfRobot();
    
    /**
     * Constructeur d'objets de classe Robot
     */
    public Robot(){ 
        //setName(name);
        canvasRobot = new CanvasRobot(this.colourBody);
        world.addRobot(this);
        coord = world.getValidCoordinate();
        xPosition = coord[0];
        yPosition = coord[1];
        //System.out.println(xPosition);
        //System.out.println(yPosition);
        canvasRobot.drawRobot(xPosition, yPosition);
        direction=0;
    }
    
    public Robot(int x , int y){ 
        //setName(name);
        setXPosition(x);
        setYPosition(y);
        direction=0;
        canvasRobot = new CanvasRobot(this.colourBody);
        canvasRobot.drawRobot(xPosition,yPosition);
        //world = w;
    }
    
    /**
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
        
    public void setYPosition (int y){
        if (y > MAX_POSITION)
            yPosition = MAX_POSITION;
        else if (y < MIN_POSITION)
            yPosition = MIN_POSITION;
        else
            yPosition = y;
    }
    
    public void setXPosition (int x){
        if (x > MAX_POSITION)
            xPosition = MAX_POSITION;
        else if (x < MIN_POSITION)
            xPosition = MIN_POSITION;
        else
            xPosition = x;
    }
    
    public int getYPosition(){
        return yPosition ;
    }
    
    public int getXPosition(){
        return xPosition;
    }
    
    public void setDirection(int d)
    {
        direction = d;
    }
    
    public int getDirection()
    {
        return direction;        
    }
    
    public WorldOfRobot getWorld()
    {
        return world;
    }
    
    // public void setName(String name)
    // {
        // name = name.trim() ;
        // if ( name.length() >= MIN_NAME_LENGTH ){
        // name = name ;    
        // }
        // else {
        // numero++ ;    
        // String tempname= "iRobot"+ numero ;
        // name = tempname ;
        // }
    // }
    public String getName(){
        return name ;
    }
   
//Start GetterSetterExtension Source Code

    /**GET Method Propertie colourBody*/
    public String getColourBody(){
        return this.colourBody;
    }//end method getColourBody

//End GetterSetterExtension Source Code

//Start GetterSetterExtension Source Code

    /**GET Method Propertie canvasRobot*/
    public CanvasRobot getCanvasRobot(){
        return this.canvasRobot;
    }//end method getCanvasRobot

//End GetterSetterExtension Source Code

//Start GetterSetterExtension Source Code

    /**SET Method Propertie colourBody*/
    public void setColourBody(String colourBody)
    {
        if (isColourFound(colourBody))
        {    
            this.colourBody = colourBody; 
            canvasRobot.setColourBody(this.colourBody);
        }
        else
        {
            this.colourBody = "BLUE"; 
            
        }
    }    

    
    public boolean isColourFound(String newColor)
    {
        newColor = newColor.toUpperCase();
        for (Colour c : Colour.values()) 
        { 
            if (c.name().equals(newColor)) 
            { 
                return true;
            }   
        } 
        return false;
    }
    
    public void move() 
    {
        if ((xPosition < MAX_POSITION && yPosition < MAX_POSITION)) {
        
            yPosition ++;
            xPosition ++;
            canvasRobot.drawRobot(xPosition,yPosition);
    
        }

    }
    
    public void moveDroite() 
    {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            if(getWorld().canItMove((xPosition+1), yPosition)){
                xPosition ++;
                canvasRobot.drawRobot(xPosition,yPosition);                
            }
        }
    }
    
    public void moveGauche() 
    {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            if(getWorld().canItMove((xPosition-1), yPosition)){
                xPosition --;
                canvasRobot.drawRobot(xPosition,yPosition);                
            }
        }
    }
    
    public void moveBas() 
    {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            if(getWorld().canItMove(xPosition, (yPosition+1))){
                yPosition ++;
                canvasRobot.drawRobot(xPosition,yPosition);                
            }
        }
    }
    
    public void moveHaut() 
    {
        if (xPosition < MAX_POSITION && yPosition < MAX_POSITION) {
            if(getWorld().canItMove(xPosition, (yPosition-1))){
                yPosition --;
                canvasRobot.drawRobot(xPosition,yPosition);                
            }
        }
    }
    
    public void redraw()
    {
        canvasRobot.drawRobot(xPosition,yPosition);
    }
    
    public boolean isOnBorder(int value)
    {
        if (value == MAX_POSITION)
            return true;
        else
            return false;
    }
    
    public static int getMaxPosition()
    {
        return MAX_POSITION;
    }
    
    public static int getMinPosition()
    {
        return MIN_POSITION;
    }
    
    public void setWorld(WorldOfRobot w) {
        this.world = w;
    }
    
    public static void moveAll(int n) {
        int i = 0; 
        for (i = 0; i <= n; i++) { 
            for (Robot r : world.getList()) {
                r.move();
            }
            try {
                    Thread.sleep(500); // Attendre une seconde (1000 millisecondes)
            } catch (InterruptedException e){
            }
        }
    }

}