package com.wil.library.restore;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class RestoreService {
    
    @Autowired
    private RestoreRepository restoreRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Restore> allRestores() { 
        return restoreRepository.findAll();
    }

    public Restore newRestore(Restore restore) {
        return restoreRepository.insert(restore);
    }

    public Restore editRestore(Restore restore, ObjectId id) {
        
        Query query = new Query(Criteria.where("_id").is(id));
        
        Update update = new Update()
        .set("idLoan", restore.getIdLoan())
        .set("penalty", restore.getPenalty());

        return mongoTemplate.findAndModify(query, update, Restore.class);

    }

    public String eraseRestore(ObjectId id) { 
        restoreRepository.deleteById(id);
        return "Borrado";
    }

}
