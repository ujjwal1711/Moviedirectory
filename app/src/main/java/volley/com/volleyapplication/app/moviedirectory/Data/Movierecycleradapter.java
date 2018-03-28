package volley.com.volleyapplication.app.moviedirectory.Data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import volley.com.volleyapplication.app.moviedirectory.Activities.MovieDetailActivity;
import volley.com.volleyapplication.app.moviedirectory.Model.Movie;
import volley.com.volleyapplication.app.moviedirectory.R;

/**
 * Created by UjjwalNUtsav on 25-03-2018.
 */

public class Movierecycleradapter extends RecyclerView.Adapter<Movierecycleradapter.ViewHolder> {
    private Context context;
    private List<Movie> movielist;
    public Movierecycleradapter(Context context, List <Movie> movies) {
        this.context=context;
        movielist = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_row,parent,false);
        return new ViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = movielist.get(position);



        String posterLink =  movie.getPoster();

        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getMovieType());

        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);

        holder.year.setText(movie.getYear());


    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }



    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView poster;
        TextView year;
        TextView type;


        public ViewHolder(View itemView, final Context ctx) {
            super(itemView);
            context = ctx;

            title = (TextView) itemView.findViewById(R.id.movieTitleId);
            poster = (ImageView) itemView.findViewById(R.id.movieimageid);
            year = (TextView) itemView.findViewById(R.id.moviereleaseId);
            type = (TextView) itemView.findViewById(R.id.moviecatid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Movie movie = movielist.get(getAdapterPosition());

                  Intent intent = new Intent(context,MovieDetailActivity.class);

                    intent.putExtra("movie", movie);
                    ctx.startActivity(intent);


                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }
}
