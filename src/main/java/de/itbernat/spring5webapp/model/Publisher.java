package de.itbernat.spring5webapp.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher(String name, String addressLine1, String city, String state, String zip)
    {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Publisher()
    {
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }

    public Long getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddressLine1()
    {
        return this.addressLine1;
    }

    public String getCity()
    {
        return this.city;
    }

    public String getState()
    {
        return this.state;
    }

    public String getZip()
    {
        return this.zip;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public boolean equals(final Object o)
    {
        if (o == this)
        {
            return true;
        }
        if (!(o instanceof Publisher))
        {
            return false;
        }
        final Publisher other = (Publisher) o;
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

    protected boolean canEqual(final Object other)
    {
        return other instanceof Publisher;
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
        return "Publisher(id=" + this.getId() + ", name=" + this.getName() + ", addressLine1=" + this.getAddressLine1() + ", city=" + this.getCity() + ", state=" + this.getState() + ", zip=" + this.getZip() + ")";
    }
}
