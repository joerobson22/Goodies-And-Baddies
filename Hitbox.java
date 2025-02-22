public class Hitbox 
{
    //x and y coordinates fetched from parent when computing if colliding
    private double size;

    private boolean canBeClicked;
    private boolean canCollide;

    //allows hitbox to send messages via calling methods on its parent nodes
    Player parentPlayer = null;
    Enemy parentEnemy = null;

    //constructor
    public Hitbox(double size, boolean canBeClicked, boolean canCollide)
    {
        this.size = size;
        this.canBeClicked = canBeClicked;
        this.canCollide = canCollide;
    }

    //set parent player method
    public void setPlayer(Player player)
    {
        this.parentPlayer = player;
    }

    //set parent enemy method
    public void setEnemy(Enemy enemy)
    {
        this.parentEnemy = enemy;
    }

    //click detection method
    public void clickEnemy(double mouseX, double mouseY)
    {
        if(parentEnemy.isAlive())
        {
            System.out.printf("CLICK AND ALIVE\n");
            //calculate distance from centre of enemy to the mouse, if less than or equal, then player has been clicked
            double xDistance = Math.abs(parentEnemy.getBall().getXPosition() - mouseX);
            double yDistance = Math.abs(parentEnemy.getBall().getYPosition() - mouseY);
            double overallDistance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
            
            System.out.printf("xDistance: %f\n", xDistance);
            System.out.printf("yDistance: %f\n", yDistance);
            System.out.printf("overall Distance: %f\n", overallDistance);
            System.out.printf("size: %f\n", size);

            //if within hitbox, damage
            if(overallDistance <= size)
            {
                parentEnemy.damage();
            }
            //if parent is now dead
            if(parentEnemy.isDead())
            {
                parentEnemy.setNewlyDead();
            }
        }
        
    }

    //accessors
    public double getSize()
    {
        return size;
    }

    public boolean isClickable()
    {
        return canBeClicked;
    }

    public boolean isCollidable()
    {
        return canCollide;
    }
}
