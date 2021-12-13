package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/*
* CrudRepository je interface pro CRUD operace Springu, implementaci metod yaridi primo Spring, nemusim je
* definovat sam
* */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
