package com.example.ryan.moviedbapi.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.moviedbapi.R;
import com.example.ryan.moviedbapi.ViewAdapter;
import com.example.ryan.moviedbapi.model.MoviesListModel.Result;
import com.example.ryan.moviedbapi.model.MoviesListModel.TopRatedMovieList;
import com.example.ryan.moviedbapi.services.RequestInterface;
import com.example.ryan.moviedbapi.services.ServerConnection;
import com.example.ryan.moviedbapi.util.API_List;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesList extends Fragment {


    RequestInterface requestInterface;
    CompositeDisposable compositeDisposable;
    private List<Result> results;
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;

    public MoviesList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        requestInterface = ServerConnection.BackendService();
        compositeDisposable = new CompositeDisposable();

        requestInterface = ServerConnection.BackendService();

        requestInterface.getTopRatedMovieList(API_List.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<TopRatedMovieList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopRatedMovieList topRatedMovieList) {

                        results = new ArrayList<>(topRatedMovieList.getResults());

                        Log.i("movies", String.valueOf(results.size()));
                        initializeRecyclerView();

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false);

    }

    public void initializeRecyclerView() {

         recyclerView = (RecyclerView) getView().findViewById(R.id.rvMoviesList);
         recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

         viewAdapter = new ViewAdapter(results, R.layout.row, getActivity().getApplicationContext());

         recyclerView.setAdapter(viewAdapter);
    }

}
