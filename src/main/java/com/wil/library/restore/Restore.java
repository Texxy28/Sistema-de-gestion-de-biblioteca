package com.wil.library.restore;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "restores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restore {
    
    @Id
    private ObjectId id;
    private ObjectId idLoan;
    private LocalDate restoreDate = LocalDate.now();
    private double penalty;

}
