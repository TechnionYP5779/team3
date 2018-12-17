package parking.db;

import java.sql.*;
import java.util.*;

public class DBManager {
  
  private Connection connect() throws SQLException {
    Connection conn;
    
    String url = "jdbc:sqlite:C:main.db";
    conn = DriverManager.getConnection(url);
    
    return conn;
  }
  
  public User getUser(int uid){
      //TODO: function to get by username?
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
  
  public static void main(String[] args) {
    DBManager app = new DBManager();
    System.out.println(app.getUser(1));
  }
}
