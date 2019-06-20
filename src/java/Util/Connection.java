/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DataSoft
 */
public class Connection {

    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        factory = Persistence.createEntityManagerFactory("JSF01PU");
        return factory;

    }

}
