/**
 * Review.java
 *
 * Simple class representing a review object.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;
import java.util.Date;

public class Review implements Comparable<Review>
{
    private ArrayList<String> body;
    private Date date;
    private ArrayList<String> likes;
    private String movieTitle;
    private int movieYear;
    private String owner;
    private double rating;
    private String titleReview;

    public Review(String movieTitle, int movieYear, double rating, String owner, String title, ArrayList<String> body, Date date)
    {
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.rating = rating;
        this.owner = owner;
        this.titleReview = title;
        this.body = body;
        this.date = date;
        likes = new ArrayList<>();
    }

    /**
     * Add new like to ArrayList<String>
     *
     * @return true, unless incorrect user.
     */
    public void addLike(String likedUser)
    {
        try
        {
            likes.add(likedUser);
        }
        catch (NullPointerException e)
        {

        }
    }

    /**
     * Remove like to UserCollection.
     *
     * @return true, unless incorrect user.
     */
    public boolean removeLike(String unlikedUser)
    {
        return likes.remove(unlikedUser);
    }

    /**
     * Get date of review.
     *
     * @return date of review
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * Get owner of review.
     *
     * @return owner of review
     */
    public String getOwner()
    {
        return owner;
    }

    /**
     * Get total liked of review.
     *
     * @return total liked of review
     */
    public int getLikedCount()
    {
        return likes.size();
    }

    /**
     * Get body of review.
     *
     * @return body of review
     */
    public ArrayList<String> getBody()
    {
        return body;
    }

    /**
     * Get all users who like review.
     *
     * @return UserCollection who like review
     */
    public ArrayList<String> getUserLikes()
    {
        return likes;
    }

    /**
     * Get rating of review.
     *
     * @return rating of review
     */
    public double getRating()
    {
        return rating;
    }

    /**
     * Get movie name of review.
     *
     * @return movie name of review
     */
    public String getReviewedMovieName()
    {
        return movieTitle;
    }

    /**
     * Get movie year of review.
     *
     * @return movie year of review
     */
    public int getReviewedMovieYear()
    {
        return movieYear;
    }

    /**
     * Get title for review.
     *
     * @return title name of review
     */
    public String getTitleReview()
    {
        return titleReview;
    }

    /**
     * Set body for review.
     */
    public void setBody(ArrayList<String> body)
    {
        this.body = body;
    }

    /**
     * Set date for review.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Set rating for review.
     */
    public void setRating(double rating)
    {
        this.rating = rating;
    }

    /**
     * Set title for review.
     */
    public void setTitleReview(String title)
    {
        titleReview = title;
    }

    @Override
    public int compareTo(Review o)
    {
        if (this.getDate().equals(o.getDate()))
        {
            return -this.getOwner().compareTo(o.getOwner());
        }
        else
        {
            return -this.getDate().compareTo(o.getDate());
        }
    }
}