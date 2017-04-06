/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supero.task.control;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Gustavo Hoffmann
 */
public abstract class BasicControl implements Serializable {

    protected void createFacesErrorMessage(String message) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    protected void createFacesInfoMessage(String message) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    protected void createFacesWarnMessage(String message) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    
}
