package com.whythat.JobPortal.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="userss")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
