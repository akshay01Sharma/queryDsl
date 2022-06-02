package com.selfLearningProjects.queryDslandJpa.repository;

import com.selfLearningProjects.queryDslandJpa.dto.AuthorStatistic;
import com.selfLearningProjects.queryDslandJpa.entity.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends BaseRepository<Author,Integer> {


    public Optional<Author> findAuthorByEmail(String email);

    public List<AuthorStatistic> getAuthorStatistic();

    public List<Author> getAuthors();
}
