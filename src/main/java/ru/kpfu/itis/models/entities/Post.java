package ru.kpfu.itis.models.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "text")
    String text;

    @Column(name = "tag")
    String tag;

    @Column(name = "photo")
    String photo;
}
