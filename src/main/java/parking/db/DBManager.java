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
    String url = "jdbc:sqlite:/home/eric/Documents/team3/main.db";
    conn = DriverManager.getConnection(url);
    
    return conn;
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
            Parking p = new Parking(rs.getInt("id"), ownerId, rs.getString("address"), rs.getDouble("lat"), rs.getDouble("lon"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getInt("price"));
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
            Rental p = new Rental(rs.getInt("id"), rs.getInt("parkingId"), renterId, rs.getString("startingTime"), rs.getString("endTime"), rs.getString("carModel"));
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
            Rental p = new Rental(rs.getInt("id"), parkingId, rs.getInt("renterId"), rs.getString("startingTime"), rs.getString("endTime"), rs.getString("carModel"));
            lst.add(p);
          }
          
          return lst;
        }
        
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        
        return null;
    }
}
  
  public static void main(String[] args) {
    DBManager app = new DBManager();
    System.out.println(app.getUserById(1));
    System.out.println(app.getParking(1).toString());
  }
}
