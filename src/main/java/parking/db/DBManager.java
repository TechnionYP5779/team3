package parking.db;

import java.sql.*;

public class DBManager {
  
  private Connection connect() {
    Connection conn;
    try {
        String url = "jdbc:sqlite:main.db";
        conn = DriverManager.getConnection(url);
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return null;
    }
    
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
  
  public Parking getParking(int pid){
    String sql = "SELECT * FROM parkingSpaces WHERE id = ?";
    
    try (Connection conn = this.connect();
        PreparedStatement pstmt  = conn.prepareStatement(sql)){
        
        pstmt.setInt(1, pid);
      
        try(ResultSet rs  = pstmt.executeQuery()) {
          if(!rs.next())
            return null;    //user not found
          
          assert !rs.isLast();
          
          Parking u = new Parking(pid, rs.getInt("ownerUid"), rs.getString("city"), rs.getString("street"), rs.getString("buildingNum"), rs.getString("startingTime"), rs.getString("endingTime"), rs.getInt("price"));
          
          return u;
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
