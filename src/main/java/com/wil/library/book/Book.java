package com.wil.library.book;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    @Id
    private ObjectId id;
    private String title;
    private String author;
    private List<String> genre;
    private int publicationYear;
    private int availableCopies;
    private int totalCopies;

}
