package ua.vampirenostra.library.domain;

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
@Table(name = "authors", catalog = "librarydb")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Author implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull(message = "This field can`t be EMPTY!")
    @Size(message = "Wrong size. Please input 2-30 characters.", min = 2, max = 30)
    private String firstName;
    @Size(message = "Wrong size. Please input 2-30 characters.", min = 0, max = 30)
    private String allNames;
    @NotNull(message = "This field can`t be EMPTY!")
    @Size(message = "Wrong size. Please input 2-30 characters.", min = 2, max = 30)
    private String lastName;
    @NotNull(message = "This field can`t be EMPTY!")
    private Sex sex;
    @ManyToOne
    @NotNull(message = "This field can`t be EMPTY!")
    private Country country;

    @ManyToMany (fetch = FetchType.LAZY, mappedBy = "authorsList")
    private List<Book> booksList;

    //Constructors
    public Author() {
    }
    //Getters-Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getAllNames() {
        return allNames;
    }
    public void setAllNames(String allNames) {
        this.allNames = allNames;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Sex getSex() {
        return sex;
    }
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public List<Book> getBooksList() {
        return booksList;
    }
    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getAllNames(), author.getAllNames()) &&
                Objects.equals(getLastName(), author.getLastName()) &&
                getSex() == author.getSex() &&
                Objects.equals(getCountry(), author.getCountry()) &&
                Objects.equals(getBooksList(), author.getBooksList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getAllNames(), getLastName(), getSex(), getCountry(), getBooksList());
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", allNames='" + allNames + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex +
                ", country=" + country +
                '}';
    }
}