/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techbooster.projetoagenda02.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author emesson
 */
@Entity
@Table(name = "compromissos")
public class Compromissos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String tipo;
    private String data_comp;
    private String hora_comp;

    public Compromissos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData_comp() {
        return data_comp;
    }

    public void setData_comp(String data_comp) {
        this.data_comp = data_comp;
    }

    public String getHora_comp() {
        return hora_comp;
    }

    public void setHora_comp(String hora_comp) {
        this.hora_comp = hora_comp;
    }
}
