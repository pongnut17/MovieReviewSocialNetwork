import java.io.Console;
import java.util.ArrayList;
import java.util.TreeSet;

public class MovieReviewSocialNetwork {


    private static UserManager allusers = new UserManager();
    private static MovieCollection allmovies = new MovieCollection();
    private static ReviewCollection allreviews = new ReviewCollection();


    public User logIn(String Email, String Pass) {
        User login = new User(null, null, null);

        User suspect = allusers.getUserbyEmail(Email);

        if (Pass.equals(suspect.getPassword())) {
            login = suspect;
        } else {
            login = null;
        }
        return login;
    }



    public int menu()
    {
        System.out.println("1. Add your favorite genre (recommended for new member)");
        System.out.println("2. Write some review ");
        System.out.println("3. Edit or delete your review ");
        System.out.println("4. Manage Follow list");
        System.out.println("5. See timeline");
        System.out.println("6. Recommend");
        System.out.println("7. ...........");
        System.out.println("8. Exit..");


        int menu = IOUtils.getInteger("\nWhat is your choice?: ");

        return menu;
    }

    public void selectFavorite(User selector) {

        String YesNo = new String();

        System.out.println("\nThis is list of genres in system !!");
        System.out.println("1.Action");
        System.out.println("2.Adventure");
        System.out.println("3.Animation");
        System.out.println("4.Comedy");
        System.out.println("5.Drama");
        System.out.println("6.Crime");


        do {
            int select = IOUtils.getInteger("\nEnter number of genre that you like?: ");

            switch (select) {
                case 1:
                    selector.addFavoriteGenre("Action");
                    break;
                case 2:
                    selector.addFavoriteGenre("Adventure");
                    break;
                case 3:
                    selector.addFavoriteGenre("Animation");
                    break;
                case 4:
                    selector.addFavoriteGenre("Comedy");
                    break;
                case 5:
                    selector.addFavoriteGenre("Drama");
                    break;
                case 6:
                    selector.addFavoriteGenre("Crime");
                    break;
            }

            YesNo = IOUtils.getString("Do you want to add more?(Y/N) :");

        }
        while (YesNo.equalsIgnoreCase("Y"));


        System.out.println("This is your favorite genre now!!");
        System.out.println((selector.getFavoriteGenre()));

    }

    public void writeSomeReview(User writer) {
        Movie writtenMovie = new Movie(null, 0, null);
        ArrayList<String> bodies = new ArrayList<String>();

        System.out.println("\nEnter information below");
        String nameMovie = IOUtils.getString("Title of movie :");
        int yearMovie = IOUtils.getInteger("Released year :");

        writtenMovie = allmovies.getMovies(nameMovie, yearMovie);

        System.out.println("Title :'" + writtenMovie.getTitle() + "'  Year: '" + writtenMovie.getYear() + "'\nGenres : " + writtenMovie.getGenre());

        String nameReview = IOUtils.getString("Title of Review :");
        System.out.println("==> Enter review detail below. Type END to  finish.");
        while (true) {
            String line = IOUtils.getBareString();
            if (line.compareTo("END") == 0) {
                break;
            }
            bodies.add(line);
        }

        float rate = IOUtils.getFloat("Give rating (0 - 5) :");
        String time = IOUtils.getDateTime();

        Review writtenReview = new Review(writtenMovie.getTitle(), writer.getUsername(), nameReview, bodies, rate, time);

        writtenReview.printReviewDetail();

        allreviews.addReview(writtenReview);
    }

    public void editOrDelete(User owner) {
        int select = IOUtils.getInteger("What do you want to do?\n 1. Edit \n 2. Delete");

        switch (select) {
            case 1:
                Edit(owner);
                break;
            case 2:
                Delete(owner);
                break;
            default:
        }
    }

    public void Delete(User owner) {
        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews = allreviews.getAllReviewsByUser(owner.getUsername());
        int i = 1;

        System.out.println("------- This is list of your reviews -------");
        for (Review currentReview : reviews) {
            System.out.println(i + ". " + currentReview.getTitleReview() + "( " + currentReview.getReviewedMovie() + " )");
            i++;
        }

        int select = IOUtils.getInteger("Which one do you want to delete");

        allreviews.removeReview(reviews.get(select - 1));
    }

