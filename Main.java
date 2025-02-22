import java.util.Random;
import java.util.Scanner;

public class Main 
{
    public static void startNewWave(ObjectManager objectManager, GameArena arena, Player player, int waveNum, Random rand)
    {
        //use wavenum to get the minimum and maximum values
        double max = 75 * Math.cos(Math.PI * waveNum + 1) + 180;
        double min = 75 * Math.sin(Math.PI * waveNum + 2.5) + 80;

        System.out.printf("WAVE: %d\n", waveNum);
        System.out.printf("MAX: %d\n", (int)max);
        System.out.printf("MIN: %d\n", (int)min);

        //then generate a bunch of enemies using these min and max numbers with attributes that depend on the 'seed'
        for(int i = 0; i < waveNum; i++)
        {
            Enemy e = Enemy.random((int)min, (int)max);
            objectManager.addEnemy(e);
        }
    }

    public static void main(String[] args)
    {
        final int width = 1200;
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

        ObjectManager objectManager = new ObjectManager(player, arena);
        arena.setObjectManager(objectManager);

        //setup variables
        boolean haveLost = false;
        boolean startingNewWave = false;
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
                //check if has lost
                haveLost = objectManager.haveLost();
                //if not starting a new wave
                if(!startingNewWave)
                {
                    //if all enemies are dead
                    if(objectManager.allEnemiesDead())
                    {
                        //start a new wave
                        startingNewWave = true;
                        startNewWave(objectManager, arena, player, ++waveNum, rand);
                        startingNewWave = false;
                    }
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

            //move enemies if not starting a new level
            if(!startingNewWave)
                objectManager.moveEnemies();
        }

        
    }
}
