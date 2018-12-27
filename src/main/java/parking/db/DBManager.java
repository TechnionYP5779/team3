package parking.db;

import java.sql.*;
import java.util.*;

public class DBManager {
  
  private Connection connect() throws SQLException {
    Connection conn;
    
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String url = "jdbc:sqlite:C:\\Users\\user\\workspace\\team3\\main.db";
    conn = DriverManager.getConnection(url);
    
    return conn;
  }
  
  public void addUser(User u)
  {
    String sql = "INSERT INTO users(username,password,firstName,lastName,phone) VALUES(?,?,?,?,?)";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setString(1, u.getUserName());
        pstmt.setString(2, u.getPassword());
        pstmt.setString(3, u.getFirstName());
        pstmt.setString(4, u.getLastName());
        pstmt.setString(5, u.getPhoneNum());
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }
  
  
  public Parking getParkingById(int id){
    String sql = "SELECT * FROM parkingSpaces WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, id);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          if(!rs.next())
            return null;    //user not found
          
          assert !rs.isLast();
          boolean occupied = rs.getInt("occupied") == 0 ? false : true;
          Parking u = new Parking(id,  rs.getInt("ownerUid"), rs.getString("address"), rs.getDouble("lat"), rs.getDouble("lon"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getInt("price"), occupied);
          
          return u;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public List<Rental> getRentalsByParkingId(int pid){
    String sql = "SELECT * FROM rentals WHERE parkingId = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, pid);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          List<Rental> lst = new ArrayList<>();
          
          while(rs.next())
          {
            Rental r = new Rental(rs.getInt("id"), pid, rs.getInt("renterId"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getString("carModel"));
            lst.add(r);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public User getUserById(int uid){
      String sql = "SELECT * FROM users WHERE id = ?";
      
      try (Connection conn = this.connect();
          PreparedStatement pstmt  = conn.prepareStatement(sql)){
          
          pstmt.setInt(1, uid);
        
          try(ResultSet rs  = pstmt.executeQuery()) {
            if(!rs.next())
              return null;    //user not found
            
            assert !rs.isLast();
            
            User u = new User(uid, rs.getString("username"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getString("password"));
            
            return u;
          }
          
          
      } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return null;
      }
  }
  
  public User getUserByUsername(String username){
    String sql = "SELECT * FROM users WHERE username = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setString(1, username);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          if(!rs.next())
            return null;    //user not found
          
          assert !rs.isLast();
          
          User u = new User(rs.getInt("id"), username, rs.getString("firstName"), rs.getString("lastName"), rs.getString("phone"), rs.getString("password"));
          System.out.println(" AAAAAAAAAAAAAAAAAAAAAAAA " + rs.getString("password"));
          
          return u;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public List<Parking> getParking(int ownerId){
    String sql = "SELECT * FROM parkingSpaces WHERE ownerUid = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, ownerId);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          List<Parking> lst = new ArrayList<>();
          
          while(rs.next())
          {
            boolean occupied = rs.getInt("occupied") == 0 ? false : true;
            Parking p = new Parking(rs.getInt("id"), ownerId, rs.getString("address"), rs.getDouble("lat"), rs.getDouble("lon"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getInt("price"), occupied);
            lst.add(p);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public List<Parking> getAllParking(){
    String sql = "SELECT * FROM parkingSpaces";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          List<Parking> lst = new ArrayList<>();
          
          while(rs.next())
          {
            boolean occupied = rs.getInt("occupied") == 0 ? false : true;
            Parking p = new Parking(rs.getInt("id"), rs.getInt("ownerUid"), rs.getString("address"), rs.getDouble("lat"), rs.getDouble("lon"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getInt("price"), occupied);
            lst.add(p);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public List<Rental> getRentalsByRenter(int renterId){
    String sql = "SELECT * FROM rentals WHERE renterId = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, renterId);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          List<Rental> lst = new ArrayList<>();
          
          while(rs.next())
          {
            Rental p = new Rental(rs.getInt("id"), rs.getInt("parkingId"), renterId, rs.getString("startingTime"), rs.getString("endingTime"), rs.getString("carModel"));
            lst.add(p);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public List<Rental> getRentalsByParking(int parkingId){
    String sql = "SELECT * FROM rentals WHERE parkingId = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, parkingId);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          List<Rental> lst = new ArrayList<>();
          
          while(rs.next())
          {
            Rental p = new Rental(rs.getInt("id"), parkingId, rs.getInt("renterId"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getString("carModel"));
            lst.add(p);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  
  public void changeParkingOccupied(Parking p)
  {
    String sql = "UPDATE parkingSpaces SET occupied = ? WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setInt(1, p.getParkID());
        pstmt.setInt(2, p.isOccupied() ? 1 : 0);
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }
  
  public void changeParkFrom(Parking p,String from)
  {
    String sql = "UPDATE parkingSpaces SET startingTime = ? WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setString(1, from);
        pstmt.setInt(2, p.getParkID());
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }
  
  
  public void changeParkTo(Parking p,String to)
  {
    String sql = "UPDATE parkingSpaces SET startingTime = ? WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setString(1, to);
        pstmt.setInt(2, p.getParkID());
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }
  
  
  public void removeParking(Parking p)
  {
    String sql = "DELETE FROM parkingSpaces WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setInt(1, p.getParkID());
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }  

  public void addParking(Parking p)
  {
    String sql = "INSERT INTO parkingSpaces(ownerUid,address,lat,lon,startingTime,endingTime,price, occupied) VALUES(?,?,?,?,?,?,?,?)";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setInt(1, p.getUserID());
        pstmt.setString(2, p.getAddress());
        pstmt.setDouble(3, p.getLat());
        pstmt.setDouble(4, p.getLon());
        pstmt.setString(5, p.getFrom());
        pstmt.setString(6, p.getTo());
        pstmt.setInt(7, p.getPrice());
        pstmt.setInt(8, p.isOccupied() ? 1 : 0);
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }  
  
  public void addRental(Rental r)
  {
    String sql = "INSERT INTO rentals(parkingId,renterId,startingTime,endingTime,carModel) VALUES(?,?,?,?,?)";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        pstmt.setInt(1, r.getParkingId());
        pstmt.setInt(2, r.getRenterId());
        pstmt.setString(3, r.getStartingTime());
        pstmt.setString(4, r.getEndingTime());
        pstmt.setString(5, r.getCarModel());
        pstmt.executeUpdate();
    } catch (SQLException e) {
          System.out.println(e.getMessage());
          
          return;
    }
  }  
  
  public static void main(String[] args) {
    DBManager app = new DBManager();
    System.out.println(app.getUserById(1));
    System.out.println(app.getParking(1).toString());
  }
}
