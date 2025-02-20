public class Player 
{
    //position and size variables
    private double x;
    private double y;
    private double size;

    private final double textOffset = 5.0;

    //attributes
    private double speed;
    
    //identification: name
    private String name;

    //visual variables: ball array, nametag
    private Ball[] balls = new Ball[1];
    private Text nameTag;

    //functionality variables: hitbox
    private Hitbox hitbox;

    //constructor
    public Player(double x, double y, double speed, double size, String name)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.name = name;


        //create new nametag
        this.nameTag = new Text(name, 20, x, y, "GREEN", 5);

        //create circles
        Ball b = new Ball(x, y, size, "GREEN");
        balls[0] = b;

        //create hitbox
        hitbox = new Hitbox(size * 0.65, false, true);
        hitbox.setPlayer(this);
    }

    //addTo function
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

    public void click(double mouseX, double mouseY)
    {
        boolean hasBeenClicked = hitbox.click(mouseX, mouseY);
        if(hasBeenClicked)
        {
            System.out.println("\nPLAYER CLICKED!!!");
        }
    }
}
