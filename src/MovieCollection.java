import java.util.ArrayList;

public class MovieCollection
{
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public void initialize()
    {
        ArrayList<String> genreMovieA = new ArrayList<String>();
        genreMovieA.add("Comedy");
        Movie A = new Movie("Titanic", 1997, genreMovieA);

        ArrayList<String> genreMovieB = new ArrayList<String>();
        genreMovieB.add("Comedy");
        genreMovieB.add("Action");
        genreMovieB.add("Adventure");
        genreMovieB.add("Animation");
        Movie B = new Movie("Avatar", 2009, genreMovieB);

        ArrayList<String> genreMovieC = new ArrayList<String>();
        genreMovieC.add("Action");
        genreMovieC.add("Crime");
        genreMovieC.add("Animation");
        Movie C = new Movie("Conan The Movie: Who is Ironman", 2008, genreMovieC);

        movies.add(A);
        movies.add(B);
        movies.add(C);
    }

    public void printMovie()
    {
        for (Movie movie : movies)
        {
            System.out.println(movie.getTitle());
        }
    }

    public Movie getMovies(String title, int year)
    {
        Movie targetMovie = new Movie(null, 0, null);

        for (Movie currentMovie : movies)
        {
            if (currentMovie.getTitle().equalsIgnoreCase(title) && currentMovie.getYear() == year)
            {
                targetMovie = currentMovie;
            }
        }
        return targetMovie;
    }

    public Movie getMovies(Movie OKmovie)
    {
        Movie targetMovie = new Movie(null, 0, null);

        for (Movie currentMovie : movies)
        {
            if (currentMovie.getTitle().equalsIgnoreCase(OKmovie.getTitle()) && currentMovie.getYear() == OKmovie.getYear())
            {
                targetMovie = currentMovie;
            }
        }
        return targetMovie;
    }
}