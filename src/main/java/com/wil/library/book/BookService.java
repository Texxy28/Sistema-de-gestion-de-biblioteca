package com.wil.library.book;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book newBook(Book book) {
        return bookRepository.insert(book);
    }

    public Book editBook(Book book, ObjectId id) {
        
        Query query = new Query(Criteria.where("_id").is(id));

        Update update = new Update()
            .set("title", book.getTitle())
            .set("author", book.getAuthor())
            .set("genre", book.getGenre())
            .set("publicationYear", book.getPublicationYear())
            .set("availableCopies", book.getAvailableCopies())
            .set("totalCopies", book.getTotalCopies());

        return mongoTemplate.findAndModify(query, update, Book.class);
    }

    public String eraseBook(ObjectId id) { 
        bookRepository.deleteById(id);
        return "Borrado";
    }

}
