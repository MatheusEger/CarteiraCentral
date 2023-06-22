package com.br.entidades;

import com.br.entidades.Movimentacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-22T00:53:08")
@StaticMetamodel(Conta.class)
public class Conta_ { 

    public static volatile ListAttribute<Conta, Movimentacao> movimentacaoList1;
    public static volatile SingularAttribute<Conta, Integer> idConta;
    public static volatile ListAttribute<Conta, Movimentacao> movimentacaoList;
    public static volatile SingularAttribute<Conta, String> nomeConta;
    public static volatile SingularAttribute<Conta, Double> saldoConta;

}