package ru.kpfu.itis.models.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "cost")
    Float cost;

    @Column(name = "tag")
    String tag;

    @Column(name = "photo")
    String photo;

    @JoinColumn(name = "status_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.JOIN)
    Status status;
}
