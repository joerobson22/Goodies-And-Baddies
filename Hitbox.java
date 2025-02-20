public class Hitbox 
{
    //x and y coordinates fetched from parent when computing if colliding
    private double size;

    private boolean canBeClicked;
    private boolean canCollide;

    //allows hitbox to send messages via calling methods on its parent nodes
    Player parentPlayer = null;
    //Enemy parentEnemy = null; once the enemy class has been created

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
    /*
    public void setEnemy(Enemy enemy)
    {
        this.parentEnemy = enemy;
    }
    */

    //click detection method
    public boolean click(double mouseX, double mouseY)
    {
        //calculate distance from centre of player to the mouse, if less than or equal, then player has been clicked
        double xDistance = Math.abs(parentPlayer.getX() - mouseX);
        double yDistance = Math.abs(parentPlayer.getY() - mouseY);
        double overallDistance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        return (canBeClicked && overallDistance <= size);
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
