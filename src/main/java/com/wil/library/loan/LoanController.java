package com.wil.library.loan;

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
@RequestMapping(path = "api/v1/loan")
public class LoanController {
    
    @Autowired
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<List<Loan>>(loanService.allLoans(), HttpStatus.OK);
    }
    
    @PostMapping("/insert")
    public ResponseEntity<Loan> insertUser(@RequestBody Loan loan) {
        return new ResponseEntity<Loan>(loanService.newLoan(loan), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Loan> updateUser(@PathVariable ObjectId id, @RequestBody Loan loan) {
        return new ResponseEntity<Loan>(loanService.editLoan(loan, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ObjectId id){ 
        return new ResponseEntity<String>(loanService.eraseLoan(id), HttpStatus.OK);
    }

}
