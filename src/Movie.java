/**
 * Movie.java
 *
 * Simple class representing a movie object.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;

public class Movie
{
    private ArrayList<String> genres;
    private String title;
    private int year;

    public Movie(String title, int year, ArrayList<String> genres)
    {
        this.title = title;
        this.year = year;
        this.genres = genres;
    }

    /**
     * Get genres for movie.
     *
     * @return genres of movie
     */
    public ArrayList<String> getGenres()
    {
        return genres;
    }

    /**
     * Get title for movie.
     *
     * @return title name of movie
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Get year for movie.
     *
     * @return year of movie
     */
    public int getYear()
    {
        return year;
    }
}