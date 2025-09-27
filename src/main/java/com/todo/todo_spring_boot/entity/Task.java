package com.todo.todo_spring_boot.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "tasks")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_title")
    private String taskTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    @Column(name = "task_desc")
    private String taskDesc;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(
            mappedBy = "task",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<SubTask> subTasks = new ArrayList<>();
    // Bu List<SubTask> alanı aslında SubTask tablosunda duran task foreign key’i üzerinden ana Task ile ilişkilidir;

    public enum Status
    {
        NEW,
        IN_PROGRESS,
        DONE,
        BLOCKED,
        CANCELLED
    }

    public Long getId()
    {
        return id;
    }

    public String getTaskTitle()
    {
        return taskTitle;
    }

    public String getTaskDesc()
    {
        return taskDesc;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setTaskTitle(String taskTitle)
    {
        this.taskTitle = taskTitle;
    }

    public void setTaskDesc(String taskDesc)
    {
        this.taskDesc = taskDesc;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public List<SubTask> getSubTasks()
    {
        return subTasks;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public void setSubTasks(List<SubTask> subTasks)
    {
        this.subTasks = subTasks;
    }
}