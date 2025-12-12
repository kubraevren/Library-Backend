package com.kubraevren.library.model;

import com.kubraevren.library.enums.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @Column(unique=true, nullable=false)
    private Long serialNo;

    @Column(unique=false, nullable=false)
    private String title;

    @Column(unique=false, nullable=false)
    private String author;

    @Column(unique=false, nullable=false)
    private int pageCount;

    @Column(unique=false, nullable=true)
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(unique=false, nullable=true)
    private String category;

    @Column(unique=false, nullable=true)
    private String imageUrl;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;

}
