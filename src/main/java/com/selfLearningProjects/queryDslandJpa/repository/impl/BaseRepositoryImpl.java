package com.selfLearningProjects.queryDslandJpa.repository.impl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.selfLearningProjects.queryDslandJpa.entity.QAuthor;
import com.selfLearningProjects.queryDslandJpa.entity.QBook;
import com.selfLearningProjects.queryDslandJpa.repository.BaseRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {

    EntityManager em;
    JPAQueryFactory jpaQueryFactory;

    protected  final QAuthor author= QAuthor.author;
    protected  final QBook book= QBook.book;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em=em;
        this.jpaQueryFactory=new JPAQueryFactory(em);
    }

   
    public T findByIdMandatory(ID id) throws IllegalArgumentException {
        return findById(id)
                .orElseThrow(()->new IllegalArgumentException("entity not found with id "+id));
    }
}
