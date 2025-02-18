public class Sample 
{
    public static void main(String[] args)
    {
        GameArena arena = new GameArena(1000, 800);
        Ball b = new Ball(500, 400, 50, "GREEN");

        arena.addBall(b);

        while(true)
        {
            arena.pause();
        }
    }
}
