import java.util.ArrayList;
import java.util.Date;

public class Review
{
    private User owner;
    private String titleReview;
    private ArrayList<String> detail = new ArrayList<String>();
    private UserCollection liker;
    private float rating;
    private Movie reviewedMovie;
    private Date submitedDate;

    public Review(Movie movie, User writer, String title, ArrayList<String> text, float score, Date time)
    {
        this.reviewedMovie = movie;
        this.owner = writer;
        this.titleReview = title;
        this.detail = text;
        this.rating = score;
        this.submitedDate = time;

    }

    public int getLikeCount()
    {
        int count = 0;

        return count;
    }

    public boolean addLike(User user)
    {

        return true;
    }

    public void setTitleReview(String titleReview) {
        this.titleReview = titleReview;
    }

    public void setDetail(ArrayList<String> detail) {
        this.detail = detail;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public User getOwner() {
        return owner;
    }

    public String getTitleReview() {
        return titleReview;
    }
}
