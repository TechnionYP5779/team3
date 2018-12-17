package parking.db;

public class Rental {
  int id;
  int renterId;
  String startingTime;    //TODO: change to datetime object?
  String endingTime;
  public Rental(int id, int renterId, String startingTime, String endingTime) {
    super();
    this.id = id;
    this.renterId = renterId;
    this.startingTime = startingTime;
    this.endingTime = endingTime;
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
}
