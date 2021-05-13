package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count "+publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book bb = new Book("Eric has a Evans","1243");

        eric.getBooks().add(bb);
        bb.getAuthors().add(eric);
        bb.setPublisher(publisher);
        publisher.getBooks().add(bb);

        authorRepository.save(eric);
        bookRepository.save(bb);
        publisherRepository.save(publisher);

        Author rod = new Author("Roj","Johnson");
        Book noejb = new Book("No Ejbs for Rod","3452");

        rod.getBooks().add(noejb);
        noejb.getAuthors().add(rod);
        noejb.setPublisher(publisher);
        publisher.getBooks().add(noejb);

        authorRepository.save(rod);
        bookRepository.save(noejb);
        publisherRepository.save(publisher);

        System.out.println("Starting Bootstrap");
        System.out.println("No of Books "+bookRepository.count());
    }
}
