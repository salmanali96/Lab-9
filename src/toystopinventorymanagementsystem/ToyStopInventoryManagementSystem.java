package toystopinventorymanagementsystem;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.store;

/**
 *
 * @author Fahad Satti
 */
public class ToyStopInventoryManagementSystem {
    ToyStopService tsService = new ToyStopService();
    public void init() throws IOException, SQLException, ClassNotFoundException{
        
        tsService.initEmployees();
        tsService.initStores();
        tsService.initToys();
        
        
        System.out.println("Init complete");
    }
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        
        
        ToyStopInventoryManagementSystem tsims = new ToyStopInventoryManagementSystem();
        tsims.showAll();
        
        tsims.init();
        //load previous data
        //tsims.loadData();
        tsims.checkrunning();
        tsims.showMenu();
        //tsims.printAll();
        
    }

  

    private void showMenu() throws IOException, ClassNotFoundException {
       int x = 0;
        {
            System.out.println("Welcome to Toy Stop Inventory Management System");
            System.out.println("Enter 1 to show all data");
            System.out.println("Enter 2 to add a new Store");
            System.out.println("Enter 3 to add a new Employee");
            System.out.println("Enter 4 to add a new Toy");
            System.out.println("Enter 0 to save state");
            //System.out.println("Enter 5 to exit");
            Scanner input = new Scanner(System.in);
             x = input.nextInt();
            if (x == 1){
                //System.out.println("before: ");
                //printAll();
                
                load_data();
                printAll();
                
            }
            else if (x == 2){
                tsService.addStore();
               // tsService.checkemployee();
               // tsService.toyslist();
               // tsService.getstore(23);
                //tsService.getemployee(23);
                //tsService.removeemployee(23);
            }
            else if (x == 3){
                tsService.addEmployee();
            }
            else if (x == 4){
                tsService.addToy();
            }
            else if (x == 0){
               save_data();
            }
            
        }
    }

    private void printAll() {
        System.out.println(this.tsService.stores);
    }
    
    private void save_data() throws IOException{
         try{
            FileOutputStream fileOut =
            new FileOutputStream("myfile.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(tsService);
            out.close();
            fileOut.close();
        }catch(IOException i){
          i.printStackTrace();
      }
   }
    
    private void load_data() throws IOException, ClassNotFoundException{
        try(FileInputStream fileIn = new FileInputStream("myfile.ser"); ObjectInputStream in = new ObjectInputStream(fileIn)){
         
         tsService = (ToyStopService) in.readObject();
         }catch(IOException i){
         return;
      }catch(ClassNotFoundException c)
      {
         System.out.println("ToyStopService class not found");
         return;
      }
        
    }
    public void checkrunning() throws IOException, ClassNotFoundException, SQLException{
        load_data();
        
        for (int i = 0 ; i< 60 ; i++){
            
            Random rand = new Random();

            int  x = rand.nextInt(8) + 1;
            
           if (x == 1){
                //System.out.println("before: ");
                //printAll();
                
                tsService.addStore();
            }
            else if (x == 2){
                
                tsService.checkemployee();
               // tsService.toyslist();
               // 
                //
                //
            }
            else if (x == 3){
                tsService.addEmployee();
            }
            else if (x == 4){
                tsService.addToy();
            }
            else if (x == 5){
               tsService.toyslist();
            }
           else if (x == 6){
               int  a = rand.nextInt(50) + 1;
               tsService.getstore(a);
            }
           else if (x == 7){
               int  a = rand.nextInt(50) + 1;
               tsService.getemployee(a);
            }
           else if (x == 8){
               int  a = rand.nextInt(50) + 1;
               tsService.removeemployee(a);
            }
            
          //  save_data();
        }
    }
    
    
    public void showAll() throws ClassNotFoundException, SQLException{
        
        Connection conn = null;
        
        
        Connection myConn = null;
       PreparedStatement prep_statement = null;
        Class.forName("com.mysql.jdbc.Driver");
        
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab" , "root" , "root");
        
        
        
        java.sql.Statement stmt =  conn.createStatement();
        String sql = "Select * from store";
        ResultSet rs =stmt.executeQuery(sql);
        
        while (rs.next()){
            
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(2));
            
            
        }
        
        
       
       conn.close();

    }
}

