/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.projetolpooe1_nicolasscopel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nicolas Scopel
 */

@Entity
@Table (name = "tb_veiculo")
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(nullable = false, length = 4)
    private Integer ano;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cor cor; // ENUM
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Marca marca; // ENUM
    
    @OneToMany(mappedBy = "veiculo")
    private Collection<Locacao> locacoes = new ArrayList<>() ; //AGREGAÇÃO
    
    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    private Proprietario proprietario;

    public Veiculo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Collection<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(Collection<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    
     public void addLocacao(Locacao locacao) {
        locacoes.add(locacao);
        locacao.setVeiculo(this);
    }

    public void removeLocacao(Locacao locacao) {
        locacoes.remove(locacao);
        locacao.setVeiculo(null);
    }
    
    
}
