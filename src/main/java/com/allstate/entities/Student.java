package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    private int id;
    private int version;
    private String email;
    private Date created;
    private Date modified;
    private List<Grade> grades;

    public Student() {
    }
    public Student(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    @Size(min = 3)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonIgnore
    public List<Grade> getGrades() {
        return grades;
    }
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}