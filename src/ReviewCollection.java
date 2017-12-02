import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.TreeSet;

public class ReviewCollection
{
    private TreeSet<Review> reviews = new TreeSet<Review>();


    public void initialize()
    {

        ArrayList<String> textA = new ArrayList<String>();
        textA.add("Best movie ever");
        textA.add("JK..  :p");

        Review A = new Review("Titanic","pongnut18","Good Ship",textA,2.05,"2017-12-01 23:51:01");

        ArrayList<String> textB = new ArrayList<String>();
        textB.add("I love this ");
        textB.add("repeat and repeat");
        textB.add("GG WP");

        Review B = new Review("Avatar","boss32734","Why actor so tall",textB,5.00,"2017-10-07 20:51:01");

        ArrayList<String> textC = new ArrayList<String>();
        textC.add("just test ei ei ");

        Review C = new Review("Titanic","testUser","OMG WTF",textC,1.80,"2015-09-02 08:18:08");


        ArrayList<String> textD = new ArrayList<String>();
        textD.add("No thing");
        textD.add("Ok bye");

        Review D = new Review("Avatar","boss32734","HAHAHAHA HAHAHAH WTF",textD,4.24,"2017-10-07 22:54:42");

        ArrayList<String> textE = new ArrayList<String>();
        textE.add("just test ei ei ");
        textE.add("ei ei ");
        textE.add("ei ei ");
        textE.add("ei ei ");

        Review E = new Review("Conan The Movie: Who is Ironman","boss32734","IDK who is Ironman",textE,2.22,"2015-09-02 08:18:08");



        reviews.add(A);
        reviews.add(B);
        reviews.add(C);
        reviews.add(D);
        reviews.add(E);

    }


    public ArrayList<Review> getAllReviewsByUser(String name)
    {
        ArrayList<Review> reviewsTitles = new ArrayList<Review>();

        for (Review currentReview : reviews)
        {
            if (currentReview.getOwner().equals(name))
            {
                reviewsTitles.add(currentReview);
            }
        }
        return reviewsTitles;
    }

    public void likeReview(String liker,Review review)
    {
        for (Review currentReview : reviews)
        {
            if (currentReview.equals(review))
            {
               currentReview.addLike(liker);
            }
        }
    }

    public TreeSet<Review> getAllReviews() {
        return reviews;
    }

    public Review getReviews(Review theReview)
    {
        return theReview;
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

        ok =  reviews.remove(review);

        return ok;
    }

    public boolean editReview(Review review)
    {
        boolean ok = true;

        return ok;
    }

}
