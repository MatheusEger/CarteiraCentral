/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC-Eger
 */
@Entity
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findSumValorMoviByCategoria", query = "SELECT m FROM Movimentacao m")
    , @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao")
    , @NamedQuery(name = "Movimentacao.findByTipoMovi", query = "SELECT m FROM Movimentacao m WHERE m.tipoMovi = :tipoMovi")
    , @NamedQuery(name = "Movimentacao.findByValorMovi", query = "SELECT m FROM Movimentacao m WHERE m.valorMovi = :valorMovi")
    , @NamedQuery(name = "Movimentacao.findByDataMovi", query = "SELECT m FROM Movimentacao m WHERE m.dataMovi = :dataMovi")
    , @NamedQuery(name = "Movimentacao.findByDescricaoMovi", query = "SELECT m FROM Movimentacao m WHERE m.descricaoMovi = :descricaoMovi")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMovimentacao")
    private Integer idMovimentacao;
    @Basic(optional = false)
    @Column(name = "tipoMovi")
    private String tipoMovi;
    @Basic(optional = false)
    @Column(name = "valorMovi")
    private double valorMovi;
    @Basic(optional = false)
    @Column(name = "dataMovi")
    @Temporal(TemporalType.DATE)
    private Date dataMovi;
    @Column(name = "descricaoMovi")
    private String descricaoMovi;
    @JoinColumn(name = "idContaOrigem", referencedColumnName = "idConta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Conta idContaOrigem;
    @JoinColumn(name = "idContaDestino", referencedColumnName = "idConta")
    @ManyToOne(fetch = FetchType.EAGER)
    private Conta idContaDestino;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria idCategoria;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Movimentacao(Integer idMovimentacao, String tipoMovi, double valorMovi, Date dataMovi) {
        this.idMovimentacao = idMovimentacao;
        this.tipoMovi = tipoMovi;
        this.valorMovi = valorMovi;
        this.dataMovi = dataMovi;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getTipoMovi() {
        return tipoMovi;
    }

    public void setTipoMovi(String tipoMovi) {
        this.tipoMovi = tipoMovi;
    }

    public double getValorMovi() {
        return valorMovi;
    }

    public void setValorMovi(double valorMovi) {
        this.valorMovi = valorMovi;
    }

    public Date getDataMovi() {
        return dataMovi;
    }

    public void setDataMovi(Date dataMovi) {
        this.dataMovi = dataMovi;
    }

    public String getDescricaoMovi() {
        return descricaoMovi;
    }

    public void setDescricaoMovi(String descricaoMovi) {
        this.descricaoMovi = descricaoMovi;
    }

    public Conta getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(Conta idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public Conta getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(Conta idContaDestino) {
        this.idContaDestino = idContaDestino;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entidades.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }
    
}
