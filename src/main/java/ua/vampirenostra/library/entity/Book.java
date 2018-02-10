package ua.vampirenostra.library.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "books", catalog = "librarydb")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Book implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Size(message = "This field can`t be EMPTY and should not exceed 254 characters",min = 1, max = 254)
    private String title;
    @ManyToOne
    @NotNull(message = "This field can`t be EMPTY!")
    private Publisher publisher;
    @NotNull(message = "This field can`t be EMPTY!")
    //TODO: Write a custom validator for Year (current is a crutch)
    @DecimalMax(message ="If you read this there are 2 options:\neather more that 10 years passed since I wrote this, \nor you mis inputed the year", value = "2028")
    private Short publishingYear;

    @NotNull(message = "This field can`t be EMPTY!")
    @DecimalMax(message = "Maximal allowed value 1000 pages", value = "1000")
    private Integer numberOfPages;
    @NotNull(message = "This field can`t be EMPTY!")
    private Format format;

    @ManyToMany (fetch = FetchType.LAZY)
    @Size(message = "There should be atleast one Author selected", min = 1)
    private List<Author> authorsList;

    //Constructors
    public Book() {
    }

    //Getters-Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public Short getPublishingYear() {
        return publishingYear;
    }
    public void setPublishingYear(Short publishingYear) {
        this.publishingYear = publishingYear;
    }
    public Integer getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public Format getFormat() {
        return format;
    }
    public void setFormat(Format format) {
        this.format = format;
    }
    public List<Author> getAuthorsList() {
        return authorsList;
    }
    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getPublisher(), book.getPublisher()) &&
                Objects.equals(getPublishingYear(), book.getPublishingYear()) &&
                Objects.equals(getNumberOfPages(), book.getNumberOfPages()) &&
                getFormat() == book.getFormat() &&
                Objects.equals(getAuthorsList(), book.getAuthorsList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getPublisher(), getPublishingYear(), getNumberOfPages(), getFormat(), getAuthorsList());
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", publishingYear=" + publishingYear +
                ", numberOfPages=" + numberOfPages +
                ", format=" + format +
                ", authorsList=" + authorsList +
                '}';
    }
}
