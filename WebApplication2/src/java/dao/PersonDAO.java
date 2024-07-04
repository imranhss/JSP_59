/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author user
 */
public class PersonDAO {
    
    @PersistenceContext
    private EntityManager em;    
    
    
    
    
    public void create(Person person) {
        em.persist(person);
    }

    public Person read(Long id) {
        return em.find(Person.class, id);
    }

 
    public void update(Person person) {
        em.merge(person);
    }

   
    public void delete(Long id) {
        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
    
}
