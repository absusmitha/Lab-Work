package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull (message = "Name should not be null.")
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age = 0L;

    @Email(message = "Please enter a valid email.")
    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @NotNull
    @Column(name = "department")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAT;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;





}

