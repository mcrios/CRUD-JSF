/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Persona;
import Util.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author DataSoft
 */
public class PersonaDAO {
    private EntityManager em = Connection.getEntityManagerFactory().createEntityManager();
    
    public List<Persona> finAll(){
        List<Persona> personas = new ArrayList<>();
        personas = em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
        return personas;
    }
    public void save(Persona p){
        em.getTransaction().begin();
        try{
        em.persist(p);
        em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("ERROR AL GUARDAR " + e.getMessage());
        }
    }
    
    public void editar(Persona p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void eliminar(Persona p){
        em.getTransaction().begin();
        em.remove(em.merge(p));
        em.getTransaction().commit();
    }
}
