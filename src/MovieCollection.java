/**
 * MovieCollection.java
 *
 * A MovieCollection is a group of movies.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;

public class MovieCollection
{
    private ArrayList<Movie> movies = new ArrayList<>();

    /**
     * Add movie to the array
     *
     * @return true, unless can't add to ArrayList
     */
    public boolean addMovie(Movie newMovie)
    {
        return !movies.contains(newMovie) && movies.add(newMovie);
    }

    /**
     * Get movie from ArrayList<List>
     *
     * @return Movie object, unless null if it's not found.
     */
    public Movie getMovie(String title, int year)
    {
        Movie targetMovie = null;
        for (Movie currentMovie : movies)
        {
            if (currentMovie.getTitle().equalsIgnoreCase(title) && currentMovie.getYear() == year)
            {
                targetMovie = currentMovie;
            }
        }
        return targetMovie;
    }

    /**
     * Get ArrayList<List> of movies.
     *
     * @return ArrayList<List> of movies
     */
    public ArrayList<Movie> getAllMovies()
    {
        return movies;
    }

    /**
     * Get size of movies.
     *
     * @return movies size
     */
    public int getTotalMovies()
    {
        return movies.size();
    }
}