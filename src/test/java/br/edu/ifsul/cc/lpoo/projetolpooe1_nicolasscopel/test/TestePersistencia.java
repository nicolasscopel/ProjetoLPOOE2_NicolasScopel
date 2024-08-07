/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.test;

import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Cor;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Locacao;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Marca;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Proprietario;
import br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model.Veiculo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas Scopel
 */
public class TestePersistencia {
    
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        
        jpa.fecharConexao();
        
    }



    //@Test 
    public void testePersistenciaProprietarioVeiculo() throws Exception{
        
        Proprietario p = new Proprietario(); //CRIANDO E PERSISTINDO PROPRIETARIO
        p.setCpf("22233344455");
        p.setEmail("teste@email.com");
        p.setNome("Valdecir");
        p.setRg("1112223334");
        p.setTelefone("54911223344");
        jpa.persist(p);
        
        
        Veiculo v = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 1
        v.setCor(Cor.PRETO); //SETANDO COR
        v.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v.setAno(2018);
        v.setModelo("Polo");
        v.setProprietario(p);       
        jpa.persist(v);
        
        
        v = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 2
        v.setCor(Cor.PRETO); //SETANDO COR
        v.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v.setAno(2018);
        v.setModelo("Jetta");
        v.setProprietario(p);
        jpa.persist(v);
    }
    
    //@Test 
    public void testePersistenciaLocacaoVeiculo() throws Exception{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Proprietario p = new Proprietario(); //CRIANDO E PERSISTINDO PROPRIETARIO
        p.setCpf("22233344455");
        p.setEmail("teste@email.com");
        p.setNome("Valdecir");
        p.setRg("1112223334");
        p.setTelefone("54911223344");
        jpa.persist(p);
        
        
        Veiculo v = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 1
        v.setCor(Cor.PRETO); //SETANDO COR
        v.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v.setAno(2018);
        v.setModelo("Polo");
        v.setProprietario(p);       
        jpa.persist(v);
        
        
        Locacao l = new Locacao();
        l.setDataEntrada(Calendar.getInstance());
        l.setNumeroVaga("5");
        l.setVeiculo(v);
        jpa.persist(l);
        
             
    }

    //@Test
    public void testePersistenciaCollection() throws Exception{
        
        List<Locacao> locacoes = new ArrayList();
        
        Proprietario p1 = new Proprietario(); //CRIANDO E PERSISTINDO PROPRIETARIO
        p1.setCpf("22233344455");
        p1.setEmail("teste@email.com");
        p1.setNome("Valdecir");
        p1.setRg("1112223334");
        p1.setTelefone("54911223344");
        jpa.persist(p1);
        
        
        Veiculo v1 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 1
        v1.setCor(Cor.PRETO); //SETANDO COR
        v1.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v1.setAno(2018);
        v1.setModelo("Polo");
        v1.setProprietario(p1);   
        
        Veiculo v2 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 2
        v2.setCor(Cor.BRANCO); //SETANDO COR
        v2.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v2.setAno(2012);
        v2.setModelo("Jetta");
        v2.setProprietario(p1);  
         

        Locacao l1 = new Locacao();
        l1.setDataEntrada(Calendar.getInstance());
        l1.setNumeroVaga("1");
        l1.setVeiculo(v1);
        
        Locacao l2 = new Locacao();
        l2.setDataEntrada(Calendar.getInstance());
        l2.setNumeroVaga("2");
        l2.setVeiculo(v1);   // MUDAR PARA V2 PARA ALTERAR TESTE 3  
        
        //v1.addLocacao(l1);
        //v1.addLocacao(l2); //PODE SER SETADO ASSIM SEM PRECISAR CRIAR COLLECTION POIS FOI ALTERADO NA CLASSE
        
        locacoes.add(l1);
        locacoes.add(l2);
        
        v1.setLocacoes(locacoes);
        jpa.persist(v1);
       // jpa.persist(v2); //TIRAR COMENTARIO PARA MUDAR O TESTE 3
        
        jpa.persist(l1);
        jpa.persist(l2);
        
        for(Locacao o : locacoes){
            System.out.println("Numero vaga: " + o.getNumeroVaga() + " Veiculo: " + o.getVeiculo().getModelo());
        }
        
        
        
    }
    
    
    //@Test
    public void testePersistenciaMaisCompleto() throws Exception{
        
        Proprietario p1 = new Proprietario(); //CRIANDO E PERSISTINDO PROPRIETARIO 1
        p1.setCpf("05489012378");
        p1.setEmail("proprietario1@gmail.com");
        p1.setNome("Walter");
        p1.setRg("1112223334");
        p1.setTelefone("54911223344");
        jpa.persist(p1);
        
        Proprietario p2 = new Proprietario(); //CRIANDO E PERSISTINDO PROPRIETARIO 2
        p2.setCpf("90245212892");
        p2.setEmail("proprietario2@gmail.com");
        p2.setNome("Ingrid");
        p2.setRg("5556667778");
        p2.setTelefone("54994216432");
        jpa.persist(p2);
        
        Veiculo v1prop1 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 1 PROP 1
        v1prop1.setCor(Cor.PRETO); //SETANDO COR
        v1prop1.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v1prop1.setAno(2018);
        v1prop1.setModelo("Polo");
        v1prop1.setProprietario(p1);   
        
        Veiculo v2prop1 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 2 PROP 1
        v2prop1.setCor(Cor.BRANCO); //SETANDO COR
        v2prop1.setMarca(Marca.VOLKSWAGEN); //SETANDO MARCA
        v2prop1.setAno(2012);
        v2prop1.setModelo("Jetta");
        v2prop1.setProprietario(p1);  
        
        Veiculo v1prop2 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 1 PROP 2
        v1prop2.setCor(Cor.AZUL); //SETANDO COR
        v1prop2.setMarca(Marca.FORD); //SETANDO MARCA
        v1prop2.setAno(2018);
        v1prop2.setModelo("KA");
        v1prop2.setProprietario(p2);  
        
        Veiculo v2prop2 = new Veiculo(); //CRIANDO E PERSISTINDO VEICULO 2 PROP 2
        v2prop2.setCor(Cor.VERMELHO); //SETANDO COR
        v2prop2.setMarca(Marca.FORD); //SETANDO MARCA
        v2prop2.setAno(2024);
        v2prop2.setModelo("RANGER");
        v2prop2.setProprietario(p2); 
        
        
        Locacao l1prop1veic1 = new Locacao(); //LOCACAO 1 VEICULO 1 PROPIETARIO 1
        l1prop1veic1.setDataEntrada(Calendar.getInstance());
        l1prop1veic1.setNumeroVaga("1");
        l1prop1veic1.setVeiculo(v1prop1);
        
        Locacao l2prop1veic1 = new Locacao(); //LOCACAO 2 VEICULO 1 PROPIETARIO 1
        l2prop1veic1.setDataEntrada(Calendar.getInstance());
        l2prop1veic1.setNumeroVaga("2");
        l2prop1veic1.setVeiculo(v1prop1);
        
        
        Locacao l1prop1veic2 = new Locacao(); //LOCACAO 1 VEICULO 2 PROPIETARIO 1
        l1prop1veic2.setDataEntrada(Calendar.getInstance());
        l1prop1veic2.setNumeroVaga("1");
        l1prop1veic2.setVeiculo(v2prop1);
        
        Locacao l2prop1veic2 = new Locacao(); //LOCACAO 2 VEICULO 2 PROPIETARIO 1
        l2prop1veic2.setDataEntrada(Calendar.getInstance());
        l2prop1veic2.setNumeroVaga("2");
        l2prop1veic2.setVeiculo(v2prop1);
        
        v1prop1.addLocacao(l1prop1veic1); //ADICIONA LOCACAO 1 PROP 1 VEIC 1 EM VEICULO1 PROP1
        v1prop1.addLocacao(l2prop1veic1); //ADICIONA LOCACAO 2 PROP 1 VEIC 1 EM VEICULO1 PROP1
        
        v2prop1.addLocacao(l1prop1veic2); //ADICIONA LOCACAO 1 PROP 1 VEIC 2 EM VEICULO2 PROP1
        v2prop1.addLocacao(l2prop1veic2); //ADICIONA LOCACAO 2 PROP 1 VEIC 2 EM VEICULO2 PROP1
        
        
        jpa.persist(v1prop1);
        jpa.persist(v2prop1);
        jpa.persist(v1prop2);
        jpa.persist(v2prop2);
        
    
        jpa.persist(l1prop1veic1);
        jpa.persist(l1prop1veic2);
        jpa.persist(l2prop1veic1);
        jpa.persist(l2prop1veic2);


        
        
    }
    
}

