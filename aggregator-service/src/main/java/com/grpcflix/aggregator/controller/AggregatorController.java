package com.grpcflix.aggregator.controller;

import com.grpcflix.aggregator.dto.RecommendedMovie;
import com.grpcflix.aggregator.dto.UserGenre;
import com.grpcflix.aggregator.service.UserMovieService;
import com.vinsguru.grpcflix.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AggregatorController {
    @Autowired
    private UserMovieService userMovieService;

    @GetMapping("user/{loginId}")
    public List<RecommendedMovie> getMovies(@PathVariable String loginId){
        return this.userMovieService.getUserMovieSuggestion(loginId);
    }

    @PutMapping("/user")
    public UserResponse setUserGenre(@RequestBody UserGenre userGenre){
        return this.userMovieService.setUserGenre(userGenre);
    }
}
