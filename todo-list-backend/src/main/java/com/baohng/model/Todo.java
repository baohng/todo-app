package com.baohng.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Todo {

    //add primary key for model
    @Id
    @SequenceGenerator( //define the way id created
            name = "todo_id_sequence",
            sequenceName = "todo_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_id_sequence"
    )
    private Integer id;
    private String title;
    private String description;
    private Date dueDate;

    public Todo(Integer id,
                String title,
                String description,
                Date dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Todo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) && Objects.equals(title, todo.title) && Objects.equals(description, todo.description) && Objects.equals(dueDate, todo.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, dueDate);
    }
}
