package il.org.spartan.etc;

public class angle {
  private final double degree;

  public angle(final double i) {
    this.degree = i;
  }

  public static angle degree(final int ¢) {
    return new angle(¢);
  }

  public static angle radians(final int ¢) {
    return new angle(180 * ¢ / Math.PI);
  }

  public static angle pi() {
    return new angle(180 * Math.PI / Math.PI);
  }

  public static angle halfPi() {
    return new angle(180 * Math.PI / 2 / Math.PI);
  }

  public angle add(final angle ad) {
    return new angle(this.degree + ad.degree);
  }

  public angle subtracted(final angle ad) {
    return new angle(this.degree - ad.degree);
  }

  public double degrees() {
    return this.degree;
  }

  public double radians() {
    return Math.PI * this.degree / 180;
  }

  public static angle of(final int ¢) {
    return new angle(¢);
  }

  public angle add(final int ¢) {
    return new angle(this.degree + ¢);
  }

  public angle subtracted(final int ¢) {
    return new angle(this.degree - ¢);
  }

  public angle negated() {
    return new angle(-this.degree);
  }
}
