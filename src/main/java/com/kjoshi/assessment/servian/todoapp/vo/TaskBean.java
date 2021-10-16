package com.kjoshi.assessment.servian.todoapp.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskBean {

    public TaskBean(){
    }

    public TaskBean(String id, String description, Integer priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    @Id
    private String id;

    @Column
    private String description;

    @Column
    private Integer priority;

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriority() {
        return priority;
    }

}
