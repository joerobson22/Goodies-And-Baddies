public class ObjectManager
{
    private Player player;
    //private Enemy[100] enemies;
    //private int enemyIndex = 0;

    /** 
     * Constructor for ObjectManager
     * @param player takes player as parameter to be able to call functions on the player
     */
    public ObjectManager(Player player)
    {
        this.player = player;
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
     * Function to add an enemy to the enemy array, then incrementing the enemyIndex
     * @param e the enemy you're adding
     */
    /*public void addEnemy(Enemy e)
    {
        enemies[enemyIndex++] = e;
    }
    */

    /**
     * All enemies from a wave died, clear the array and reset the enemyIndex for performance purposes
     */
    /*
     * public void clearEnemies()
     * {
     *      for(int i = 0; i < enemyIndex; i++)
     *      {
     *          enemies[i] = null;
     *          enemyIndex = 0;
     *      }
     * }
     */

     /**
      * Check if any enemies have moved beyond the 'gate'
      * @return true: have lost, false: haven't lost
      */
      /*
       * public boolean haveLost()
       * { 
       *    for(int i = 0; i < enemyIndex; i++)
       *    {
       *        if(enemies[i].getX() < 10)
       *        {
       *            return true;
       *        }
       *    }
       *    return false
       * }
       */

       /**
        * Checks if all enemies are dead, and therefore if another wave should start, as well as clearing all enemies
        * @return true if all are dead, false if otherwise
        */
        /*
         * public boolean allEnemiesDead()
         * {
         *      for(int i = 0; i < enemyIndex; i++)
         *      {
         *          if(!enemies[i].isDead())
         *          {
         *              clearEnemies();
         *              return false;
         *          }
         *      }
         *      return true;
         * }
         */
}
