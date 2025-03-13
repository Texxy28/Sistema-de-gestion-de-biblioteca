package com.wil.library.loan;

import java.util.List;

// import com.wil.library.book.BookRepository;
// import com.wil.library.users.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    // @Autowired
    // private BookRepository bookRepository;

    // @Autowired
    // private UserRepository userRepository;
    
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Loan> allLoans() {
        
        // List<Loan> loans = loanRepository.findAll(); // 1 consulta

        // for (Loan loan : loans) {
        //     loan.setUser(userRepository.findById(loan.getIdUser()).orElse(null)); // 1 consulta por préstamo
        //     loan.setBook(bookRepository.findById(loan.getIdBook()).orElse(null)); // 1 consulta por préstamo
        // }
    
        // return loans;

        return loanRepository.findAll();

    }

    public Loan newLoan(Loan loan) {
        return loanRepository.insert(loan);
    }

    public Loan editLoan(Loan loan, ObjectId id) {
        
        Query query = new Query(Criteria.where("_id").is(id));
        
        Update update = new Update()
        .set("idUser", loan.getIdUser())
        .set("idBook", loan.getIdBook())
        .set("returnDate", loan.getReturnDate())
        .set("state", loan.getState());

        return mongoTemplate.findAndModify(query, update, Loan.class);

    }

    public String eraseLoan(ObjectId id) { 
        loanRepository.deleteById(id);
        return "Borrado";
    }

}
