package de.itbernat.spring5webapp.controller;

import de.itbernat.spring5webapp.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ":-) " + authorRepository.findById(1L).get().toString();
    }

}
