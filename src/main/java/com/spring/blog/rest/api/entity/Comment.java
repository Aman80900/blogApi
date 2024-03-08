package com.spring.blog.rest.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {


    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private long id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="body",nullable = false)
    private String body;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "post_id",
            nullable = false
    )
    private Post post;
}
