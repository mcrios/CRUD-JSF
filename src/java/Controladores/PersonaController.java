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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author DataSoft
 */
@ManagedBean
@SessionScoped
public class PersonaController {

    private Persona p = new Persona();
    private List<Persona> personas;
    private PersonaDAO pDAO = new PersonaDAO();

    /**
     * Creates a new instance of PersonaController
     */
    public PersonaController() {
    }

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
        setPersonas(pDAO.finAll());
        return getPersonas();
    }

    public String ingresarPersona() {
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
        setP(persona);
        return "cPersona.xhtml";
    }
    
    public String eliminarPersona(Persona persona){
        pDAO.eliminar(persona);
        return "index.xhtml?faces-redirect=true";
    }
}
