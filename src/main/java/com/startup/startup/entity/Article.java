package com.startup.startup.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String title;

    @Column(name = "author", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String author;

    @Column(name = "content", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String content;

    @Column(name = "published_at", nullable = false)
    @JdbcTypeCode(SqlTypes.DATE)
    private LocalDate published_at;
}
