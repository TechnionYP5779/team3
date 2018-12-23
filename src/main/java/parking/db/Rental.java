package parking.db;

public class Rental {
  int id;
  int renterId;
  int parkingId;
  String startingTime;    //TODO: change to datetime object?
  String endingTime;
  String carModel;
  double price;
  String address;
  
  public Rental(int id, int parkingId, int renterId, String startingTime, String endingTime, String carModel) {
    this.id = id;
    this.parkingId = parkingId;
    this.renterId = renterId;
    this.startingTime = startingTime;
    this.endingTime = endingTime;
    this.carModel = carModel;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public int getParkingId() {
    return renterId;
  }
  public int getRenterId() {
    return renterId;
  }
  public void setRenterId(int renterId) {
    this.renterId = renterId;
  }
  public String getStartingTime() {
    return startingTime;
  }
  public void setStartingTime(String startingTime) {
    this.startingTime = startingTime;
  }
  public String getEndingTime() {
    return endingTime;
  }
  public void setEndingTime(String endingTime) {
    this.endingTime = endingTime;
  }
  public int getId() {
    return id;
  }
    public String getCarModel() {
    return carModel;
  }

}
