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
    this.clamp();
  }

  /**
   * Clamp this Colour's rgb values to between 0 and 255.
   */
  private void clamp() {
    this.r = Math.max(0, Math.min(this.r, 255));
    this.g = Math.max(0, Math.min(this.g, 255));
    this.b = Math.max(0, Math.min(this.b, 255));
  }


  @Override
  public String toString() {
    int col = (this.r << 16) | (this.g << 8) | (this.b);
    String hex = Integer.toHexString(col);
    if (hex.length() < 6) {
      hex = ("0".repeat(6 - hex.length())) + hex;
    }
    return "#" + hex;
  }

  private static int scale_component(int component, double scalar) {
    return (int) Math.round(component * scalar);
  }

  /**
   * Multiply the rgb components of the colour by `scalar`.
   * 
   * @param scalar Multiplication factor. Probably between 0 and 1.
   * @return The product of this colour and `scalar`.
   */
  public Colour scale(double scalar) {
    return new Colour(
        scale_component(this.r, scalar),
        scale_component(this.g, scalar),
        scale_component(this.b, scalar));
  }

  /**
   * Add the rgb components of this colour to `other`.
   * 
   * @param other The other colour to add.
   * @return The sum of the two colours.
   */
  public Colour add(Colour other) {
    return new Colour(
        this.r + other.r,
        this.g + other.g,
        this.b + other.b);
  }
}
