package dev.tolstov.DTO.practice.with.mapstruct.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "author_uuid")
    private UserModel author;

    private String text;

    public Post() {
    }

    public Post(UserModel author, String text) {
        this.author = author;
        this.text = text;
    }

    public UserModel getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }
}
