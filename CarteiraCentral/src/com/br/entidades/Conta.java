/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PC-Eger
 */
@Entity
@Table(name = "conta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conta.findAll", query = "SELECT c FROM Conta c")
    , @NamedQuery(name = "Conta.findByIdConta", query = "SELECT c FROM Conta c WHERE c.idConta = :idConta")
    , @NamedQuery(name = "Conta.findByNomeConta", query = "SELECT c FROM Conta c WHERE c.nomeConta = :nomeConta")
    , @NamedQuery(name = "Conta.findBySaldoConta", query = "SELECT c FROM Conta c WHERE c.saldoConta = :saldoConta")})
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConta")
    private Integer idConta;
    @Basic(optional = false)
    @Column(name = "NomeConta")
    private String nomeConta;
    @Basic(optional = false)
    @Column(name = "SaldoConta")
    private double saldoConta;
    @OneToMany(mappedBy = "idContaOrigem", fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacaoList;
    @OneToMany(mappedBy = "idContaDestino", fetch = FetchType.EAGER)
    private List<Movimentacao> movimentacaoList1;

    public Conta() {
    }

    public Conta(Integer idConta) {
        this.idConta = idConta;
    }

    public Conta(Integer idConta, String nomeConta, double saldoConta) {
        this.idConta = idConta;
        this.nomeConta = nomeConta;
        this.saldoConta = saldoConta;
    }

    public Integer getIdConta() {
        return idConta;
    }

    
    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList() {
        return movimentacaoList;
    }

    public void setMovimentacaoList(List<Movimentacao> movimentacaoList) {
        this.movimentacaoList = movimentacaoList;
    }

    @XmlTransient
    public List<Movimentacao> getMovimentacaoList1() {
        return movimentacaoList1;
    }

    public void setMovimentacaoList1(List<Movimentacao> movimentacaoList1) {
        this.movimentacaoList1 = movimentacaoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConta != null ? idConta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conta)) {
            return false;
        }
        Conta other = (Conta) object;
        if ((this.idConta == null && other.idConta != null) || (this.idConta != null && !this.idConta.equals(other.idConta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entidades.Conta[ idConta=" + idConta + " ]";
    }

    public LocalDate getDataLimite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
