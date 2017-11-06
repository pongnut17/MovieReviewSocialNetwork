import java.util.ArrayList;

public class Movie
{

    private String title;
    private int year;
    private ArrayList<String> genre = new ArrayList<String>();
    private ReviewCollection movieReview;

    public Movie (String t, int y, ArrayList<String> gen)
    {
        this.title = t;
        this.year = y;
        this.genre = gen;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    public ArrayList<String> getGenre()
    {
        return genre;
    }

    public boolean addReview(Review review)
    {

        return true;
    }






}
