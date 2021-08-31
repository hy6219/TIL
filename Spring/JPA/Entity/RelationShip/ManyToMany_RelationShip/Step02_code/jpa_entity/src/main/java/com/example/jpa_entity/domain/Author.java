package com.example.jpa_entity.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class Author extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

  //  @ManyToMany
    @OneToMany
    @JoinColumn(name="author_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors=new ArrayList<>();

//    public void addBook(Book...book){
//        Collections.addAll(this.books,book);
//    }

    public void addBookAndAuthor(BookAndAuthor...bookAndAuthor){
        Collections.addAll(this.bookAndAuthors,bookAndAuthor);
    }
}
