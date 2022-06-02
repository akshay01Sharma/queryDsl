package com.selfLearningProjects.queryDslandJpa.repository.impl;

import com.selfLearningProjects.queryDslandJpa.entity.Book;
import com.selfLearningProjects.queryDslandJpa.repository.BookRepository;

import javax.persistence.EntityManager;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book,Integer> implements BookRepository {


    public BookRepositoryImpl( EntityManager em) {
        super(Book.class, em);
    }
}
