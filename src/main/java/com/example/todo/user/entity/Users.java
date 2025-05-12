package com.example.todo.user.entity;

import com.example.todo.memo.entity.Memo;
import com.example.todo.user.config.Gender;
import jakarta.persistence.*;
import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birth;
    private Gender gender;

    @OneToMany(mappedBy = "author")
    private List<Memo> memos;

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
