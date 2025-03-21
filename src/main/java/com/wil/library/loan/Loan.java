package com.wil.library.loan;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "loans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    
    @Id
    private ObjectId id;
    private ObjectId idUser;
    private ObjectId idBook;
    private LocalDate borrowDate = LocalDate.now();
    private LocalDate returnDate;
    private String state;

}
