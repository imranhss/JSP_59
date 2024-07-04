/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import dao.PersonDAO;
import entity.Person;
import jakarta.annotation.ManagedBean;
import java.util.List;

/**
 *
 * @author user
 */

@ManagedBean
public class PersonBean {
    
    private PersonDAO personDAO;
    
    private Person person = new Person();

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void create() {
        personDAO.create(person);
        person = new Person(); // Reset form
    }

    public List<Person> getPersons() {
        return personDAO.findAll();
    }

    public void update(Person person) {
        personDAO.update(person);
    }

    public void delete(Long id) {
        personDAO.delete(id);
    }
    
    
}
