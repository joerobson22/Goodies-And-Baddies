public class Colour {
  private int r;
  private int g;
  private int b;

  /**
   * Construct a new Colour with given r, g, and b values.
   *
   * Values should be between 0 and 255.
   *
   * @param r Red.
   * @param g Green.
   * @param b Blue.
   */
  public Colour(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Clamp this Colour's rgb values to between 0 and 255.
   */
  public void clamp() {
    this.r = Math.clamp(this.r, 0, 255);
    this.g = Math.clamp(this.g, 0, 255);
    this.b = Math.clamp(this.b, 0, 255);
  }

  @Override
  public String toString() {
    this.clamp();
    int col = (this.r << 16) | (this.g << 8) | (this.b);
    return "#" + Integer.toHexString(col);
    // return "##" + Integer.toHexString(r) + Integer.toHexString(g) +
    // Integer.toHexString(b);
  }
}
