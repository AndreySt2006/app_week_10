package com.example.myapplication;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView movieRecyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadMovieData();
    }

    private void loadMovieData() {
        List<Movie> movies = JsonUtils.loadMoviesFromJson(this);
        if (movies.isEmpty()) {
            showError("Failed to load movies.");
        } else {
            adapter = new MovieAdapter(movies);
            movieRecyclerView.setAdapter(adapter);
        }
    }

    private void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
