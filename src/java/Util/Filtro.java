/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author DataSoft
 */
public class Filtro implements Filter{

    private EntityManagerFactory factory;    
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        factory = Connection.getEntityManagerFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        EntityManager em = this.factory.createEntityManager();
        request.setAttribute("entityManager", em);
        em.getTransaction().begin();
        chain.doFilter(request, response);

        try {
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error en la conexion");
        } finally {
            em.close();
        }
    }

    @Override
    public void destroy() {
        this.factory.close();
    }
    
}
