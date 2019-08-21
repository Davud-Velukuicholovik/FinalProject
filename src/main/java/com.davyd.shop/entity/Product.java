package com.davyd.shop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;

    private String photo;

    @Column(columnDefinition = "text")
    private String description;

    private Double rating;

    @ManyToOne
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "favoriteProducts")
    private List<User> users = new ArrayList<>();
}
