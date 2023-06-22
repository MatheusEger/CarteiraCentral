/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.dao;

import com.br.entidades.Cartaodecredito;
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
public class CartaodecreditoDaoTest {
    
    public CartaodecreditoDaoTest() {
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
     * Test of inserir method, of class CartaodecreditoDao.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        Cartaodecredito cat = new Cartaodecredito();
        cat.setNomeCartao("Cartão teste");
        cat.setDataFechamento(1);
        cat.setDataVencimento(12);
        cat.setLimiteCartao(500.00);
        CartaodecreditoDao instance = new CartaodecreditoDao();
        instance.inserir(cat);
        
    }
    /**
     * Test of excluir method, of class CartaodecreditoDao.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        Cartaodecredito cat = new Cartaodecredito();
        CartaodecreditoDao instance = new CartaodecreditoDao();
        instance.excluir(cat);
    }
   
    
}
