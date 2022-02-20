/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techbooster.projetoagenda02.controller;

import com.techbooster.projetoagenda02.entity.Compromissos;
import com.techbooster.projetoagenda02.model.ModelCompromisso;
import java.util.List;

/**
 *
 * @author emesson
 */
public class ControllerCompromissos {       
    public List<Compromissos> getCompromissos(){
        return new ModelCompromisso().listaCompromissos();
    }
    
    public void addCompromisso(Compromissos c){
        new ModelCompromisso().addCompromisso(c);
    }
    
    public void excluirCompromisso(int id){
        new ModelCompromisso().excluirCompromisso(id);
    }
}
