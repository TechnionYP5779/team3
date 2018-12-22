package parking.db;

public class Parking {
  int ParkID;
  int UserID;
  String address;
  double lat;
  double lon;
  String From;
  String To;
  int Price;
  
  Parking(int ParkID, int UserID, String address, double lat, double lon,
          String From, String To, int Price){
    this.UserID=UserID;
    this.ParkID=ParkID;
    this.address=address;
    this.lat=lat;
    this.lon=lon;
    this.From=From;
    this.To=To;
    this.Price=Price;
  }
  
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }

  public void setParkID(int parkID) {
    ParkID = parkID;
  }

  public void setUserID(int userID) {
    UserID = userID;
  }

  public int getUserID() {
    return UserID;    
  }
  
  public int getParkID() {
    return ParkID;    
  }
  
  public String getAddress() {
    return address;    
  }
  
  public double getLat() {
    return lat;    
  }
  
  public double getLon() {
    return lon;    
  }
  
  public String getFrom() {
    return From;    
  }
  
  public String getTo() {
    return To;    
  }
  
  public int getPrice() {
    return Price;    
  }
  

  public void setFrom(String newFrom) {
    From=newFrom;    
  }  
  
  public void setTo(String newTo) {
    To=newTo;    
  }  
  
  public void setPrice(int newPrice) {
    Price=newPrice;    
  }  
  
  
}
