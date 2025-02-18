public class Player 
{
    //position variables
    private double x;
    private double y;

    //attributes
    private double speed;
    
    //identification: name
    private String name;

    //visual variables: ball array, nametag
    private Ball[] balls = new Ball[1];
    private Text nameTag;



    //constructor
    public Player(double x, double y, double speed, String name)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.name = name;

        //create new nametag
        this.nameTag = new Text(name, 20, x, y, "GREEN", 5);

        //create circles
        Ball b = new Ball(x, y, 25, "GREEN");
        balls[0] = b;
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
        nameTag.setXPosition(x);
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

}
