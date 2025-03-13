package com.wil.library.restore;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestoreRepository extends MongoRepository<Restore, ObjectId>{
    
}
