package de.itbernat.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book(String title, String isbn)
    {
        this.title = title;
        this.isbn = isbn;
    }

    public Book()
    {
    }

    protected boolean canEqual(final Object other)
    {
        return other instanceof Book;
    }

    public Long getId()
    {
        return this.id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getIsbn()
    {
        return this.isbn;
    }

    public Set<Author> getAuthors()
    {
        return this.authors;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }

    public boolean equals(final Object o)
    {
        if (o == this)
        {
            return true;
        }
        if (!(o instanceof Book))
        {
            return false;
        }
        final Book other = (Book) o;
        if (!other.canEqual(this))
        {
            return false;
        }
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id))
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        return result;
    }

    public String toString()
    {
        return "Book(id=" + this.getId() + ", title=" + this.getTitle() + ", isbn=" + this.getIsbn() + ")";
    }
}
