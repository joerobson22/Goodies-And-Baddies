import java.util.Random;

/**
 * nasty enemy. kill it
 */
public class Enemy {
  private final double speed;
  private final double size;
  private int health;
  private final Colour colour;
  private final boolean isSplittable;

  private static Random random = new Random();

  private Enemy(int seed) {
    this.speed = (seed / 9);
    this.size = (seed / 6) + 15;
    this.health = (int) Math.ceil((seed + 1) / 20);
    this.isSplittable = (seed > 220) && (seed % 5 == 0);
    if (this.isSplittable) {
      // use the splittable gradient
      this.colour = new Colour(0, (int) -(seed / 2.7) + 250, -seed + 255);
    } else {
      // use the standard gradient
      this.colour = new Colour((int) (seed / 1.7), (int) -(seed / 1.17) + 253, (int) -(seed / 2.4) + 255);
    }
    // TODO: balls
  }

  /**
   * Create a random enemy using the given constraints.
   *
   * Lower values will give smaller enemies (faster, bluer, weaker...)
   *
   * @param min The minimum seed, greater than or equal to 0.
   * @param max The maximum seed, greater than or equal to 255.
   * @return The generated Enemy.
   */
  public static Enemy random(int min, int max) {
    int clampedMin = Math.clamp(min, 0, 255);
    int clampedMax = Math.clamp(max, 0, 255);
    int seed = random.nextInt(clampedMin, clampedMax);
    return new Enemy(seed);
  }
}
