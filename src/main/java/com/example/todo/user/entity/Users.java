package com.example.todo.user.entity;

import com.example.todo.config.TimeStamped;
import com.example.todo.memo.entity.Memo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Users extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Memo> memos;

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
