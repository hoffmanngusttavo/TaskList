/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.control;

import br.com.supero.task.entities.Task;
import br.com.supero.task.service.TaskService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Classe controladora, responsável pela comunicação com a view
 * @author Gustavo Hoffmann
 */
@SessionScoped
@ManagedBean
public class TaskControl extends BasicControl {

    @EJB
    private TaskService taskService;
    private Task entity;

    /**
     * Método responsável por instanciar uma nova tarefa
     * e redirecionar para o formulário
     * @return 
     */
    public String doStartAddTask() {
        setEntity(new Task());
        return "/restrito/form.faces";
    }

    /**
     * Método responsável por redirecionar para a 
     * edição ta tarefa selecionada no formulário
     * @return 
     */
     public String doStartUpdateTask() {
         return "/restrito/form.faces";
    }
     
    /**
     * Método responsável por redirecionar da tela de login para a listagem
     * @return 
     */
     public String doStartTask() {
         return "/restrito/index.faces";
    }
    
     /**
     * Método responsável por salvar uma nova
     * ou editar uma tarefa
     * @return 
     */
    public String doFinishTask() {
        try {
            if (entity.getTaskId() == null) {
                taskService.addTask(entity);
            } else {
                taskService.updateTask(entity);
            }
            createFacesInfoMessage("Dados gravados com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            createFacesErrorMessage("Não foi possível salvar a tarefa");
        }
        return "/restrito/index.faces";
    }

    /**
     * Método responsável por remover uma tarefa
     * @return 
     */
    public String doFinishRemoveTask() {
        try {
            taskService.removeTask(entity);
            createFacesInfoMessage("Dados removidos com sucesso");
            return "/restrito/index.faces";
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            createFacesErrorMessage("Não foi possível remover a tarefa");
            return null;
        }
    }
    
    /**
     * Método responsável por recuperar todas as tarefas cadastradas
     * @return 
     */
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    public Task getEntity() {
        return entity;
    }

    public void setEntity(Task entity) {
        this.entity = entity;
    }

}
