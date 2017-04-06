/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo Hoffmann
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")})
public class Task implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id", nullable = false)
    private Integer taskId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "task_titulo", nullable = false, length = 255)
    private String taskTitulo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "task_descricao", nullable = false, length = 65535)
    private String taskDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_status", nullable = false)
    private boolean taskStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_data_criacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date taskDataCriacao;
    @Column(name = "task_data_conclusao")
    @Temporal(TemporalType.DATE)
    private Date taskDataConclusao;
    @Column(name = "task_data_edicao")
    @Temporal(TemporalType.DATE)
    private Date taskDataEdicao;

    public Task() {
    }

    public Task(Integer taskId) {
        this.taskId = taskId;
    }

    public Task(Integer taskId, String taskTitulo, String taskDescricao, boolean taskStatus, Date taskDataCriacao) {
        this.taskId = taskId;
        this.taskTitulo = taskTitulo;
        this.taskDescricao = taskDescricao;
        this.taskStatus = taskStatus;
        this.taskDataCriacao = taskDataCriacao;
    }
    
     
    @PrePersist
    public void updateDataCriacao(){
        setTaskDataCriacao(new Date());
    }
    
    @PreUpdate
    public void updateDataEdicao(){
        setTaskDataEdicao(new Date());
    }
    
    

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitulo() {
        return taskTitulo;
    }

    public void setTaskTitulo(String taskTitulo) {
        this.taskTitulo = taskTitulo;
    }

    public String getTaskDescricao() {
        return taskDescricao;
    }

    public void setTaskDescricao(String taskDescricao) {
        this.taskDescricao = taskDescricao;
    }

    public boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getTaskDataCriacao() {
        return taskDataCriacao;
    }

    public void setTaskDataCriacao(Date taskDataCriacao) {
        this.taskDataCriacao = taskDataCriacao;
    }

    public Date getTaskDataConclusao() {
        return taskDataConclusao;
    }

    public void setTaskDataConclusao(Date taskDataConclusao) {
        this.taskDataConclusao = taskDataConclusao;
    }

    public Date getTaskDataEdicao() {
        return taskDataEdicao;
    }

    public void setTaskDataEdicao(Date taskDataEdicao) {
        this.taskDataEdicao = taskDataEdicao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.supero.task.entities.Task[ taskId=" + taskId + " ]";
    }
    
}
