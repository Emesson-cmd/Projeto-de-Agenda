/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techbooster.projetoagenda02.model;

import com.techbooster.projetoagenda02.entity.Compromissos;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author emesson
 */
public class ModelCompromisso {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public List<Compromissos> listaCompromissos() {
        entityManagerFactory = Persistence.createEntityManagerFactory("AgendaPersistenceUnity");
        entityManager = entityManagerFactory.createEntityManager();

        try {
            return entityManager.createQuery("select c from Compromissos c").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao returnar uma lista de compromissos: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar lista de compromissos!");
            return null;
        } finally {
            entityManagerFactory.close();
            entityManager.close();
        }
    }

    public void addCompromisso(Compromissos c) {
        entityManagerFactory = Persistence.createEntityManagerFactory("AgendaPersistenceUnity");
        entityManager = entityManagerFactory.createEntityManager();

        if (c.getId() == 0) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(c);
                entityManager.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Compromisso salvo com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao adicionar compromisso: " + e);
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar!");
            } finally {
                entityManagerFactory.close();
                entityManager.close();
            }
        } else {
            try {
                entityManager.getTransaction().begin();
                entityManager.merge(c);
                entityManager.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Compromisso atualizado com sucesso!");
            } catch (Exception e) {
                System.err.println("Erro ao atualizar compromisso: " + e);
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar alteração!");
            } finally {
                entityManagerFactory.close();
                entityManager.close();
            }
        }
    }

    public void excluirCompromisso(int id) {
        entityManagerFactory = Persistence.createEntityManagerFactory("AgendaPersistenceUnity");
        entityManager = entityManagerFactory.createEntityManager();
        
        try {
            Compromissos c = entityManager.find(Compromissos.class, id);
            
            entityManager.getTransaction().begin();
            entityManager.remove(c);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Compromisso excluido com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao excluir compromisso: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir!");
        } finally {
            entityManagerFactory.close();
            entityManager.close();
        }
    }
}