    public void Edit(User owner) {
        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews = allreviews.getAllReviewsByUser(owner.getUsername());
        int i = 1;

        System.out.println("------- This is list of your reviews -------");
        for (Review currentReview : reviews) {
            System.out.println(i + ". " + currentReview.getTitleReview() + "( " + currentReview.getReviewedMovie() + " )");
            i++;
        }

        int select = IOUtils.getInteger("Which one do you want to Edit");

        allreviews.getReviews(reviews.get(select - 1)).printReviewDetail();

        System.out.println("\n------- Edit  -------");
        int Eselect = IOUtils.getInteger("Which part do you want to Edit \n 1. Title\n 2. Details\n 3. Rating");

        switch (Eselect) {
            case 1:
                String nameReview = IOUtils.getString("New title of Review :");
                allreviews.getReviews(reviews.get(select - 1)).setTitleReview(nameReview);
                break;
            case 2:
                ArrayList<String> bodies = new ArrayList<String>();
                System.out.println("==> Enter new review detail below. Type END to  finish.");
                while (true) {
                    String line = IOUtils.getBareString();
                    if (line.compareTo("END") == 0) {
                        break;
                    }
                    bodies.add(line);
                }
                allreviews.getReviews(reviews.get(select - 1)).setDetail(bodies);
                break;
            case 3:
                float rate = IOUtils.getFloat("New rating (0 - 5) :");
                allreviews.getReviews(reviews.get(select - 1)).setRating(rate);
                break;
        }
    }

    public void manageFollowList(User user) {
        int select = IOUtils.getInteger("What do you want to do?\n 1. See your following list \n 2. Follow some user \n 3. Delete someone in your following list");

        switch (select) {
            case 1:
                int i = 1;
                System.out.println("------- This is list of your following -------");
                for (String curFollowing : user.getFollowing()) {
                    System.out.println(i + ". " + curFollowing);
                    i++;
                }

                String YesNo = IOUtils.getString("Do you want to do something with this?(Y/N) :");
                if (YesNo.equalsIgnoreCase("Y")) {
                    manageFollowList(user);
                }
                break;
            case 2:
                Follow(user);
                break;
            case 3:
                deleteFollow(user);
                break;
        }
    }

    public void Follow(User user) {
        String targetUser = IOUtils.getString("Username of user who you want to follow :");
        user.addFollowing(targetUser);
    }

    public void deleteFollow(User user) {
        String targetUser = IOUtils.getString("Username of user who you want to delete :");
        user.removeFollowing(targetUser);
    }

    public void seeTimeline(User user) {
        System.out.println("--------------------------------------");
        System.out.println("-------- ♥ This is timeline ♥ --------");
        System.out.println("--------------------------------------");
        for (Review currentReview : allreviews.getAllReviews()) {
            if (user.getFollowing().contains(currentReview.getOwner())) {
                currentReview.printReviewDetail();

                System.out.println("--------------------------------------");
                String YesNo = IOUtils.getString("Like?(Y/N) :");
                if (YesNo.equalsIgnoreCase("Y")) {
                    allreviews.likeReview(user.getUsername(), currentReview);
                }
            }
        }
    }


