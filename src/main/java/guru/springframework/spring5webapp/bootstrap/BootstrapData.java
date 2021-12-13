package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* Trida oznacena @Component je nactena a instanciovana po startu (@ComponentScan) a ulozena do aplikacniho
* kontextu (jako bean), vyreseny jsou take dependency injections v instancich
* link: https://www.baeldung.com/spring-component-annotation
* */
@Component
public class BootstrapData implements CommandLineRunner {

    // dependency injection pres konstruktor
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book("Staparuv pruvodce Galaxii", "80-7203-438-3");
        Author author = new Author("Adams", "Douglas");
        Publisher publisher = new Publisher("Grada", "", "", "", "CZ");
        // prirazeni autora ke knize a knihy k autorovi
        book1.getAuthors().add(author);
        author.getBooks().add(book1);
        publisher.getBooks().add(book1);

        // ulozeni autora a knihy do repo
        authorRepository.save(author);
        bookRepository.save(book1);
        publisherRepository.save(publisher);

        Book book2 = new Book("Modelovani a simulace komplexnich systemu", "978-80-210-5318-2");
        Author author2 = new Author("Pelanek", "Radek");
        book2.getAuthors().add(author2);
        author2.getBooks().add(book2);
        publisher.getBooks().add(book2);
        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Spring started");
        System.out.println("Books in H2 db: " + bookRepository.count());
        System.out.println("Authors in H2 db:" + bookRepository.count());
        System.out.println("Publishers in H2 db:" + publisherRepository.count());
    }
}
