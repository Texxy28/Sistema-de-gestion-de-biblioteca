package com.wil.library.users;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User newUser(User user) {
        return userRepository.insert(user);
    }

    public User editUser(User user, ObjectId id) {
        
        Query query = new Query(Criteria.where("_id").is(id));

        Update update = new Update()
            .set("name", user.getName())
            .set("email", user.getEmail())
            .set("password", user.getPassword());

        return mongoTemplate.findAndModify(query, update, User.class);
    }

    public String eraseUser(ObjectId id) { 
        userRepository.deleteById(id);
        return "Borrado";
    }

}
