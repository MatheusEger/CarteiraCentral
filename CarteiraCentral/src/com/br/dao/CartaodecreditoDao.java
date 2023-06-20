package com.br.dao;

import com.br.entidades.Cartaodecredito;
import com.br.utils.Singleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CartaodecreditoDao {
    
    private EntityManager em;
    
    public CartaodecreditoDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Cartaodecredito cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    
    public void alterar(Cartaodecredito cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }
    
    public void excluir(Cartaodecredito cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
    
    public List getLista(String cat){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Cartaodecredito e where e.nomeCartao LIKE:likes");
        query.setParameter("likes", "%" + cat.trim() +"%");
        List<Cartaodecredito> lista = query.getResultList();      
        em.getTransaction().commit();
        return lista;
    }
    
    
    
}
