package com.example.myapplication;
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView, yearTextView, genreTextView;
        private ImageView posterImageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            genreTextView = itemView.findViewById(R.id.genreTextView);
            posterImageView = itemView.findViewById(R.id.posterImageView);
        }

        public void bind(Movie movie) {
            titleTextView.setText(movie.getTitle() != null ? movie.getTitle() : "Unknown Title");
            yearTextView.setText(String.valueOf(movie.getYear()));
            genreTextView.setText(movie.getGenre());

            int resId = itemView.getContext().getResources().getIdentifier(
                    movie.getPosterResource(), "drawable", itemView.getContext().getPackageName());
            posterImageView.setImageResource(resId != 0 ? resId : R.drawable.default_poster);
        }
    }
}

