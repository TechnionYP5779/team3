package fluent.ly;

public class angle{
  private double degree;

  public angle(double i) {
    this.degree = i; 
  }

  public static angle degree(int ¢) {
    return new angle(¢);
  }

  public static angle radians(int ¢) {
    return new angle((180 * ¢)/Math.PI);
  }

  public static angle pi() {
    return new angle((180 * Math.PI)/Math.PI);
  }

  public static angle halfPi() {
    return new angle((180 * Math.PI / 2)/Math.PI);
  }

  public angle add(angle ad) {
    return new angle(this.degree + ad.degree); 
  }

  public angle subtracted(angle ad) {
    return new angle(this.degree - ad.degree); 
  }
  
  public double degrees() {
    return this.degree;
  }

  public double radians() {
    return (Math.PI * this.degree)/180;
  }

  public static angle of(int ¢) {
    return new angle(¢); 
  }

  public angle add(int ¢) {
    return new angle(this.degree + ¢); 
  }

  public angle subtracted(int ¢) {
    return new angle(this.degree - ¢); 
  }

  public angle negated() {
      return new angle(-this.degree);
  } 
}
  
