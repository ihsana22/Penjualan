package com.indocyber.penjualan.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "Users")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
}
