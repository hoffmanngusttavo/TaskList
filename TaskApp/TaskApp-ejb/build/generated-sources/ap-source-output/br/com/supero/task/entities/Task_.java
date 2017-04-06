package br.com.supero.task.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-05T22:47:21")
@StaticMetamodel(Task.class)
public class Task_ { 

    public static volatile SingularAttribute<Task, String> taskDescricao;
    public static volatile SingularAttribute<Task, String> taskTitulo;
    public static volatile SingularAttribute<Task, Date> taskDataCriacao;
    public static volatile SingularAttribute<Task, Date> taskDataEdicao;
    public static volatile SingularAttribute<Task, Date> taskDataConclusao;
    public static volatile SingularAttribute<Task, Integer> taskId;
    public static volatile SingularAttribute<Task, Boolean> taskStatus;

}