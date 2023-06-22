/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.dao;

import com.br.entidades.Categoria;
import com.br.entidades.Movimentacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC-Eger
 */
public class CategoriaDaoTest {
    
    public CategoriaDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class CategoriaDao.
     */
    @Test
    public void testInserir() {
        ArrayList<Movimentacao> lista = new ArrayList<>();
        System.out.println("inserir");
        Categoria cat = new Categoria();
        cat.setNomeCategoria("Teste categoria");
        cat.setTipoLancamento("Receita");
        cat.setMovimentacaoList(lista);
        CategoriaDao instance = new CategoriaDao();
        instance.inserir(cat);
    }

    /**
     * Test of excluir method, of class CategoriaDao.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Categoria cat = new Categoria();
        CategoriaDao instance = new CategoriaDao();
        instance.excluir(cat);   
    }    
}