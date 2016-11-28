/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toystopinventorymanagementsystem;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Salman
 */
public class JDBC1 {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";
   
   static final String USER = "root";
   static final String PASS = "root";
   
   
   public void insertEmployee(String ename,int uid,Email email,int sid) throws SQLException, ClassNotFoundException{
   
        
         Connection myConn = null;
         PreparedStatement prep_statement = null;
        Class.forName("com.mysql.jdbc.Driver");
         myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab" , "root" , "root");
      
        

        
        String sql = "Insert into employee(ename,uid,sid) values(?,?,?)";
        prep_statement = myConn.prepareStatement(sql);
       
       
            prep_statement.setString(1,ename);  // This would set age
            prep_statement.setInt(2, uid); // This would set FN
            //prep_statement.setString(3, email); // This would set LN
            prep_statement.setInt(3, sid); 
            
            int rows = prep_statement.executeUpdate();



          myConn.close(); 
        
   
   
   
   }
   
   public void insertStore(int sid,String address,String contact) throws ClassNotFoundException, SQLException{
   
       
        Connection myConn = null;
        PreparedStatement prep_statement = null;
        Class.forName("com.mysql.jdbc.Driver");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab" , "root" , "root");
        
        String sql = "Insert into store(sid,address,contact) values(?,?,?)";
        prep_statement = myConn.prepareStatement(sql); 
        
         prep_statement.setInt(1,sid);  // This would set age
         prep_statement.setString(2, address); // This would set FN
            //prep_statement.setString(3, email); // This would set LN
         prep_statement.setString(3, contact); 
       
         int rows = prep_statement.executeUpdate();
   
        myConn.close();   
   }
   
   
   public void insertToy(int tid,String tname,int price,int minage,int maxage)throws ClassNotFoundException, SQLException{
       
       Connection myConn = null;
        PreparedStatement prep_statement = null;
        Class.forName("com.mysql.jdbc.Driver");
       
       myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab" , "root" , "root");
       
       String sql = "Insert into toy(tid,tname,price,minage,maxage) values(?,?,?,?,?)";
       prep_statement = myConn.prepareStatement(sql);
       
       
        prep_statement.setInt(1,tid);  // This would set age
        prep_statement.setString(2, tname); // This would set FN
            //prep_statement.setString(3, email); // This would set LN
        prep_statement.setInt(3,price);
        prep_statement.setInt(4,minage);
        prep_statement.setInt(5,maxage);
        
        //prep_statement.setString(6, addedon); 
       int rows = prep_statement.executeUpdate();
        myConn.close(); 
   } 
    
}
