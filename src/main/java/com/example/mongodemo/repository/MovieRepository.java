package com.example.mongodemo.repository;

import com.example.mongodemo.model.Movie;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findMovieByTitleContains(String title);

}