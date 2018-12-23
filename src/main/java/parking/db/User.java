package parking.db;

public class User {
  int UserID;
  String UserName;
  String FirstName;
  String LastName;
  String PhoneNum;
  String Password;
  
  public User(int UserID, String UserName, String FirstName, String LastName,String PhoneNum,String Password){
    this.UserID=UserID;
    this.UserName=UserName;
    this.FirstName=FirstName;
    this.LastName=LastName;
    this.PhoneNum=PhoneNum;
    this.Password=Password;
  }
  
  public int getUserID() {
    return UserID;    
  }
  
  public String getUserName() {
    return UserName;    
  }  
  
  
  public String getFirstName() {
    return FirstName;    
  }  
  
  
  public String getLastName() {
    return LastName;    
  }  
  
  
  public String getPhoneNum() {
    return PhoneNum;    
  }  
  
  public String getPassword() {
    return Password;    
  }  
  
  public void setFirstName(String newFirstName) {
    FirstName=newFirstName;    
  }  
  
  
  public void setLastName(String newLastName) {
    LastName=newLastName;    
  }  
  
  
  public void setPhoneNum(String newPhoneNum) {
    PhoneNum=newPhoneNum;    
  }  
  
  public void setPassword(String newPassword) {
    Password=newPassword;    
  }  
  
}
