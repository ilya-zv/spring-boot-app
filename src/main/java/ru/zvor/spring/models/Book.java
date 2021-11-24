package ru.zvor.spring.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "authorId")
    @ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "authorId"))
    private List<Author> author;

    @Column(name = "genre")
    @ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "genreId"))
    private List<Genre> genre;

    @Column(name = "comment")
    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "commentId"))
    private List<Comment> comment;

}
