package com.bookStore.bookStore.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class MyBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String author;
    private String price;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public MyBooks(int id, String name, String author, String price) {
        Id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public MyBooks() {
    }
}
