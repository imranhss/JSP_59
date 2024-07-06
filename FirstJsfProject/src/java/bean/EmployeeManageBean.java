/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmployeeDao;
import entity.Employee;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class EmployeeManageBean {

    private Employee employee = new Employee();

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String saveEmployee() {
        
        EmployeeDao dao = new EmployeeDao();
        boolean status = dao.saveEmployee(employee);

        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
            return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Data Not Saved", ""));
        }
        return null;
    }
    
    
    public List<Employee> showAllEmployee() {
        EmployeeDao dao = new EmployeeDao();
        List<Employee> eList = dao.viewAll();
        return eList;
    }

    public void delete(int empid) {
      EmployeeDao dao = new EmployeeDao();
        boolean status = dao.deleteEmployee(empid);

        if (status) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Delete successful!", null));
            try {
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                externalContext.redirect("/");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Delete failed!", null));
        }

    }
    
    public String editEmployee(int empid) {
        EmployeeDao dao = new EmployeeDao();
        employee= dao.getEmployeeById(empid);

        if (employee != null) {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("employee", employee);
            return "editmployee.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee not found", ""));
            return null;
        }
    }

}
