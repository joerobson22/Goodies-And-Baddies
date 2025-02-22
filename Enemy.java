import java.util.Random;

/**
 * nasty enemy. kill it
 */
public class Enemy {
  private final double speed;
  private final double size;
  private int health;
  private boolean newlyDead;
  private Gradient gradient;
  private final boolean isSplittable;
  private Ball ball;
  private Hitbox hitbox;

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
    this.speed = ((255 - seed) / 35);
    this.size = (seed / 6) + 15;
    this.health = (int) Math.ceil((seed + 1) / 20);
    this.isSplittable = (seed > 220) && (seed % 5 == 0);
    Gradient baseGradient;
    if (this.isSplittable) {
      baseGradient = splittableGradient;
    } else {
      baseGradient = standardGradient;
    }
    this.gradient = new Gradient(red, baseGradient.step(seed), health);
    int y_coord = random.nextInt(50, 750);
    this.ball = new Ball(1000 + size, y_coord, size, gradient.end.toString());
    hitbox = new Hitbox(size, true, false);
    hitbox.setEnemy(this);
    newlyDead = false;
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
    int clampedMin = Math.max(0, Math.min(min, 255));
    int clampedMax = Math.max(0, Math.min(max, 255));
    int seed = random.nextInt(clampedMin, clampedMax);
    return new Enemy(seed);
  }

  private void updateColour() {
    ball.setColour(gradient.step(health).toString());
  }

  public void damage() {
    health -= 1;
    System.out.println(health);
    updateColour();
  }

  public boolean isAlive() {
    return health > 0;
  }

  public boolean isDead() {
    return !isAlive();
  }

  public void moveForward() {
    if (!reachedEnd() && isAlive()) {
      ball.setXPosition(ball.getXPosition() - speed);
    }
  }

  public boolean reachedEnd() {
    return ball.getXPosition() <= size;
  }

  public void addTo(GameArena arena) {
    arena.addBall(ball);
  }

  public Ball getBall() {
    return ball;
  }

  public Hitbox getHitbox() {
    return hitbox;
  }

  public boolean isNewlyDead() {
    if (newlyDead) {
      newlyDead = false;
      return true;
    } else {
      return false;
    }
  }

  public void setNewlyDead() {
    newlyDead = true;
  }
}
