/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC-Eger
 */
public class Singleton {
    
    private static EntityManager conection;
    private static EntityManagerFactory emf;
    
    public static EntityManager getConection() {
        if(conection==null){
          
            setConection();
        }

        return conection;
        
    }

    /**
     */
    public static void setConection() {
        emf = Persistence.createEntityManagerFactory("JPA");
        conection = emf.createEntityManager();
        
    }
    
}
