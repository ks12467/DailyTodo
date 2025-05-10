package com.example.todo.user.entity;

import com.example.todo.user.config.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birth;
    private Gender gender;

    public Users(String name, String birth, Gender gender) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
    }

    public void update(String name, String birth) {
        this.name = name;
        this.birth = birth;
    }
}
