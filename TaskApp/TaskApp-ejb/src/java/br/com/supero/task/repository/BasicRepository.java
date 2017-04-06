/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Classe de repositório genérica de última camada com o DB
 * @author Gustavo Hoffmann
 * @param <T>
 */
 abstract class BasicRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final EntityManager entityManager;

    public BasicRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    protected <T> T getEntity(Class<T> classToCast,Serializable pk) {
        return getEntityManager().find(classToCast, pk);
    }
    
    protected <T> T setEntity(Class<T> classToCast,Object entity) {
        Object updatedObj = getEntityManager().merge(entity);
        return (T) updatedObj;
    }
    
    protected <T> T addEntity(Class<T> classToCast,Object entity) {
        getEntityManager().persist(entity);
        return (T) entity; 
    }
    
    protected void removeEntity(Object entity) {
        Object updateObj = getEntityManager().merge(entity);
        getEntityManager().remove(updateObj);
    }
    
    protected <T> List<T> getPureList(Class<T> classToCast,String query,Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    private Query createQuery(String query,Object... values) {
        Query qr = getEntityManager().createQuery(query);
        for (int i = 0; i < values.length; i++) {
            qr.setParameter((i+1), values[i]);
        }
        return qr;
    }

}
