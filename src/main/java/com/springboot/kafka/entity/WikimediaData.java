package com.springboot.kafka.entity;

import javax.persistence.*;

@Entity
@Table(name = "Wikimedia")
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Lob
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
