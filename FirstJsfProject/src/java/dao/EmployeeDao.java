package dao;

import entity.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmployeeDao {

    public boolean saveEmployee(Employee e) {
        Transaction t = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            t = session.beginTransaction();
            session.saveOrUpdate(e);
            t.commit();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            t.rollback();

        } finally {
            session.close();
        }

        return false;

    }

    public boolean deleteEmployee(int empid) {

        Transaction t = null;
        Session s = HibernateUtil.getSessionFactory().openSession();

        try {
            t = s.beginTransaction();
            Employee e = (Employee) s.load(Employee.class, new Integer(empid));
            s.delete(e);
            t.commit();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            t.rollback();

        } finally {
            s.close();

        }
        return false;
    }
    
    public  List<Employee>  viewAll(){
        
        SessionFactory factory=HibernateUtil.getSessionFactory();
        Session s=factory.openSession();
        
        List<Employee> eList=s.createQuery("from Employee").list();
        
        eList.toString();
        
        return eList;  
    
    }
    
    
    
    public  void updateEmployee(Employee e){
    
        Transaction t = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            t = session.beginTransaction();
            session.update(e);
            t.commit();

            
        } catch (Exception ex) {
            ex.printStackTrace();
            t.rollback();

        } finally {
            session.close();
        }
    
    }
    
    
    public Employee getEmployeeById(int empid){
        
    	System.out.println("Get employee by Id = " +empid+ "\n.....................");
        Session session = null;
        Employee e = null;
        try {
        	
            session = HibernateUtil.getSessionFactory().openSession();
            e = (Employee) session.get(Employee.class, empid);
 
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
             session.close();
        }
        return e;
    }
    
    

}
