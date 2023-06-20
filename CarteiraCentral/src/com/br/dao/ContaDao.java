package com.br.dao;

import com.br.entidades.Conta;
import com.br.entidades.Movimentacao;
import com.br.telas.TelaMovimentacao;
import com.br.utils.Msg;
import com.br.utils.Singleton;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ContaDao {
    
    private EntityManager em;
    private TelaMovimentacao pai;

    public ContaDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Conta cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    
    public void inserir(Conta conta, double valorInicial) {
    if (conta.getSaldoConta() == 0) {
        conta.setSaldoConta(valorInicial);
    }
    
    em.getTransaction().begin();
    em.persist(conta);
    em.getTransaction().commit();
    }
    
    public void alterar(Conta cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }
    
    




    
    public void excluir(Conta cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
    
//    public void excluir(Conta cat){
//        em.getTransaction().begin();
//        em.remove(cat);
//        em.getTransaction().commit();
//    }
    
    public List getLista(String cat){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Conta e where e.nomeConta LIKE:likes");
        query.setParameter("likes", "%" + cat.trim() +"%");
        List<Conta> lista = query.getResultList();      
        em.getTransaction().commit();
        return lista;
    }

    
    
}
