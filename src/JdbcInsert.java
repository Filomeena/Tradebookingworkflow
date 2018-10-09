//STEP 1. Import required packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class JdbcInsert {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

   //  Database credentials
   static final String USER = "system";
   static final String PASS = "hr";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      
      
      int res =0;
      String csvFile = "E:\\scb\\Trade.csv";
      BufferedReader br = null;
      String line = "";
      String cvsSplitBy = ",";

     

          br = new BufferedReader(new FileReader(csvFile));
          while ((line = br.readLine()) != null) {

              // use comma as separator
              String[] values = line.split(cvsSplitBy);
              
             
              //stmt = conn.createStatement();
             
            	  PreparedStatement ps=conn.prepareStatement("insert into login2 values(?,?,?)");
            	  ps.setString(1,values[1]);
            	  ps.setString(2,values[2]);
            	  ps.setString(3,"cust_user");
            	  ps.execute();
            	  ps.close();
            	  
            	  PreparedStatement ps1=conn.prepareStatement("insert into login2 values(?,?,?)");
            	  ps1.setString(1,values[5]);
            	  ps1.setString(2, values[6]);
            	  ps1.setString(3,"trade_user");
            	  ps1.execute();
            	  ps1.close();
              
     //String sql = "INSERT INTO LOGIN2(USERNAME,PASSWORD,ROLE) VALUES(un,pw,'user')";
            	  //String sql = "INSERT INTO login2 VALUES ('Zara', 'Ali','admin')";
     // stmt.executeUpdate(sql);
     // sql="INSERT INTO login2 VALUES ("+values[5]+","+values[6]+",'user')";
      //stmt.executeUpdate(sql);
      
          }
      
          Statement s=conn.createStatement();
  		String query="insert into login2 values('Ayushi','Tiwari','admin')";
  		s.executeUpdate(query);
  		 query="insert into login2 values('Bhavin','Mehta','admin')";
   		s.executeUpdate(query);
   	 query="insert into login2 values('Filo','Meena','admin')";
		s.executeUpdate(query);
		 query="insert into login2 values('Manoj','Varma','admin')";
	  		s.executeUpdate(query);
	  		 query="insert into login2 values('Monisha','Krishnan','admin')";
	   		s.executeUpdate(query);
	   	 query="insert into login2 values('Pradeep','Reddy','admin')";
	  		s.executeUpdate(query);
	  		 query="insert into login2 values('Sumaiya','sidhika','admin')";
	   		s.executeUpdate(query);
	   	 query="insert into login2 values('Vineth','Kumar','admin')";
	  		s.executeUpdate(query);
      br.close();
   }
   catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample