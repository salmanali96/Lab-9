
package toystopinventorymanagementsystem;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fahad Satti
 */
public class Store implements Serializable{
    public int UID;
    public String address;
    public String contactNo;
    public Email email;
    public ArrayList<Toy> toys = new ArrayList();
    public ArrayList<Employee> employees = new ArrayList();

    

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public void setToys(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    
    public void insertEmployee(int storeid) throws SQLException, ClassNotFoundException{
        Employee myEmployee = new Employee();
        JDBC1 J1 = new JDBC1();
                      myEmployee.setRandomName();
                      myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
                      myEmployee.setUID(employees.size()+1);
                      myEmployee.setStoreID(storeid);
                      
                                int uid = myEmployee.getUID();
                                String name = myEmployee.getName();
                                int StoreID = myEmployee.getStoreID();
                                Email email = myEmployee.getEmail();
                                
                                J1.insertEmployee(name, uid, email, StoreID);
                                

        this.employees.add(myEmployee);
    
    }
    public int gettoyslist(){
        
        return toys.size();
    }
    
    
    
    public void addRandomEmployees(ArrayList<Employee> employeeList){
        Random randEmployee = new Random();
        int index = randEmployee.nextInt(employeeList.size());
        Employee selectedEmployee = (Employee)employeeList.get(index);
        selectedEmployee.setStoreID(this.getUID());
        this.employees.add(selectedEmployee);
        
        employeeList.remove(index);
    }

    @Override
    public String toString() {
        return "Store{" + "UID=" + UID + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", toys=" + toys + ", employees=" + employees + "}\n";
    }

    void addToy(Toy newToy) {
        if(newToy != null)
        this.toys.add(newToy);
    }
    
    void addtoData(Store store,int tid) throws ClassNotFoundException, SQLException{
        
        //Connection conn = null;
        
        
        //Connection myConn = null;
        //PreparedStatement prep_statement = null;
       // Class.forName("com.mysql.jdbc.Driver");
        
       // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab" , "root" , "root");
        
      //  int sid = store.getUID();
        
     //   java.sql.Statement stmt =  conn.createStatement();
     //   String sql = "update store set tid=" + tid +"where UID=" + tid;
    //    stmt.executeUpdate(sql);
       
     //   conn.close();
    }
    
}
