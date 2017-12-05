/**
 * ReviewCollection.java
 *
 * A ReviewCollection is a group of reviews.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;

public class ReviewCollection
{
    private ArrayList<Review> reviews = new ArrayList<>();

    /**
     * Add review to ArrayList<Review>.
     *
     * @param review new Review to add
     * @return true, unless it can't add
     */
    public boolean addReview(Review review)
    {
        return reviews.add(review);
    }

    /**
     * Add like to specific review.
     *
     * @param liker  string of username
     * @param review Review object
     */
    public void likeReview(String liker, Review review)
    {
        for (Review currentReview : reviews)
        {
            if (currentReview.equals(review))
            {
                currentReview.addLike(liker);
            }
        }
    }

    /**
     * Remove review from ArrayList<String>.
     *
     * @param review Review object to remove
     */
    public boolean removeReview(Review review)
    {
        return reviews.remove(review);
    }

    /**
     * Get reviews that contains by specific username.
     *
     * @param username username to find
     */
    public ArrayList<Review> getAllReviewsByUser(String username)
    {
        ArrayList<Review> reviewsTitles = new ArrayList<>();

        for (Review currentReview : reviews)
        {
            if (currentReview.getOwner().equals(username))
            {
                reviewsTitles.add(currentReview);
            }
        }
        return reviewsTitles;
    }

    /**
     * Get review by object.
     *
     * @param review Review to find
     * @return Review, unless null when not found
     */
    public Review getReview(Review review)
    {
        if (reviews.contains(review))
        {
            return review;
        }
        else
        {
            return null;
        }
    }

    /**
     * Get all reviews in ArrayList<Review>
     *
     * @return ArrayList<Review> all reviews
     */
    public ArrayList<Review> getAllReviews()
    {
        return reviews;
    }

    /**
     * Get reviews count.
     */
    public int getReviewCount()
    {
        return reviews.size();
    }
}