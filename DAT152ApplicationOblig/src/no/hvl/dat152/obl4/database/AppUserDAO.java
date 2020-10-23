package no.hvl.dat152.obl4.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class AppUserDAO {

  public AppUser getAuthenticatedUser(String username, String password) {

    String hashedPassword = generatePassHash(password);
    
    
    // unsafe
    String sql = "SELECT * FROM SecOblig.AppUser" 
        + " WHERE username = '" + username + "'"
        + " AND passhash = '" + hashedPassword + "'";
    
    // safe
    String safeSql = "Select * FROM SecOblig.AppUser"
    		+ " WHERE username = ?"
    		+ " AND passhash = ?";
    
   
    
    
    AppUser user = null;

    Connection c = null;
    Statement s = null;
    ResultSet r = null;
    PreparedStatement ps = null;

    try {        
      c = DatabaseHelper.getConnection();
      
      
      // storing sql query "safeSql" in a prepared statement
      ps = c.prepareStatement(safeSql);
      ps.setString(1, username);
      ps.setString(2, hashedPassword);
      s = c.createStatement(); 
      
      // storing the outcome in a ResultSet
      r = ps.executeQuery();
      
    //  previous code (not safe)
    //r = s.executeQuery(sql);

      if (r.next()) {
        user = new AppUser(
            r.getString("username"),
            r.getString("passhash"),
            r.getString("firstname"),
            r.getString("lastname"),
            r.getString("mobilephone"),
            r.getString("role")
            );
      }

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      DatabaseHelper.closeConnection(r, s, c);
    }

    return user;
  }

  public boolean saveUser(AppUser user) {

    String sql = "INSERT INTO SecOblig.AppUser VALUES (" 
        + "'" + user.getUsername()  + "', "
        + "'" + user.getPasshash()  + "', "
        + "'" + user.getFirstname() + "', "
        + "'" + user.getLastname()  + "', "
        + "'" + user.getMobilephone()  + "', "
        + "'" + user.getRole() + "')";
    
    //String safeSql = "INSERT INTO SecOblig.AppUser VALUES (" 
//            + "?,"
//            + "?," 
//            + "?," 
//            + "?,"
//            + "?," 
//            + "?)";

    Connection c = null;
    Statement s = null;
    ResultSet r = null;
    //PreparedStatement ps = null;

    try {        
      c = DatabaseHelper.getConnection();
      s = c.createStatement();   
      //ps = c.prepareStatement(safeSql);
      int row = s.executeUpdate(sql);
      //int row = ps.executeUpdate();
      if(row >= 0)
    	  return true;
    } catch (Exception e) {
    	System.out.println(e);
    	return false;
    } finally {
      DatabaseHelper.closeConnection(r, s, c);
    }
    
    return false;
  }
  
  public List<String> getUsernames() {
	  
	  List<String> usernames = new ArrayList<String>();
	  
	  String sql = "SELECT username FROM SecOblig.AppUser";
	  //String safeSql = "SELECT ? FROM SecOblig.AppUser";

		    Connection c = null;
		    Statement s = null;
		    ResultSet r = null;
		    //PreparedStatement ps = null;

		    try {        
		      c = DatabaseHelper.getConnection();
		      s = c.createStatement();   
		      //ps = c.prepareStatement(safeSql);
		      r = s.executeQuery(sql);
		      //r = ps.executeQuery();

		      while (r.next()) {
		    	  usernames.add(r.getString("username"));
		      }

		    } catch (Exception e) {
		      System.out.println(e);
		    } finally {
		      DatabaseHelper.closeConnection(r, s, c);
		    }
	  
	  return usernames;
  }
  
  public boolean updateUserPassword(String username, String passwordnew) {
	  
	  String hashedPassword = generatePassHash(passwordnew);
	  
	    String sql = "UPDATE SecOblig.AppUser "
	    		+ "SET passhash = '" + hashedPassword + "' "
	    				+ "WHERE username = '" + username + "'";
//	    String safeSql = "UPDATE SecOblig.AppUser "
//	    		+ "SET passhash = ?"
//				+ "WHERE username = ?";
	
	    Connection c = null;
	    Statement s = null;
	    ResultSet r = null;
	    //PreparedStatement ps = null;
	
	    try {        
	      c = DatabaseHelper.getConnection();
	      //ps = c.prepareStatement(safeSql);
	      s = c.createStatement();
	     
	      int row = s.executeUpdate(sql);
	      //int row = ps.executeUpdate();
	      System.out.println("Password update successful for "+username);
	      if(row >= 0)
	    	  return true;
	      
	    } catch (Exception e) {
	      System.out.println(e);
	      return false;
	    } finally {
	      DatabaseHelper.closeConnection(r, s, c);
	    }
	    
	    return false;
  }
  
  public boolean updateUserRole(String username, String role) {

	    String sql = "UPDATE SecOblig.AppUser "
	    		+ "SET role = '" + role + "' "
	    				+ "WHERE username = '" + username + "'";
	
	    Connection c = null;
	    Statement s = null;
	    ResultSet r = null;
	
	    try {        
	      c = DatabaseHelper.getConnection();
	      s = c.createStatement();       
	      int row = s.executeUpdate(sql);
	      System.out.println("Role update successful for "+username+" New role = "+role);
	      if(row >= 0)
	    	  return true;
	      
	    } catch (Exception e) {
	      System.out.println(e);
	      return false;
	    } finally {
	      DatabaseHelper.closeConnection(r, s, c);
	    }
	    return false;
  }
  
  public String generatePassHash(String password) {
    return DigestUtils.md5Hex(password);
  }

}

