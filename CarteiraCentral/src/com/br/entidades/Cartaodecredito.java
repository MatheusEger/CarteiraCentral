/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Eger
 */
@Entity
@Table(name = "cartaodecredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cartaodecredito.findAll", query = "SELECT c FROM Cartaodecredito c")
    , @NamedQuery(name = "Cartaodecredito.findByIdCartaoDeCredito", query = "SELECT c FROM Cartaodecredito c WHERE c.idCartaoDeCredito = :idCartaoDeCredito")
    , @NamedQuery(name = "Cartaodecredito.findByNomeCartao", query = "SELECT c FROM Cartaodecredito c WHERE c.nomeCartao = :nomeCartao")
    , @NamedQuery(name = "Cartaodecredito.findByLimiteCartao", query = "SELECT c FROM Cartaodecredito c WHERE c.limiteCartao = :limiteCartao")
    , @NamedQuery(name = "Cartaodecredito.findByDataFechamento", query = "SELECT c FROM Cartaodecredito c WHERE c.dataFechamento = :dataFechamento")
    , @NamedQuery(name = "Cartaodecredito.findByDataVencimento", query = "SELECT c FROM Cartaodecredito c WHERE c.dataVencimento = :dataVencimento")})
public class Cartaodecredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCartaoDeCredito")
    private Integer idCartaoDeCredito;
    @Basic(optional = false)
    @Column(name = "NomeCartao")
    private String nomeCartao;
    @Basic(optional = false)
    @Column(name = "LimiteCartao")
    private double limiteCartao;
    @Basic(optional = false)
    @Column(name = "DataFechamento")
    private int dataFechamento;
    @Basic(optional = false)
    @Column(name = "DataVencimento")
    private int dataVencimento;

    public Cartaodecredito() {
    }

    public Cartaodecredito(Integer idCartaoDeCredito) {
        this.idCartaoDeCredito = idCartaoDeCredito;
    }

    public Cartaodecredito(Integer idCartaoDeCredito, String nomeCartao, double limiteCartao, int dataFechamento, int dataVencimento) {
        this.idCartaoDeCredito = idCartaoDeCredito;
        this.nomeCartao = nomeCartao;
        this.limiteCartao = limiteCartao;
        this.dataFechamento = dataFechamento;
        this.dataVencimento = dataVencimento;
    }

    public Integer getIdCartaoDeCredito() {
        return idCartaoDeCredito;
    }

    public void setIdCartaoDeCredito(Integer idCartaoDeCredito) {
        this.idCartaoDeCredito = idCartaoDeCredito;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(double limiteCartao) {
        this.limiteCartao = limiteCartao;
    }

    public int getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(int dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public int getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(int dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartaoDeCredito != null ? idCartaoDeCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartaodecredito)) {
            return false;
        }
        Cartaodecredito other = (Cartaodecredito) object;
        if ((this.idCartaoDeCredito == null && other.idCartaoDeCredito != null) || (this.idCartaoDeCredito != null && !this.idCartaoDeCredito.equals(other.idCartaoDeCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entidades.Cartaodecredito[ idCartaoDeCredito=" + idCartaoDeCredito + " ]";
    }
    
}
