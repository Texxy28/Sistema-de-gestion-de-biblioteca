package com.wil.library.users;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<User> insertUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.newUser(user), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateBook(@PathVariable ObjectId id, @RequestBody User user) {
        return new ResponseEntity<User>(userService.editUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable ObjectId id){ 
        return new ResponseEntity<String>(userService.eraseUser(id), HttpStatus.OK);
    }

}
