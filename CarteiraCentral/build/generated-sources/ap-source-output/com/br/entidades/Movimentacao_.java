package com.br.entidades;

import com.br.entidades.Categoria;
import com.br.entidades.Conta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-22T00:53:08")
@StaticMetamodel(Movimentacao.class)
public class Movimentacao_ { 

    public static volatile SingularAttribute<Movimentacao, Date> dataMovi;
    public static volatile SingularAttribute<Movimentacao, String> descricaoMovi;
    public static volatile SingularAttribute<Movimentacao, Conta> idContaOrigem;
    public static volatile SingularAttribute<Movimentacao, Conta> idContaDestino;
    public static volatile SingularAttribute<Movimentacao, Integer> idMovimentacao;
    public static volatile SingularAttribute<Movimentacao, Double> valorMovi;
    public static volatile SingularAttribute<Movimentacao, Categoria> idCategoria;
    public static volatile SingularAttribute<Movimentacao, String> tipoMovi;

}