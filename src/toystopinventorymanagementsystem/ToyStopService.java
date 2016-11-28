
package toystopinventorymanagementsystem;

import java.io.Serializable;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Fahad Satti
 */
public class ToyStopService implements Serializable {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Store> stores = new ArrayList<>();
    JDBC1 J1 = new JDBC1();
    public void initEmployees() throws SQLException, ClassNotFoundException{
        //Create a List of first 200 Employees
        for(int i=0; i<20; i++){
            Employee myEmployee = new Employee();
            myEmployee.setUID(i);
            int uid = myEmployee.getUID();
            
            myEmployee.setRandomName();
            String name = myEmployee.getName();
            
            myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
            Email email = myEmployee.getEmail();
            
            int Storeid = 0;
            
            insertdata(name,uid,email,Storeid);
            employees.add(myEmployee);
        }
    }
    
    public void initStores() throws ClassNotFoundException, SQLException{
        //Create a List of Stores in a region
        for(int i=0; i<10; i++){
            Store myStore = new Store();
            myStore.setUID(Util.getSaltNum(-1));
            myStore.addRandomEmployees(employees);
            stores.add(myStore);
            myStore.setAddress(Util.getSaltAlphaNumString());
            myStore.setContactNo("+92"+Util.getSaltNum(9));
            Email storeEmail = new Email();
            storeEmail.setEmailAddress(myStore.getUID()+"@toystop.org");
            myStore.setEmail(storeEmail);
            
            int sid = myStore.getUID();
            String address = myStore.getAddress();
            String contact = myStore.getContactNo();
            
            J1.insertStore(sid, address, contact);
            
            
        }
        
    }
    
    public void initToys() throws ClassNotFoundException, SQLException{
        //Add Toys in random stores
        for(int i=0; i<20; i++){
            Toy newToy = new Toy();
            newToy.setUID(Util.getSaltNum(-1));
            newToy.setMinAge(Util.getSaltNum(1));
            newToy.setMaxAge(Util.getSaltNum(18));
            newToy.setPrice(Util.getSaltNum(1000));
            newToy.setName(Util.getSaltAlphaString());
            newToy.setAddedOn(LocalDateTime.now());
            
            int uid = newToy.getUID();
            int min = newToy.getMinAge();
            int max = newToy.getMaxAge();
            int price = newToy.getPrice();
            String name = newToy.getName();
           // String addedon = newToy.getAddedOn()
            
            J1.insertToy(uid, name, price, min, max);
            Random randStore = new Random();
            int index = randStore.nextInt(stores.size());
            Store selectedStore = (Store)stores.get(index);
            selectedStore.addToy(newToy);
            selectedStore.addtoData(selectedStore, uid);
                        
            
        }
    }
    //Only creates a new employee and returns the UID
    public int addEmployee(){
            Employee myEmployee = new Employee();
            
            myEmployee.setRandomName();
            myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
            myEmployee.setUID(employees.size()+1);
            employees.add(myEmployee);
            return myEmployee.getUID();
    }
    
    //Creates a new store
    public int addStore(){
            Store myStore = new Store();
            myStore.setUID(Util.getSaltNum(-1));
            //This will assign any new employees or the ones remaining after previous store insertions.
            myStore.addRandomEmployees(employees);
            
            myStore.setAddress(Util.getSaltAlphaNumString());
            myStore.setContactNo("+92"+Util.getSaltNum(9));
            Email storeEmail = new Email();
            storeEmail.setEmailAddress(myStore.getUID()+"@toystop.org");
            myStore.setEmail(storeEmail);
            stores.add(myStore);
            return myStore.getUID();
    }

    void addToy() {
        Toy newToy = new Toy();
            newToy.setUID(Util.getSaltNum(-1));
            newToy.setMinAge(Util.getSaltNum(1));
            newToy.setMaxAge(Util.getSaltNum(18));
            newToy.setPrice(Util.getSaltNum(1000));
            newToy.setName(Util.getSaltAlphaString());
            newToy.setAddedOn(LocalDateTime.now());
            
            Random randStore = new Random();
            int index = randStore.nextInt(stores.size());
            Store selectedStore = (Store)stores.get(index);
            selectedStore.addToy(newToy);
    }
    
    //function to check and insert if the employees in a particular store are less than 30
    public void checkemployee() throws SQLException, ClassNotFoundException{
        
           for (int i=0 ; i<stores.size() ;i++){
                 
              int size = stores.get(i).employees.size();
               
               while (stores.get(i).employees.size() < 200){
                 
                        
                    stores.get(i).insertEmployee(stores.get(i).UID);
                      
               }

               
               
           }
           
    
    }
    
    //function to get the list of toys in the store
    public void toyslist(){
        
        for (int i =0;i<stores.size();i++){
            
            String address= stores.get(i).getAddress();
            int size = stores.get(i).gettoyslist();
            
            System.out.println("Store Address: " + address + " Number of Toys: " + size);
        }
            
    }
    
    //function to get the information about the store
    public void getstore(int UID ){
        for (int i = 0 ; i<stores.size();i++){
            
            if (stores.get(i).UID ==  UID){
                 String address = stores.get(i).address;
                 String contact = stores.get(i).contactNo;
                 
                         
                 System.out.println("Store Address: "+ address  + " Contact: " + contact);
            }
        }
        
    }
    
    
    //function to get employee ID requested by the manager
    public void getemployee(int UID){
        for (int i =0 ; i <employees.size() ;i++){
            
            if (employees.get(i).getUID() == UID){
                
                String name = employees.get(i).getName();
                Email mail = employees.get(i).getEmail();
                
                System.out.println("Name:" + name + " Email: " + mail);
                break;
            }
        }
    }
    
    
    
    //function to remove employee
    public void removeemployee(int ID){
        for (int i =0 ; i<employees.size() ; i++){
            
            if (employees.get(i).getUID()== ID){
                
                employees.remove(i);
                
                break;
            }
        }
        
    }
    
    public void insertdata(String ename,int uid,Email email,int sid) throws SQLException, ClassNotFoundException{
      
       J1.insertEmployee(ename,uid,email,sid);
    } 
    
    
}
