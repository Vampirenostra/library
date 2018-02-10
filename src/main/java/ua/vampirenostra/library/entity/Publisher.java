package ua.vampirenostra.library.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "publishers", catalog = "librarydb")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Publisher implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(unique = true)
    @NotNull(message = "This field can`t be EMPTY!")
    @Size(message = "Wrong size. Please input 2-254 characters.", min = 2, max = 254)
    private String publisherName;

    @OneToMany(mappedBy = "publisher")
    List<Book> bookList;

    //Constructors
    public Publisher() {
    }

    //Getters-Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(getPublisherName(), publisher.getPublisherName()) &&
                Objects.equals(bookList, publisher.bookList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(getPublisherName(), bookList);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }
}
