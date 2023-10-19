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


    public Decoration() {
    }

    public Decoration(Long id, String name, String materials, String directions) {
        this.id = id;
        this.name = name;
        this.materials = materials;
        this.directions = directions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }


    @Override
    public String toString() {
        return "Decoration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", materials='" + materials + '\'' +
                ", directions='" + directions + '\'' +
                '}';
    }
}
