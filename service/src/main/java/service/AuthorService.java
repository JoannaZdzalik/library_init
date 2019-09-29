package service;

import model.Author;
import repository.AuthorRepository;

import java.util.List;

public class AuthorService {

    AuthorRepository authorRepository = new AuthorRepository();
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
