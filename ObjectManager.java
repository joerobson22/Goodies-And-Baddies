public class ObjectManager
{
    private Player player;
    //private Enemy[] enemies;

    public ObjectManager(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }
}
