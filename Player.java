public class Player 
{
    //position and size variables
    private double x;
    private double y;
    private double hitboxSize;

    private final double textOffset = 5.0;

    //attributes
    private double speed;
    private int health;
    private int damage;
    
    //identification: name
    private String name;

    //visual variables: ball array, nametag
    private Ball[] balls = new Ball[1];
    private Text nameTag;

    //functionality variables: hitbox
    private Hitbox hitbox;

    /** 
     * Constructor for player object
     * @param x starting x
     * @param y starting y
     * @param speed player's default speed
     * @param hitboxSize radius of the player's circular hitbox
     * @param name text in the label above the player's head to signify they are the player
     */
    public Player(double x, double y, double speed, int health, double hitboxSize, String name)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.name = name;


        //create new nametag
        this.nameTag = new Text(name, 20, x, y, "GREEN", 5);

        //create circles
        Ball b = new Ball(x, y, hitboxSize, "GREEN");
        balls[0] = b;

        //create hitbox
        hitbox = new Hitbox(hitboxSize * 0.65, false, true);
        hitbox.setPlayer(this);
    }

    /** 
     * Function to add all the player's objects (balls, rectangles) to the game arena to be displayed
     * @param arena game arena reference
     */
    public void addTo(GameArena arena)
    {
        //add all balls
        for(int i = 0; i < balls.length; i++)
        {
            arena.addBall(balls[i]);
        }

        //add nametag
        arena.addText(nameTag);
    }

    //move function
    public void move(double xMove, double yMove)
    {
        x += xMove;
        y += yMove;
        moveShapes(xMove, yMove);
    }

    //adjust shapes
    private void moveShapes(double xMove, double yMove)
    {
        //move all balls
        for(int i = 0; i < balls.length; i++)
        {
            balls[i].move(xMove, yMove);
        }

        //move nametag
        nameTag.setXPosition(x - (name.length() * textOffset));
        nameTag.setYPosition(y - 20);
    }

    //accessors
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getSpeed()
    {
        return speed;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDamage()
    {
        return damage;
    }

    public void click(double mouseX, double mouseY)
    {
        boolean hasBeenClicked = hitbox.click(mouseX, mouseY);
        if(hasBeenClicked)
        {
            System.out.println("\nPLAYER CLICKED!!!");
        }
    }
}
