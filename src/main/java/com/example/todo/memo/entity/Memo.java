package com.example.todo.memo.entity;

import com.example.todo.memo.config.TimeStamped;
import com.example.todo.user.entity.Users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Memo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memoId;
    private String title;
    private String content;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users userId;

    public Memo(String title, String content, Users userId, String password) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.password = password;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
