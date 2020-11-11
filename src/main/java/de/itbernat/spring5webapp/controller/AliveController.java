package de.itbernat.spring5webapp.controller;

import de.itbernat.spring5webapp.model.Author;
import de.itbernat.spring5webapp.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.StreamSupport;

@RestController
public class AliveController
{
    private final AuthorRepository authorRepository;

    public AliveController(AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @GetMapping("alive")
    public String alive()
    {
        String author = StreamSupport.stream(authorRepository.findAll().spliterator(), false)
                                     .findFirst()
                                     .orElse(new Author())
                                     .toString();
        return ":-) " + author;
    }
}
