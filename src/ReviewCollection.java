import java.util.ArrayList;

public class ReviewCollection
{
    private ArrayList<Review> reviews = new ArrayList<Review>();

    public Review getReviews(int index)
    {
        Review result;

        result = reviews.get(index);

        return result;
    }

    public int reviewCount()
    {
        return reviews.size();
    }

    public void addReview(Review review)
    {
        reviews.add(review);
    }

    public boolean removeReview(Review review)
    {
        boolean ok = true;

        ok = reviews.remove(review);

        return ok;
    }

    public boolean editReview(Review review)
    {
        boolean ok = true;

        return ok;
    }

    public boolean addLike(User user, Review review)
    {
        boolean ok = true;

        return ok;
    }

}
