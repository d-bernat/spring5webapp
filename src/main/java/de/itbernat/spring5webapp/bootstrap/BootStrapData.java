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
        Author dusan = new Author("Dusan", "Bernat");
        Book first = new Book("Domain Driven Design", "123123");
        dusan.getBooks().add(first);
        first.getAuthors().add(dusan);
        authorRepository.save(dusan);
        bookRepository.save(first);

        Author samuel = new Author("Samuel", "Bernat");
        Book second = new Book("HSV and Kids", "321321");
        samuel.getBooks().add(second);
        second.getAuthors().add(samuel);
        authorRepository.save(samuel);
        bookRepository.save(second);

        Publisher publisher = new Publisher("dbverlag", "Bekstr. 11", "Wedel", "SH", "22880");
        publisherRepository.save(publisher);

        log.info("Started in BootStrap...");
        log.info("Number of Books: {}", bookRepository.count());
        log.info("Number of Authors: {}", authorRepository.count());
        log.info("Number of Publishers: {}", publisherRepository.count());
    }
}
