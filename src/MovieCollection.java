import java.util.ArrayList;

public class MovieCollection
{
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public void initialize()
    {

    }

    public void printMovie()
    {
        for (Movie movie : movies)
        {
            System.out.println(movie.getTitle());
        }
    }

    public ArrayList<Movie> getMovies()
    {
        return movies;
    }
}
