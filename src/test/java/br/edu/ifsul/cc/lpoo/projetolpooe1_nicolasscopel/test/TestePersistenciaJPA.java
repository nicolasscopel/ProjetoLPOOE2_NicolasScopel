/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.test;

import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.dao.PersistenciaJPA;

import org.junit.Test;


/**
 *
 * @author Nicolas Scopel
 */
public class TestePersistenciaJPA {
    
    //@Test
    public void testConexaoJPA() {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if (jpa.conexaoAberta()) {
            System.out.println("Conectou ao Banco de Dados por JPA");
            jpa.fecharConexao();
        } else {
            System.out.println("Nao conectou ao Banco de Dados");

        }
    }
}
