package com.br.dao;

    import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.br.entidades.Categoria;
import com.br.utils.Singleton;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class CategoriaDao {
    
    
    private EntityManager em;
    
    
   
    public CategoriaDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Categoria cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    
    public void alterar(Categoria cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();

    }
    
    public void excluir(Categoria cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();

    }
    
    public List getLista(String cat){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Categoria e where e.nomeCategoria LIKE:likes");
        query.setParameter("likes", "%" + cat.trim() +"%");
        List<Categoria> lista = query.getResultList();      
        em.getTransaction().commit();
        return lista;

    }
    
    public List getListaFiltro(String cat){
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT e FROM Categoria e where e.tipoLancamento =:likes");
            query.setParameter("likes",cat);
            List<Categoria> lista = query.getResultList();
            em.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
             
    }

    public List<Categoria> getListaPorPeriodoEspecifico(Date dataInicialDate, Date dataFinalDate) {
    EntityTransaction transaction = em.getTransaction();

    try {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        Query query = em.createQuery("SELECT DISTINCT m.idCategoria FROM Movimentacao m WHERE m.dataMovi BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("dataInicial", dataInicialDate);
        query.setParameter("dataFinal", dataFinalDate);
        List<Categoria> lista = query.getResultList();

        if (transaction.isActive()) {
            transaction.commit();
        }

        return lista;
    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        throw e;
    }
}



    
}

    

