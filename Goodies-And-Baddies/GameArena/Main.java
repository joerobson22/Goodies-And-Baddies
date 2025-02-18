public class Main 
{
    public static void main(String[] args)
    {
        GameArena arena = new GameArena(1000, 800);
        Player player = new Player(500, 400, 5.0, "Joe");

        player.addTo(arena);

        while(true)
        {
            //pause for 1/50th of a second
            arena.pause();

            //check for inputs
            double xMotion = 0;
            double yMotion = 0;
            
            if(arena.upPressed())
            {
                yMotion -= player.getSpeed();
            }
            if(arena.downPressed())
            {
                yMotion += player.getSpeed();
            }
            if(arena.leftPressed())
            {
                xMotion -= player.getSpeed();
            }
            if(arena.rightPressed())
            {
                xMotion += player.getSpeed();
            }

            //move player accordingly
            player.move(xMotion, yMotion);
        }
    }
}
