package parking.db;

public class Parking {
  int ParkID;
  String UserID;
  String address;
  double lat;
  double lon;
  String From;
  String To;
  int Price;
  boolean occupied;
  
  public boolean isOccupied() {
    return occupied;
  }

  public Parking(int ParkID, String UserID, String address, double lat, double lon,
          String From, String To, int Price, boolean occupied){
    this.UserID=UserID;
    this.ParkID=ParkID;
    this.address=address;
    this.lat=lat;
    this.lon=lon;
    this.From=From;
    this.To=To;
    this.Price=Price;
    this.occupied = occupied;
  }
  
  public void setOccupied(boolean occupied) {
    this.occupied = occupied;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public void setLat(double lat) {
    this.lat = lat;
  }


  public void setLon(double lon) {
    this.lon = lon;
  }

  public void setParkID(int parkID) {
    ParkID = parkID;
  }

  public void setUserID(String userID) {
    UserID = userID;
  }

  public String getUserID() {
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
