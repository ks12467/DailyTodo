package com.example.todo.user.entity;

import com.example.todo.config.TimeStamped;
import com.example.todo.memo.entity.Memo;
import jakarta.persistence.*;
import java.util.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Users extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "author")
    private List<Memo> memos;

    public Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
