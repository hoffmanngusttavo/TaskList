/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.repository;

import br.com.supero.task.entities.Task;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Classe de repositório da Task
 * @author Gustavo Hoffmann
 */
public class TaskRepository extends BasicRepository{

    public TaskRepository(EntityManager entityManager) {
        super(entityManager);
    }
    
    
    /**
     * Método responsável por retornar uma tarefa pelo id
     * @param idOfTask
     * @return 
     */
     public Task getTask(int idOfTask) {
        return getEntity(Task.class, idOfTask);
    }

     /**
     * Método responsável por atualizar uma tarefa
     * @param task
     * @return 
     */
    public Task updateTask(Task task) {
        return setEntity(Task.class, task);
    }

    /**
     * Método responsável por criar uma tarefa
     * @param task
     * @return 
     */
    public Task addTask(Task task) {
        return addEntity(Task.class, task);
    }

    /**
     * Método responsável por remover uma tarefa
     * @param task
     */
    public void removeTask(Task task) {
        removeEntity(task);
    }
    
    /**
     * Método responsável por recuperar todas as tarefas cadastradas
     * @return 
     */
     public List<Task> getTasks() {
        return getPureList(Task.class, "select task from Task task");
    }
    
}
