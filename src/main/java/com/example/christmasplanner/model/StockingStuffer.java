package com.example.christmasplanner.model;

import javax.persistence.*;


@Entity
@Table(name="stockingstuffers")
public class StockingStuffer {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String tag;


    public StockingStuffer() {
    }

    public StockingStuffer(Long id, String name, String description, String tag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tag = tag;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    @Override
    public String toString() {
        return "StockingStuffer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
