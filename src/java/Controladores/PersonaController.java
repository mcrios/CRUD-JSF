/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import DAO.PersonaDAO;
import Entidades.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DataSoft
 */
@ManagedBean
@RequestScoped
public class PersonaController {

    /**
     * Creates a new instance of PersonaController
     */
    protected EntityManager getJpaEntityManager() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return (EntityManager) req.getAttribute("entityManager");
    }

    public PersonaController() {
    }
    
    
    private Persona p = new Persona();
    private List<Persona> personas;


    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public List<Persona> lista() {
        PersonaDAO pDAO = new PersonaDAO(getJpaEntityManager());
        setPersonas(pDAO.finAll());
        return getPersonas();
    }

    public String ingresarPersona() {
        PersonaDAO pDAO = new PersonaDAO(getJpaEntityManager());
        if (getP().getIdPersona() != null) {
            pDAO.editar(getP());
            setP(new Persona());
        } else {
            pDAO.save(getP());
            setP(new Persona());
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String editarPerson(Persona persona) {
        p = persona;
        return "cPersona.xhtml";
    }

    public String eliminarPersona(Persona persona) {
        PersonaDAO pDAO = new PersonaDAO(getJpaEntityManager());
        pDAO.eliminar(persona);
        return "index.xhtml?faces-redirect=true";
    }
}
