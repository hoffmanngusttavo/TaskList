/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.service;

import br.com.supero.task.entities.Task;
import br.com.supero.task.repository.TaskRepository;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe de serviço, onde se aplicam as regras de negócio
 * Com a declaração dessas anotações, o container fica responsavel
 * pelas transações e injeção de dependencias.
 * @author Gustavo Hoffmann
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TaskService extends BasicService{
    
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;
    
    private TaskRepository taskRepository;
    
    @PostActivate
    @PostConstruct
    private void postConstruct() {
        taskRepository = new TaskRepository(em);
    }
    
    /**
     * Método responsável por retornar uma tarefa pelo id
     * @param id
     * @return 
     */
    public Task getTask(int id) {
        return taskRepository.getTask(id);
    }
    
    /**
     * Método responsável por atualizar uma tarefa
     * @param task
     * @return 
     */
    public Task updateTask(Task task)  {
        return taskRepository.updateTask(task);
    }
    
    /**
     * Método responsável por remover uma tarefa
     * @param task
     */
    public void removeTask(Task task) {
        taskRepository.removeTask(task);
    }
    
    /**
     * Método responsável por criar uma tarefa
     * @param task
     * @return 
     */
    public Task addTask(Task task) {
        return taskRepository.addTask(task);
    }
    
    /**
     * Método responsável por recuperar todas as tarefas cadastradas
     * @return 
     */
    public List<Task> getTasks() {
        return taskRepository.getTasks();
    }
    
}
