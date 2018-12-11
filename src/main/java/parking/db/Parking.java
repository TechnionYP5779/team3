package parking.db;

public class Parking {
  int ParkID;
  int UserID;
  String City;
  String Street;
  String BuildingNum;
  int From;
  int To;
  int Price;
  
  Parking(int ParkID, int UserID, String City, String Street, String BuildingNum,
          int From,int To, int Price){
    this.UserID=UserID;
    this.ParkID=ParkID;
    this.City=City;
    this.Street=Street;
    this.BuildingNum=BuildingNum;
    this.From=From;
    this.To=To;
    this.Price=Price;
  }
  
  public int getUserID() {
    return UserID;    
  }
  
  public int getParkID() {
    return ParkID;    
  }
  
  public String getCity() {
    return City;    
  }  
  
  public String getStreet() {
    return Street;    
  }  
  
  public String getBuildingNum() {
    return BuildingNum;    
  } 
  
  public int getFrom() {
    return From;    
  }
  
  public int getTo() {
    return To;    
  }
  
  public int getPrice() {
    return Price;    
  }
  
  public void setCity(String newCity) {
    City=newCity;    
  }  
  
  
  public void setStreet(String newStreet) {
    Street=newStreet;    
  }  
  
  public void setBuildingNum(String newBuildingNum) {
    Street=newBuildingNum;    
  }  
  
  public void setFrom(int newFrom) {
    From=newFrom;    
  }  
  
  public void setTo(int newTo) {
    To=newTo;    
  }  
  
  public void setPrice(int newPrice) {
    Price=newPrice;    
  }  
  
  
}
