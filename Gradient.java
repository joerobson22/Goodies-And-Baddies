public class Gradient {
  private final Colour start;
  private final Colour end;

  private final int steps;

  public Gradient(Colour start, Colour end) {
    this.start = start;
    this.end = end;
    this.steps = 0;
  }

  public Gradient(Colour start, Colour end, int steps) {
    this.start = start;
    this.end = end;
    this.steps = steps;
  }

  /**
   * Get the colour that is "`distance`" between the start and end.
   * 
   * @param distance Interpolation distance between 0 and 1. (Other numbers
   *                 will extrapolate, probably returning black or white.)
   * @return The colour at that distance.
   */
  public Colour interpolate(double distance) {
    return start.scale(distance).add(end.scale(1.0 - distance));
  }

  /**
   * Get the colour that is "`steps`" between the start and end.
   *
   * Internally this just does `interpolate(steps/this.steps)`.
   * 
   * @param steps The number of steps to step.
   * @return The colour at that number of stepped steps.
   */
  public Colour step(int steps) {
    System.out.println(steps / this.steps);
    return this.interpolate((double) steps / (double) this.steps);
  }
}
