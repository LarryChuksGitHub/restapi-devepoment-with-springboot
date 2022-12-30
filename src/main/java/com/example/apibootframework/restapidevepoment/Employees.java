package com.example.apibootframework.restapidevepoment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Employees {

    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String email;
}
