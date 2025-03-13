package com.wil.library.restore;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "api/v1/restore")
public class RestoreController {
    
    @Autowired
    private RestoreService restoreService;

    @GetMapping()
    public ResponseEntity<List<Restore>> getAllRestores() {
        return new ResponseEntity<List<Restore>>(restoreService.allRestores(), HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Restore> insertUser(@RequestBody Restore restore) {
        return new ResponseEntity<Restore>(restoreService.newRestore(restore), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Restore> updateRestore(@PathVariable ObjectId id, @RequestBody Restore restore) {
        return new ResponseEntity<Restore>(restoreService.editRestore(restore, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRestore(@PathVariable ObjectId id){ 
        return new ResponseEntity<String>(restoreService.eraseRestore(id), HttpStatus.OK);
    }

}
