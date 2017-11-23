package com.example.ryan.moviedbapi;

import android.graphics.Movie;
import android.support.annotation.MainThread;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ryan.moviedbapi.model.MoviesListModel.Result;
import com.example.ryan.moviedbapi.model.MoviesListModel.TopRatedMovieList;
import com.example.ryan.moviedbapi.services.RequestInterface;
import com.example.ryan.moviedbapi.services.ServerConnection;
import com.example.ryan.moviedbapi.util.API_List;
import com.example.ryan.moviedbapi.views.MoviesList;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        fragmentManager = getSupportFragmentManager();

        if(savedInstanceState==null){
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new MoviesList())
                    .commit();
        }
    }
}
