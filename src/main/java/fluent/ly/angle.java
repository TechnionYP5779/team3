package fluent.ly;

public class angle{
  private double degree;

  public angle(double i) {
    this.degree = i; 
  }

  public static angle degree(int i) {
    return new angle(i);
  }

  public static angle radians(int i) {
    return new angle((i*180)/Math.PI);
  }

  public static angle pi() {
    return new angle((Math.PI*180)/Math.PI);
  }

  public static angle halfPi() {
    return new angle(((Math.PI/2)*180)/Math.PI);
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
    return (this.degree*Math.PI)/180;
  }

  public static angle of(int i) {
    return new angle(i); 
  }

  public angle add(int i) {
    return new angle(this.degree + i); 
  }

  public angle subtracted(int i) {
    return new angle(this.degree - i); 
  }

  public angle negated() {
      return new angle(this.degree*(-1));
  } 
}
  
