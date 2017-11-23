package com.example.ryan.moviedbapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ryan.moviedbapi.model.MoviesListModel.Result;

import java.util.List;

/**
 * Created by Ryan on 23/11/2017.
 */

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private List<Result> movies;
    private int row_movies;
    private Context applicationContext;

    public ViewAdapter(List<Result> movies, int row_movies, Context applicationContext) {
        this.movies = movies;
        this.row_movies = row_movies;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(row_movies, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.id.setText(movies.get(position).getId().toString());
        holder.title.setText(movies.get(position).getTitle());
        holder.overview.setText(movies.get(position).getOverview());
        holder.releaseDate.setText(movies.get(position).getReleaseDate());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id, title, overview, releaseDate;

        public MyViewHolder(View itemView) {
            super(itemView);


            id = (TextView) itemView.findViewById(R.id.tvID);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            overview = (TextView) itemView.findViewById(R.id.tvOverview);
            releaseDate = (TextView) itemView.findViewById(R.id.tvReleaseDate);

        }
    }

}
