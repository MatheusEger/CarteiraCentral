package com.br.dao;

import com.br.entidades.Categoria;
import com.br.entidades.Conta;
import com.br.entidades.Movimentacao;
import com.br.telas.TelaCadastarTransferencia;
import com.br.telas.TelaMovimentacao;
import com.br.utils.Msg;
import com.br.utils.Singleton;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class MovimentacaoDao {
    
       private TelaMovimentacao pai;

    private EntityManager em;
    
    public MovimentacaoDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Movimentacao cat){
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }
    
    public void alterar(Movimentacao cat){
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }
    
//    public boolean transferencia(Conta conta, double valor) {
//        if(  ){
//            
//        }else
//                   
//            return false;
//            
//        
//    }
    
    public void excluir(Movimentacao cat){
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }
    
    public List getLista(String cat){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Movimentacao e");
//        Query query = em.createQuery("SELECT e FROM Movimentacao e where e.dataMovi LIKE:likes");
//        query.setParameter("likes", "%" + cat.trim() +"%");
        List<Movimentacao> lista = query.getResultList();      
        em.getTransaction().commit();
        return lista;
    }
    
    public List getListaData(String cat, Date data01, Date data02){
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Movimentacao e where e.dataMovi BETWEEN :data01 and :data02");
//        Query query = em.createQuery("SELECT e FROM Movimentacao e where e.dataMovi LIKE:likes");
        query.setParameter("data01", data01);
        query.setParameter("data02", data02);
        List<Movimentacao> lista = query.getResultList();      
        em.getTransaction().commit();
        return lista;
    }
    
    public double getSaldoTotalPorConta(int idConta) {
    em.getTransaction().begin();
    Query query = em.createQuery("SELECT SUM(e.valorMovi) FROM Movimentacao e WHERE e.idContaDestino.idConta = :idConta");
    query.setParameter("idConta", idConta);
    Double saldoTotal = (Double) query.getSingleResult();
    em.getTransaction().commit();
    return saldoTotal != null ? saldoTotal : 0.0;
    }

    public boolean verificarExistenciaMovimentacoesPorConta(Integer idConta) {
        try {
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT COUNT(e.id) FROM Movimentacao e WHERE e.idContaDestino.idConta = :idConta");
        query.setParameter("idConta", idConta);
        Long count = (Long) query.getSingleResult();
        em.getTransaction().commit();
        return count != null && count > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public List<Movimentacao> getListaPorCategoriaEPeriodo(Categoria categoria, Date dataInicial, Date dataFinal) {
    try {
        em.getTransaction().begin();
        
        Query query = em.createQuery("SELECT m FROM Movimentacao m WHERE m.categoria = :categoria AND m.data >= :dataInicial AND m.data <= :dataFinal");
        query.setParameter("categoria", categoria);
        query.setParameter("dataInicial", dataInicial);
        query.setParameter("dataFinal", dataFinal);
        
        List<Movimentacao> listaMovimentacoes = query.getResultList();
        
        em.getTransaction().commit();
        
        return listaMovimentacoes;
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw e;
    }
}

   public double getSaldoTotalPorCategoria(Integer idCategoria) {
    EntityTransaction transaction = em.getTransaction();

    try {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        Query query = em.createQuery("SELECT SUM(m.valorMovi) FROM Movimentacao m WHERE m.idCategoria.idCategoria = :idCategoria");
        query.setParameter("idCategoria", idCategoria);
        Double saldoTotal = (Double) query.getSingleResult();

        if (transaction.isActive()) {
            transaction.commit();
        }

        return saldoTotal != null ? saldoTotal : 0.0;
    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        e.printStackTrace();
        return 0.0;
    }
}


public double getSaldoTotalPorCategoriaEPeriodo(Integer idCategoria, Date dataInicialDate, Date dataFinalDate) {
    EntityTransaction transaction = em.getTransaction();

    try {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        Query query = em.createQuery("SELECT SUM(m.valorMovi) FROM Movimentacao m WHERE m.idCategoria.idCategoria = :idCategoria AND m.dataMovi BETWEEN :dataInicial AND :dataFinal");
        query.setParameter("idCategoria", idCategoria);
        query.setParameter("dataInicial", dataInicialDate);
        query.setParameter("dataFinal", dataFinalDate);
        Double saldoTotal = (Double) query.getSingleResult();

        if (transaction.isActive()) {
            transaction.commit();
        }

        return saldoTotal != null ? saldoTotal : 0.0;
    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        e.printStackTrace();
        return 0.0;
    }
}

public boolean verificarExistenciaMovimentacoesPorCategoria(Categoria categoria) {
    EntityTransaction transaction = em.getTransaction();

    try {
        if (!transaction.isActive()) {
            transaction.begin();
        }

        Query query = em.createQuery("SELECT COUNT(m.idCategoria) FROM Movimentacao m WHERE m.idCategoria = :idCategoria");
        query.setParameter("idCategoria", categoria);
        Long count = (Long) query.getSingleResult();

        if (transaction.isActive()) {
            transaction.commit();
        }

        return count != null && count > 0;
    } catch (Exception e) {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        e.printStackTrace();
        return false;
    }
}




    
}
