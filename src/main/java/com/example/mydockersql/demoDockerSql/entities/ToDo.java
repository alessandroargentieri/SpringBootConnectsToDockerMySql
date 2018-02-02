package com.example.mydockersql.demoDockerSql.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity @Table(name="todos")
@AllArgsConstructor @NoArgsConstructor @Data
public class ToDo {

    @Id @GeneratedValue @Column(name="id")
    private Integer id;

    @Column(name="description") @NotBlank
    private String description;

    @Column(name="createdat")
    private Date createdAt;

    @PrePersist
    private void setDate(){
        this.createdAt = new Date();
    }
}
