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

    private EntityManager em;
    
    public PersonaDAO(EntityManager entityManager){
        this.em = entityManager;
    }

    public List<Persona> finAll() {
        List<Persona> personas = new ArrayList<>();
        //em = Connection.getEntityManagerFactory().createEntityManager();
        //em.getTransaction().begin();
        personas = em.createNamedQuery("Persona.findAll", Persona.class).getResultList();
        //em.close();
        return personas;
    }

    public void save(Persona p) {
        //em = Connection.getEntityManagerFactory().createEntityManager();
        try {
            //em.getTransaction().begin();
            em.persist(p);
            //em.getTransaction().commit();
        } catch (Exception e) {
            //em.getTransaction().rollback();
            System.out.println("ERROR AL GUARDAR " + e.getMessage());
        } finally {
            //em.close();
        }
    }

    public void editar(Persona p) {
        //em = Connection.getEntityManagerFactory().createEntityManager();
        try {
            //em.getTransaction().begin();
            em.merge(p);
            //em.getTransaction().commit();
        } catch (Exception e) {
            //em.getTransaction().rollback();
            System.out.println("ERROR AL EDITAR " + e.getMessage());
        } finally {
            //em.close();
        }
    }

    public void eliminar(Persona p) {
        //em = Connection.getEntityManagerFactory().createEntityManager();
        try {
            //em.getTransaction().begin();
            em.remove(em.merge(p));
            //em.getTransaction().commit();
        } catch (Exception e) {
            //em.getTransaction().rollback();
            System.out.println("ERROR AL EDITAR " + e.getMessage());
        } finally {
            //em.close();
        }
    }
}
