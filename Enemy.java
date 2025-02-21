import java.util.Random;

/**
 * nasty enemy. kill it
 */
public class Enemy {
  private final double speed;
  private final double size;
  private int health;
  private Gradient gradient;
  private final boolean isSplittable;

  private static Random random = new Random();

  private static Gradient standardGradient = new Gradient(
      new Colour(0, 253, 255),
      new Colour(148, 33, 147),
      255);

  private static Gradient splittableGradient = new Gradient(
      new Colour(0, 253, 255),
      new Colour(0, 143, 0),
      255);

  private static Colour red = new Colour(255, 0, 0);

  private Enemy(int seed) {
    this.speed = (seed / 9);
    this.size = (seed / 6) + 15;
    this.health = (int) Math.ceil((seed + 1) / 20);
    this.isSplittable = (seed > 220) && (seed % 5 == 0);
    Gradient baseGradient;
    if (this.isSplittable) {
      baseGradient = splittableGradient;
    } else {
      baseGradient = standardGradient;
    }
    this.gradient = new Gradient(baseGradient.step(seed), red, health);
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
