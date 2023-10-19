package com.example.christmasplanner.model;

import javax.persistence.*;


@Entity
@Table(name="decorations")
public class Decoration {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String materials;

    @Column
    private String directions;


}
