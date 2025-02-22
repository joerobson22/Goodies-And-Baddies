public class ObjectManager
{
    private Player player;
    private Enemy[] enemies = new Enemy[100];
    private int enemyIndex = 0;
    private GameArena arena;

    /** 
     * Constructor for ObjectManager
     * @param player takes player as parameter to be able to call functions on the player
     */
    public ObjectManager(Player player, GameArena arena)
    {
        this.player = player;
        this.arena = arena;
    }

    /**
     *  Accessor method for getting the player the ObjectManager holds
     * @return returns the player
     */
    public Player getPlayer()
    {
        return player;
    }

    /**
     * Function to add an enemy to the enemy array, then incrementing the enemyIndex, as well as adding to arena
     * @param e the enemy you're adding
     */
    public void addEnemy(Enemy e)
    {
        enemies[enemyIndex++] = e;
        e.addTo(arena);
    }

    /**
     * All enemies from a wave died, clear the array and reset the enemyIndex for performance purposes
     */
    
    public void clearEnemies()
    {
        removeDeadEnemies();
        for(int i = 0; i < enemyIndex; i++)
        {
            enemies[i] = null;
        }
        enemyIndex = 0;
    }
     

     /**
      * Check if any enemies have moved beyond the 'gate'
      * @return true: have lost, false: haven't lost
      */
    public boolean haveLost()
    { 
       for(int i = 0; i < enemyIndex; i++)
       {
           if(enemies[i].reachedEnd())
           {
               return true;
           }
       }
       return false;
    }
        
    /**
    * Checks if all enemies are dead, and therefore if another wave should start, as well as clearing all enemies
    * @return true if all are dead, false if otherwise
    */
    public boolean allEnemiesDead()
    {
        for(int i = 0; i < enemyIndex; i++)
        {
            if(!enemies[i].isDead())
            {
                return false;
            }
        }
        clearEnemies();
        return true;
    }

    public void click(double mouseX, double mouseY)
    {
        for(int i = 0; i < enemyIndex; i++)
        {
            if(enemies[i].isAlive())
            {
                System.out.printf("clicking enemy?\n");
                enemies[i].getHitbox().clickEnemy(mouseX, mouseY);
            }
        }
        removeDeadEnemies();
    }

    public void removeDeadEnemies()
    {
        for(int i = 0; i < enemyIndex; i++)
        {
            if(enemies[i].isNewlyDead())
            {
                arena.removeBall(enemies[i].getBall());
            }
        }
    }

    public void moveEnemies()
    {
        for(int i = 0; i < enemyIndex; i++)
        {
            if(enemies[i].isAlive())
            {
                enemies[i].moveForward();
            }
                
        }
    }
    
}
