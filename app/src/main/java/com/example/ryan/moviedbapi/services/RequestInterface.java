package com.example.ryan.moviedbapi.services;

import com.example.ryan.moviedbapi.model.MoviesListModel.TopRatedMovieList;
import com.example.ryan.moviedbapi.model.MovieDetailsModel.TopRatedMovieListDetails;
import com.example.ryan.moviedbapi.util.API_List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ryan on 23/11/2017.
 */

public interface RequestInterface {

    @GET(API_List.TOP_RATED_MOVE_LIST)
    Observable<TopRatedMovieList>getTopRatedMovieList(@Query("api_key") String apikey);

    @GET(API_List.TOP_RATED_MOVIE_DETAIL)
    Observable<TopRatedMovieListDetails> getTopRatedMovieListDetails(@Path("id") int id, @Query("api_key") String apiKey );
}
