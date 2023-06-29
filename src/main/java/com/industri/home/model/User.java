package com.industri.home.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    @Column(name ="nama", length = 25, nullable = false)
    private String nama;

    @Column(name ="email", nullable = false, length = 50)
    private String email;

    @Column(name ="password", nullable = false)
    private String password;

    @Column(name ="alamat")
    private String alamat;

    @JsonIgnore
    private String hp;
    @JsonIgnore
    private String roles;
    @JsonIgnore
    private Boolean isAktif;

    public User(String username) {
        this.id = username;
    }

}
