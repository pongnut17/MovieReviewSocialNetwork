/**
 * MovieReviewSocialNetwork.java
 *
 * Main class of this program.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

public class MovieReviewSocialNetwork
{
    private static final String moviesFileName = "allmovies.txt";
    private static final String reviewsFileName = "allreviews.txt";
    private static User loginUser = null;
    private static MovieCollection moviesDb = new MovieCollection();
    private static ReviewCollection reviewsDb = new ReviewCollection();

    /**
     * Initialize all movies in program.
     */
    public static void initializeMovie()
    {
        MovieFileReader reader = new MovieFileReader();
        if (!reader.open(moviesFileName))
        {
            System.out.println("Error opening tile file " + moviesFileName + " in MovieReviewSocialNetwork:initializeMovie()");
            System.exit(0);
        }
        Movie nextMovie;
        while ((nextMovie = reader.getMovie()) != null)
        {
            boolean bOk = moviesDb.addMovie(nextMovie);
            if (bOk)
            {
                System.out.println("Successfully added " + nextMovie);
            }
            else
            {
                System.out.println("Error adding " + nextMovie);
            }
        }
        System.out.println("Movies Database initialized");
    }

    /**
     * Initialize all reviews in program.
     */
    public static void initializeReview()
    {
        ReviewFileReader reader = new ReviewFileReader();
        if (!reader.open(reviewsFileName))
        {
            System.out.println("Error opening tile file " + reviewsFileName + " in MovieReviewSocialNetwork:initializeReview()");
            System.exit(0);
        }
        Review nextReview;
        while ((nextReview = reader.getReview()) != null)
        {
            boolean bOk = reviewsDb.addReview(nextReview);
            if (bOk)
            {
                System.out.println("Successfully added " + nextReview);
            }
            else
            {
                System.out.println("Error adding " + nextReview);
            }
        }
        System.out.println("Reviews Database initialized");
    }

    /**
     * Save all reviews to file
     */
    public static void saveReviews()
    {
        try
        {
            FileWriter movieUpdate = new FileWriter("review.txt");
            for (Review theReview : reviewsDb.getAllReviews())
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = formatter.format(theReview.getDate());
                movieUpdate.write(date.replaceAll("\\s+", "_"));
                movieUpdate.write(" ");
                movieUpdate.write(theReview.getOwner());
                movieUpdate.write(" ");
                movieUpdate.write(theReview.getReviewedMovieName().replaceAll("\\s+", "_"));
                movieUpdate.write(" ");
                movieUpdate.write(Double.toString(theReview.getRating()));
                movieUpdate.write(" ");
                if (theReview.getLikedCount() == 0)
                {
                    movieUpdate.write("-");
                }
                else
                {
                    for (String like : theReview.getUserLikes())
                    {
                        movieUpdate.write(like);
                        if (!like.equals(theReview.getUserLikes().get(theReview.getUserLikes().size() - 1)))
                        {
                            movieUpdate.write(",");
                        }
                    }
                }
                movieUpdate.write(" ");
                for (String body : theReview.getBody())
                {
                    movieUpdate.write(body.replaceAll("\\s+", "_"));
                    if (!body.equals(theReview.getBody().get(theReview.getBody().size() - 1)))
                    {
                        movieUpdate.write(",");
                    }
                }
                movieUpdate.write(" ");
                movieUpdate.write("\n");
            }
            movieUpdate.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Save all movies to file
     */
    public static void saveUsers()
    {
        try
        {
            FileWriter userUpdate = new FileWriter("user.txt");
            for (User theuser : UserManager.getAllUsers().getUsers())
            {
                userUpdate.write(theuser.getEmail());
                userUpdate.write(" ");
                userUpdate.write(theuser.getPassword());
                userUpdate.write(" ");
                userUpdate.write(theuser.getUsername());
                userUpdate.write(" ");
                if (theuser.getFavoriteGenres().size() == 0)
                {
                    userUpdate.write("-");
                }
                for (String gen : theuser.getFavoriteGenres())
                {
                    userUpdate.write(gen);
                    if (!gen.equals(theuser.getFavoriteGenres().get(theuser.getFavoriteGenres().size() - 1)))
                    {
                        userUpdate.write(",");
                    }
                }
                userUpdate.write(" ");
                if (theuser.getFollowing().size() == 0)
                {
                    userUpdate.write("-");
                }
                for (String person : theuser.getFollowing())
                {
                    userUpdate.write(person);
                    if (!person.equals(theuser.getFollowing().get(theuser.getFollowing().size() - 1)))
                    {
                        userUpdate.write(",");
                    }
                }
                userUpdate.write("\n");
            }
            userUpdate.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Welcome splash.
     */
    private void welcome()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println(" -----------------  -----------------  -----------------  ------       -----");
        System.out.println(" |               |  |               |  |               |  |    \\       |   |");
        System.out.println(" |   ---   ---   |  |   ---------   |  |    ------------  |     \\      |   |");
        System.out.println(" |   | |   | |   |  |   |       |   |  |    |             |      \\     |   |");
        System.out.println(" |   | |   | |   |  |   ---------   |  |    ------------  |       \\    |   |");
        System.out.println(" |   | |   | |   |  |               |  |               |  |        \\   |   |");
        System.out.println(" |   | |   | |   |  |   |\\   \\-------  -----------     |  |   |\\    \\  |   |");
        System.out.println(" |   | |   | |   |  |   | \\   \\                  |     |  |   | \\    \\ |   |");
        System.out.println(" |   | |   | |   |  |   |  \\   \\                 |     |  |   |  \\    \\|   |");
        System.out.println(" |   | |   | |   |  |   |   \\   \\                |     |  |   |   \\        |");
        System.out.println(" |   | |   | |   |  |   |    \\   \\     -----------     |  |   |    \\       |");
        System.out.println(" |   | |   | |   |  |   |     \\   \\    |               |  |   |     \\      |");
        System.out.println(" |   | |   | |   |  |   |      \\   \\   |               |  |   |      \\     |");
        System.out.println(" ----- ----- -----  -----       -----  -----------------  -----       ------");
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * Ask username and add following to user.
     */
    public void addFollow()
    {
        String targetUser = IOUtils.getString("Username of user who you want to follow: ");
        loginUser.addFollowing(targetUser);
    }

    /**
     * Ask username and delete following to user.
     */
    public void deleteFollow()
    {
        String targetUser = IOUtils.getString("Username of user who you want to delete: ");
        loginUser.removeFollowing(targetUser);
    }

    /**
     * Ask which review to delete from user.
     */
    public void deleteUI()
    {
        ArrayList<Review> reviews = reviewsDb.getAllReviewsByUser(loginUser.getUsername());
        int i = 1;
        int select = 0;
        System.out.println("\nYour reviews:");
        for (Review currentReview : reviews)
        {
            System.out.println(" (" + i + ") " + currentReview.getTitleReview() + " - " + currentReview.getReviewedMovieName() + " (" + currentReview.getReviewedMovieYear() + ")");
            i++;
        }
        while (true)
        {
            select = IOUtils.getInteger("\nWhich one do you want to Delete?: ");
            if (select > 0 && select < i)
            {
                reviewsDb.removeReview(reviews.get(select - 1));
                break;
            }
            else
            {
                System.out.println("!!! Invalid number !!!");
            }
        }
    }

    /**
     * Ask to edit or delete.
     */
    public void editOrDelete()
    {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("- Edit or delete ------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        int choice;
        while (true)
        {
            choice = IOUtils.getInteger("(1) Edit or (2) Delete?: ");
            if (choice == 1 || choice == 2)
            {
                break;
            }
            else
            {
                System.out.println("!!! Invalid choice !!!");
            }
        }

        if (choice == 1)
        {
            editUI();
        }
        else
        {
            deleteUI();
        }
    }

    /**
     * Ask to select which one to edit a review.
     */
    public void editUI()
    {
        ArrayList<Review> reviews = reviewsDb.getAllReviewsByUser(loginUser.getUsername());
        int i = 1;
        int select = 0;
        System.out.println("\nYour reviews:");
        for (Review currentReview : reviews)
        {
            System.out.println(" (" + i + ") " + currentReview.getTitleReview() + " - " + currentReview.getReviewedMovieName() + " (" + currentReview.getReviewedMovieYear() + ")");
            i++;
        }
        while (true)
        {
            select = IOUtils.getInteger("\nWhich one do you want to Edit?: ");
            if (select > 0 && select < i)
            {
                printReviewDetail(reviewsDb.getReview(reviews.get(select - 1)));
                break;
            }
            else
            {
                System.out.println("!!! Invalid number !!!");
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        int Eselect = IOUtils.getInteger("\n (1) Title\n (2) Details\n (3) Rating\nWhich part?: ");
        switch (Eselect)
        {
            case 1:
                String nameReview = IOUtils.getString("\n>> New Title of Review : ");
                reviewsDb.getReview(reviews.get(select - 1)).setTitleReview(nameReview);
                break;
            case 2:
                ArrayList<String> bodies = new ArrayList<>();
                System.out.println("\n>> Enter new review detail below. (END to finish): ");
                while (true)
                {
                    String line = IOUtils.getBareString();
                    if (line.compareTo("END") == 0)
                    {
                        break;
                    }
                    bodies.add(line);
                }
                reviewsDb.getReview(reviews.get(select - 1)).setBody(bodies);
                break;
            case 3:
                double rate = IOUtils.getFloat("\n>> New Rating (0 - 10): ");
                reviewsDb.getReview(reviews.get(select - 1)).setRating(Double.parseDouble(new DecimalFormat("##.#").format(rate)));
                break;
        }
    }

    /**
     * Find review by date range.
     */
    public void findByDate()
    {
        System.out.println("Enter Range Date Format (yyyy-MM-dd)");
        String after = IOUtils.getString("After : ");
        String before = IOUtils.getString("Before : ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try
        {
            date1 = format.parse(after);
            date2 = format.parse(before);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        for (Review theReview : reviewsDb.getAllReviews())
        {
            Date ReviewDate = theReview.getDate();

            if (ReviewDate.compareTo(date1) <= 0 && ReviewDate.compareTo(date2) > 0)
            {
                printReviewDetail(theReview);
            }
            System.out.println("-----------------------------------------------------------------------------");
            String YesNo = IOUtils.getString(">> Like?(Y/N): ");
            if (YesNo.equalsIgnoreCase("Y"))
            {
                reviewsDb.likeReview(loginUser.getUsername(), theReview);
            }
        }
    }

    /**
     * Find review by genre.
     */
    public void findByGenre()
    {
        String MovieGenre = IOUtils.getString("Enter Genre: ");
        for (Review theReview : reviewsDb.getAllReviews())
        {
            try
            {
                if (moviesDb.getMovie(theReview.getReviewedMovieName(), theReview.getReviewedMovieYear()).getGenres().contains(MovieGenre))
                {
                    printReviewDetail(theReview);
                    System.out.println("-----------------------------------------------------------------------------");
                    String YesNo = IOUtils.getString(">> Like?(Y/N): ");
                    if (YesNo.equalsIgnoreCase("Y"))
                    {
                        reviewsDb.likeReview(loginUser.getUsername(), theReview);
                    }
                }
            }
            catch (NullPointerException e)
            {

            }
        }
    }

    /**
     * Find review by movie name.
     */
    public void findByName()
    {
        String MovieName = IOUtils.getString("Enter movie name: ");
        for (Review theReview : reviewsDb.getAllReviews())
        {
            if (theReview.getReviewedMovieName().equalsIgnoreCase(MovieName))
            {
                printReviewDetail(theReview);
                System.out.println("-----------------------------------------------------------------------------");
                String YesNo = IOUtils.getString(">> Like?(Y/N): ");
                if (YesNo.equalsIgnoreCase("Y"))
                {
                    reviewsDb.likeReview(loginUser.getUsername(), theReview);
                }
            }
        }
    }

    /**
     * Find review by username.
     */
    public void findByUser()
    {
        String UserName = IOUtils.getString("Enter username: ");
        for (Review theReview : reviewsDb.getAllReviews())
        {
            if (theReview.getOwner().equals(UserName))
            {
                printReviewDetail(theReview);
                System.out.println("-----------------------------------------------------------------------------");
                String YesNo = IOUtils.getString(">> Like?(Y/N): ");
                if (YesNo.equalsIgnoreCase("Y"))
                {
                    reviewsDb.likeReview(loginUser.getUsername(), theReview);
                }
            }
        }
    }

    /**
     * Ask which one to use for finding a review.
     */
    public void findReview()
    {
        int select = IOUtils.getInteger("\n (1) Movie name\n (2) Movie genre\n (3) Review date \n (4) User\nWhich one to find?: ");
        switch (select)
        {
            case 1:
                findByName();
                break;
            case 2:
                findByGenre();
                break;
            case 3:
                findByDate();
                break;
            case 4:
                findByUser();
                break;
        }
    }

    /**
     * Ask which to do for following list.
     */
    public void manageFollowList()
    {
        int select = IOUtils.getInteger("\n (1) See your following list\n (2) Follow some user \n (3) Delete someone in your following list\nWhat do you want to do?: ");
        switch (select)
        {
            case 1:
                int i = 1;
                System.out.println("\nYour followings:");
                for (String curFollowing : loginUser.getFollowing())
                {
                    System.out.println(" (" + i + ") " + curFollowing);
                    i++;
                }
                String YesNo = IOUtils.getString("Do you want to do something with this?(Y/N) :");
                if (YesNo.equalsIgnoreCase("Y"))
                {
                    manageFollowList();
                }
                break;
            case 2:
                addFollow();
                break;
            case 3:
                deleteFollow();
                break;
        }
    }

    /**
     * Print all information of a review.
     */
    public void printReviewDetail(Review printReview)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Review Title: " + printReview.getTitleReview());
        System.out.println("Movie: " + printReview.getReviewedMovieName() + " (" + printReview.getReviewedMovieYear() + ")");
        System.out.println("Rating: " + printReview.getRating());
        System.out.println("Written by: " + printReview.getOwner());
        System.out.println(printReview.getDate());
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        for (String currentLine : printReview.getBody())
        {
            System.out.println(currentLine);
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Likes: " + printReview.getLikedCount());
    }

    /**
     * Print all review in your timeline.
     */
    public void seeTimeline()
    {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("- Timeline ------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        for (Review currentReview : reviewsDb.getAllReviews())
        {
            if (loginUser.getFollowing().contains(currentReview.getOwner()))
            {
                printReviewDetail(currentReview);
                System.out.println("-----------------------------------------------------------------------------");
                String prompt = IOUtils.getString(">> Like?(Y/N): ");
                if (prompt.equalsIgnoreCase("Y"))
                {
                    reviewsDb.likeReview(loginUser.getUsername(), currentReview);
                }
            }
        }
    }

    /**
     * Suggestion for each user.
     */
    public void suggestion()
    {
        ArrayList<User> allRecommend = UserManager.getAllUsers().getUsers();
        for (User currentUser : allRecommend)
        {
            if (loginUser.getFollowing().contains(currentUser.getUsername()))
            {
                for (String userFollowing : currentUser.getFollowing())
                {
                    for (User theUser : allRecommend)
                    {
                        if (theUser.getUsername().equals(userFollowing))
                        {
                            theUser.addSimilar();
                        }
                    }
                }
            }
            ArrayList<Review> Y = reviewsDb.getAllReviewsByUser(currentUser.getUsername());
            for (Review currentR : Y)
            {
                try
                {
                    for (String theGenre : moviesDb.getMovie(currentR.getReviewedMovieName(), currentR.getReviewedMovieYear()).getGenres())
                    {
                        if (loginUser.getFavoriteGenres().contains(theGenre))
                        {
                            currentUser.addSimilar();
                            break;
                        }
                    }
                }
                catch (NullPointerException e)
                {
                }
            }
        }
        TreeSet<User> newTreeSet = new TreeSet<>();
        for (User currentUser : allRecommend)
        {
            newTreeSet.add(currentUser);
        }
        for (User currentUser : newTreeSet)
        {
            if (!loginUser.getFollowing().contains(currentUser.getUsername()))
            {
                if (!loginUser.getUsername().equals(currentUser.getUsername()))
                {
                    System.out.println(" Username: " + currentUser.getUsername());
                }
                currentUser.resetSimilar();
            }
        }
    }

    /**
     * Write a review and add it to review database.
     */
    public boolean writeReview()
    {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println("- Write a review ------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------");
        ArrayList<String> body = new ArrayList<>();
        Movie reviewedMovie;
        String nameMovie = IOUtils.getString(">> Movie name: ");
        int yearMovie = IOUtils.getInteger(">> Year: ");
        reviewedMovie = moviesDb.getMovie(nameMovie, yearMovie);
        if (reviewedMovie == null)
        {
            System.out.println("!!! Movie is not found !!!");
            return false;
        }
        String nameReview = IOUtils.getString(">> Title of Review: ");
        System.out.println(">> Enter review detail below. Type END to  finish.");
        while (true)
        {
            String line = IOUtils.getBareString();
            if (line.compareTo("END") == 0)
            {
                break;
            }
            body.add(line);
        }
        double rate = IOUtils.getFloat(">> Give rating (0 - 10): ");
        Date now = new Date();
        Review writtenReview = new Review(reviewedMovie.getTitle(), reviewedMovie.getYear(), Double.parseDouble(new DecimalFormat("##.#").format(rate)), loginUser.getUsername(), nameReview, body, now);
        printReviewDetail(writtenReview);
        System.out.println("-----------------------------------------------------------------------------");
        reviewsDb.addReview(writtenReview);
        return true;
    }

    public static void main(String[] args)
    {
        MovieReviewSocialNetwork socialSystem = new MovieReviewSocialNetwork();

        /*  */
        MovieReviewSocialNetwork.initializeMovie();
        MovieReviewSocialNetwork.initializeReview();
        UserManager.initialize();
        socialSystem.welcome();
        /* Ask to choose log in or sign up */
        int choice = IOUtils.getInteger("\n(1) Log in or (2) Sign up?: ");
        String inputEmail;
        String inputPassword;
        String inputUsername;
        if (choice == 1)
        {
            inputEmail = IOUtils.getString("\nEmail: ");
            inputPassword = IOUtils.getString("Password: ");
            loginUser = UserManager.login(inputEmail, inputPassword);
            if (loginUser == null)
            {
                System.out.println("Incorrect password or user is not found!!!");
                System.exit(0);
            }
        }
        else if (choice == 2)
        {
            inputEmail = IOUtils.getString("\nEmail: ");
            inputPassword = IOUtils.getString("Password: ");
            inputUsername = IOUtils.getString("Username: ");
            ArrayList<String> genres = new ArrayList<>();
            while (true)
            {
                System.out.println("\n   (1) Action");
                System.out.println("   (2) Adventure");
                System.out.println("   (3) Animation");
                System.out.println("   (4) Biography");
                System.out.println("   (5) Comedy");
                System.out.println("   (6) Crime");
                System.out.println("   (7) Documentary");
                System.out.println("   (8) Drama");
                System.out.println("   (9) Family");
                System.out.println("   (10) Fantasy");
                System.out.println("   (11) Film-Noir");
                System.out.println("   (12) History");
                System.out.println("   (13) Horror");
                System.out.println("   (14) Music");
                System.out.println("   (15) Musical");
                System.out.println("   (16) Mystery");
                System.out.println("   (17) Romance");
                System.out.println("   (18) Sci-Fi");
                System.out.println("   (19) Sport");
                System.out.println("   (20) Thriller");
                System.out.println("   (21) War");
                System.out.println("   (22) Western");
                int inputGenre = IOUtils.getInteger(">> Add favorite genre (0 to exit): ");
                if (inputGenre == 0)
                {
                    break;
                }
                else if (inputGenre == 1)
                {
                    genres.add("Action");
                }
                else if (inputGenre == 2)
                {
                    genres.add("Adventure");
                }
                else if (inputGenre == 3)
                {
                    genres.add("Animation");
                }
                else if (inputGenre == 4)
                {
                    genres.add("Biography");
                }
                else if (inputGenre == 5)
                {
                    genres.add("Comedy");
                }
                else if (inputGenre == 6)
                {
                    genres.add("Crime");
                }
                else if (inputGenre == 7)
                {
                    genres.add("Documentary");
                }
                else if (inputGenre == 8)
                {
                    genres.add("Drama");
                }
                else if (inputGenre == 9)
                {
                    genres.add("Family");
                }
                else if (inputGenre == 10)
                {
                    genres.add("Fantasy");
                }
                else if (inputGenre == 11)
                {
                    genres.add("Film-Noir");
                }
                else if (inputGenre == 12)
                {
                    genres.add("History");
                }
                else if (inputGenre == 13)
                {
                    genres.add("Horror");
                }
                else if (inputGenre == 14)
                {
                    genres.add("Music");
                }
                else if (inputGenre == 15)
                {
                    genres.add("Musical");
                }
                else if (inputGenre == 16)
                {
                    genres.add("Mystery");
                }
                else if (inputGenre == 17)
                {
                    genres.add("Romance");
                }
                else if (inputGenre == 18)
                {
                    genres.add("Sci-Fi");
                }
                else if (inputGenre == 19)
                {
                    genres.add("Sport");
                }
                else if (inputGenre == 20)
                {
                    genres.add("Thriller");
                }
                else if (inputGenre == 21)
                {
                    genres.add("War");
                }
                else if (inputGenre == 22)
                {
                    genres.add("Western");
                }
                else
                {
                    System.out.println("!!! Invalid Genre !!!");
                }
            }
            loginUser = new User(inputEmail, inputPassword, inputUsername, genres);
        }
        else
        {
            System.out.println("!!! Incorrect choice !!!");
            System.exit(0);
        }
        while (true)
        {
            System.out.println("\nHello \"" + loginUser.getUsername() + "\",");
            System.out.println("(1) Timeline");
            System.out.println("(2) Write a review");
            System.out.println("(3) Edit or delete your review");
            System.out.println("(4) Find reviews");
            System.out.println("(5) Manage Follow list");
            System.out.println("(6) Friend suggestion");
            System.out.println("(0) Exit...");
            choice = IOUtils.getInteger("\nWhat is your choice?: ");
            if (choice == 0)
            {
                System.out.println("Update database...");
                saveUsers();
                saveReviews();
                System.exit(1);
            }
            else if (choice == 1)
            {
                socialSystem.seeTimeline();
            }
            else if (choice == 2)
            {
                socialSystem.writeReview();
            }
            else if (choice == 3)
            {
                socialSystem.editOrDelete();
            }
            else if (choice == 4)
            {
                socialSystem.findReview();
            }
            else if (choice == 5)
            {
                socialSystem.manageFollowList();
            }
            else if (choice == 6)
            {
                socialSystem.suggestion();
            }
            else
            {
                System.out.println("!!! Invalid choice !!!");
            }
        }
    }
}