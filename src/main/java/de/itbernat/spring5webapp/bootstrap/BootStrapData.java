package de.itbernat.spring5webapp.bootstrap;

import de.itbernat.spring5webapp.model.Author;
import de.itbernat.spring5webapp.model.Book;
import de.itbernat.spring5webapp.model.Publisher;
import de.itbernat.spring5webapp.repository.AuthorRepository;
import de.itbernat.spring5webapp.repository.BookRepository;
import de.itbernat.spring5webapp.repository.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Component
public class BootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String[] args)
    {
        Publisher publisher = new Publisher("dbverlag", "Bekstr. 11", "Wedel", "SH", "22880");
        publisherRepository.save(publisher);

        Author dusan = new Author("Dusan", "Bernat");
        Book first = new Book("Domain Driven Design", "123123");

        // many to many
        first.getAuthors().add(dusan);
        dusan.getBooks().add(first);

        // one to many
        first.setPublisher(publisher);
        publisher.getBooks().add(first);


        authorRepository.save(dusan);
        bookRepository.save(first);
        publisherRepository.save(publisher);

        Author samuel = new Author("Samuel", "Bernat");
        Book second = new Book("HSV and Kids", "321321");

        //many to many
        second.getAuthors().add(samuel);
        samuel.getBooks().add(second);
        second.setPublisher(publisher);
        publisher.getBooks().add(second);

        authorRepository.save(samuel);
        bookRepository.save(second);
        publisherRepository.save(publisher);

        log.info("Started in BootStrap...");
        log.info("Number of Books: {}", bookRepository.count());
        log.info("Number of Authors: {}", authorRepository.count());
        String books = StreamSupport.stream(publisherRepository.findAll().spliterator(), false)
                                    .findFirst()
                                    .orElse(new Publisher())
                                    .getBooks()
                                    .stream()
                                    .map(Book::toString)
                                    .collect(Collectors.joining("::"));
        log.info("Publisher books: {}", books);
    }
}
