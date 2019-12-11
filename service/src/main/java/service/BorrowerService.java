package service;

import dtos.BorrowerDto;
import model.Borrower;
import repository.BorrowerRepository;

import java.util.List;

public class BorrowerService {

    BorrowerRepository borrowerRepository = new BorrowerRepository();

    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

}
