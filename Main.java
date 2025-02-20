import java.util.Random;
import java.util.Scanner;

public class Main 
{
    public static void startNewWave(ObjectManager objectManager, GameArena arena, Player player, int wavNum, Random rand)
    {
        //use wavenum to get the minimum and maximum values
        //max = 75cos(pi * waveNum + 1) + 180
        //min = 75sin(pi * waveNum + 2.5) + 80

        //then generate a bunch of enemies using these min and max numbers with attributes that depend on the 'seed'
        /*for(int i = 0; i < waveNum; i++)
        {
            Enemy e = new Enemy(min, max);
            objectManager.addEnemy(e);
        }
        */
    }

    public static void main(String[] args)
    {
        final int width = 2000;
        final int height = 800;

        final Random rand = new Random();
        final Scanner scanner = new Scanner(System.in);

        //get name
        System.out.println("\nEnter name: ");
        String name = scanner.nextLine();
        scanner.close();

        //setup arena, player and object manager
        GameArena arena = new GameArena(width, height);

        Player player = new Player(width / 2, height / 2, 7.5, 100, 30.0, name);

        ObjectManager objectManager = new ObjectManager(player);
        arena.setObjectManager(objectManager);

        //setup variables
        boolean haveLost = false;
        boolean startNewWave = true;
        int waveNum = 0;
        int frame = 0;

        //add all player's shapes to the arena to be displayed
        player.addTo(arena);

        while(player.getHealth() > 0 && !haveLost)
        {
            //pause for 1/50th of a second
            arena.pause();
            if(frame++ >= 50)
            {
                frame = 0;
                //haveLost = objectManager.haveLost();
                if(!startNewWave)
                {
                    //startNewWave = objectManager.allEnemiesDead();
                }
                else
                {
                    //start a new wave
                    startNewWave(objectManager, arena, player, ++waveNum, rand);
                }
            }

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