    private static void welcome()
    {
        System.out.println(" -----------------  -----------------  -----------------  ---------       -----");
        System.out.println(" |               |  |               |  |            |  |       \\       |   |");
        System.out.println(" |   ---   ---   |  |   ---------   |  |   ----------  |   |\\   \\      |   |");
        System.out.println(" |   | |   | |   |  |   |       |   |  |   |           |   | \\   \\     |   |");
        System.out.println(" |   | |   | |   |  |   ---------   |  |   ----------  |   |  \\   \\    |   |");
        System.out.println(" |   | |   | |   |  |               |  |            |  |   |   \\   \\   |   |");
        System.out.println(" |   | |   | |   |  |   |\\   \\-------  |---------   |  |   |    \\   \\  |   |");
        System.out.println(" |   | |   | |   |  |   | \\   \\              |   |  |   |     \\   \\ |   |");
        System.out.println(" |   | |   | |   |  |   |  \\   \\                |   |  |   |      \\   \\|   |");
        System.out.println(" |   | |   | |   |  |   |   \\   \\               |   |  |   |       \\       |");
        System.out.println(" |   | |   | |   |  |   |    \\   \\     ----------   |  |   |       \\       |");
        System.out.println(" |   | |   | |   |  |   |     \\   \\    |            |  |   |       \\       |");
        System.out.println(" |   | |   | |   |  |   |      \\   \\   |            |  |   |       \\       |");
        System.out.println(" ----- ----- -----  -----       -----  --------------  -----        --------");
    }


    public void recommend(User user)
    {

        TreeSet<User> newTreeSet = new TreeSet<User>();


        newTreeSet = allusers.getAllUsers().getUserslist();

        System.out.println(user.getFollowing());

        for (User currentUser : newTreeSet) {
            System.out.println("User :" + currentUser.getUsername());
            System.out.println(currentUser.getFollowing());

            if (user.getFollowing().contains(currentUser.getUsername())) {
                System.out.println("b");
                for (String userFollowing : currentUser.getFollowing()) {
                    for (User theUser : newTreeSet) {
                        if (theUser.getUsername().equals(userFollowing)) {
                            theUser.addSimilar();
                            System.out.println("c");
                        }
                    }


                }
            }


            ArrayList<Review> Y = allreviews.getAllReviewsByUser(currentUser.getUsername());

            for (Review currentR : Y)
            {
                for (String theGenre : allmovies.getMovies(currentR.getReviewedMovie()).getGenre())
                {
                    if(user.getFavoriteGenre().contains(theGenre))
                    {
                        currentUser.addSimilar();
                        break;
                    }
                }
            }
        }



        for (User currentUser : newTreeSet)
        {
            if(!user.getFollowing().contains(currentUser.getUsername()))
            {
                System.out.println("Score :" + currentUser.getSimilar() + " User: " + currentUser.getUsername());
                currentUser.resetSimilar();
            }
        }
    }





    public static void main(String args[])
    {
        welcome();
        MovieReviewSocialNetwork socialSystem = new MovieReviewSocialNetwork();

        User currentUser = new User(null, null, null);

        allusers.initialize();
        allmovies.initialize();
        allreviews.initialize();

        System.out.println("---------------");
        System.out.println("- LOGIN       -");
        System.out.println("---------------");
        String inputEmail = IOUtils.getString("Enter your email: ");
        String inputPassword = null;
        Console console = System.console();
        if (console != null)
        {
            char readPassword[] = console.readPassword("Enter your password: ");
            inputPassword = new String(readPassword);
        }
        else
        {
            inputPassword = IOUtils.getString("Enter your password: ");
        }
        System.out.println("\"" + inputPassword + "\"");

        try
        {
            currentUser = socialSystem.logIn(inputEmail, inputPassword);
        }
        catch (NullPointerException e)
        {
            System.out.println("Incorrect password or user is not known !!");
            System.exit(1);
        }

        System.out.println("Success Login User '" + currentUser.getUsername() + "'");

        while (true)
        {
            System.out.println("\nHello " + currentUser.getUsername() + ", What you want to do?\n");

            int choice = socialSystem.menu();

            switch (choice)
            {
                case 1:
                    socialSystem.selectFavorite(currentUser);
                    break;
                case 2:
                    socialSystem.writeSomeReview(currentUser);
                    break;
                case 3:
                    socialSystem.editOrDelete(currentUser);
                    break;
                case 4:
                    socialSystem.manageFollowList(currentUser);
                    break;
                case 5:
                    socialSystem.seeTimeline(currentUser);
                    break;
                case 6:
                    socialSystem.recommend(currentUser);
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(10);
                    break;
            }
        }
    }
}