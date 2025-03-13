package com.wil.library.users;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private LocalDate registerDate = LocalDate.now();

}
