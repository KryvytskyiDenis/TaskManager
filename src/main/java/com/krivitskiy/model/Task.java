package com.krivitskiy.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    @Size(min=1, max=100, message = "Size.taskForm.name")
    private String name;

    @Column(name = "description")
    @Size(min=1, message = "Size.taskForm.description")
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_created")
    private Date DateCreated;

    @ManyToOne
    private User user;

    public Task() {
    }

    public Task(String name, String description, Date dateCreated, User user) {
        this.name = name;
        this.description = description;
        DateCreated = dateCreated;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
