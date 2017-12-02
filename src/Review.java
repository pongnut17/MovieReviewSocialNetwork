import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.TreeSet;

public class Review implements Comparable<Review>
{
    private String owner;
    private String titleReview;
    private ArrayList<String> detail = new ArrayList<String>();
    private TreeSet<String> like = new TreeSet<String>() ;
    private double rating;
    private String reviewedMovie;
    private String submittedDate;

    public Review(String movie, String writer, String title, ArrayList<String> text, double score, String time)
    {
        this.reviewedMovie = movie;
        this.owner = writer;
        this.titleReview = title;
        this.detail = text;
        this.rating = score;
        this.submittedDate = time;
    }


    public int getLikeCount()
    {
        return like.size();
    }

    public boolean addLike(String user)
    {
        like.add(user);
        return true;
    }

    public void printReviewDetail()
    {
        System.out.println("\nReview Title : "+titleReview);
        System.out.println("Movie : "+reviewedMovie);
        System.out.println("Written by: "+owner);
        System.out.println(submittedDate);

        System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
        /* loop for print all lines of detail */
        for (String body : detail)
        {
            System.out.println(body);
        }
        System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -");

        System.out.println("Rating: "+rating);
        System.out.println(getLikeCount() + " likes");


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

    public String getOwner() {
        return owner;
    }

    public String getReviewedMovie()
    {
        return reviewedMovie;
    }

    public String getTitleReview() {
        return titleReview;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    @Override
    public int compareTo(Review o)
    {
        if(this.getSubmittedDate().equalsIgnoreCase(o.getSubmittedDate())) {
            return -this.getOwner().compareTo(o.getOwner());
        }
        else {
            return -this.getSubmittedDate().compareTo(o.getSubmittedDate());
        }
    }

}
