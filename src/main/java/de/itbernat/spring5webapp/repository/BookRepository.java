package de.itbernat.spring5webapp.repository;

import de.itbernat.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
