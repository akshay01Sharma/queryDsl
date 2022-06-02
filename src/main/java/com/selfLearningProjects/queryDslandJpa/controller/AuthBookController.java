package com.selfLearningProjects.queryDslandJpa.controller;


import com.selfLearningProjects.queryDslandJpa.dto.AuthorStatistic;
import com.selfLearningProjects.queryDslandJpa.entity.Author;
import com.selfLearningProjects.queryDslandJpa.entity.Book;
import com.selfLearningProjects.queryDslandJpa.service.AuthBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AuthBookController {

    @Autowired
    private AuthBookService authBookService;


    @PostMapping("/authors/book")
    public List<Author> saveAuthorsWithBooks(@RequestBody List<Author> authors) {
        System.out.println("Hello In API");
        return authBookService.saveAuthorsWithBooks(authors);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authBookService.getAuthors();
    }

    @GetMapping("/books")
    public List<Book> getALlBooks() {
        return authBookService.getBooks();
    }

    @GetMapping("/author/{email}")
    public Optional<Author> findAuthorByEmail(@PathVariable String email) {
        return authBookService.findAuthorByEmail(email);
    }

    @GetMapping("/authorStatistic")
    public List<AuthorStatistic> getAuthorStatistic() {
        return authBookService.getAuthorStatistic();
    }

    //to avoid N+1 problem in hibernate/jpa
    @GetMapping("/authors/fetchJoin")
    public List<Author> getAuthorsWithFetchJoin() {


        return authBookService.getAuthorsWithFetchJoin();
    }
}
