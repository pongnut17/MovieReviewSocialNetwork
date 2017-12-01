import java.util.ArrayList;

public class MovieReviewSocialNetwork
{


    private static UserManager allusers = new UserManager();
    private static MovieCollection allmovies = new MovieCollection();


    public User logIn(String Email, String Pass)
    {
        User login = new User(null, null, null);

        User suspect = allusers.getUserbyEmail(Email);

        if (Pass.equals(suspect.getPassword()))
        {
            login = suspect;
        }
        else
        {
            login = null;
        }

        return login;
    }


    public int menu()
    {

        System.out.println("1. Add your favorite genre (recommended for new member)");
        System.out.println("2. Write some review");
        System.out.println("3. ...........");
        System.out.println("4. ...........");
        System.out.println("5. Exit..");


        int menu = IOUtils.getInteger("\nWhat is your choice?: ");

        return menu;
    }

    public void selectFavorite(User selector)
    {

        String YesNo = new String();

        System.out.println("\nThis is list of genres in system !!");
        System.out.println("1.Action");
        System.out.println("2.Adventure");
        System.out.println("3.Animation");
        System.out.println("4.Comedy");
        System.out.println("5.Drama");
        System.out.println("6.Crime");


        do
        {
            int select = IOUtils.getInteger("\nEnter number of genre that you like?: ");

            switch (select)
            {
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

    public void writeSomeReview(User writer)
    {
        Movie writtenMovie = new Movie(null, 0, null);
        ArrayList<String> bodies = new ArrayList<String>();

        System.out.println("\nEnter information below");
        String nameMovie = IOUtils.getString("Title of movie :");
        int yearMovie = IOUtils.getInteger("Released year :");

        writtenMovie = allmovies.getMovies(nameMovie, yearMovie);

        System.out.println("Title :'" + writtenMovie.getTitle() + "'  Year: '" + writtenMovie.getYear() + "'\nGenres : " + writtenMovie.getGenre());

        String nameReview = IOUtils.getString("Title of Review :");
        System.out.println("==> Enter review text below. Type END to  finish.");
        while (true)
        {
            String line = IOUtils.getBareString();
            if (line.compareTo("END") == 0)
            {
                break;
            }
            bodies.add(line);
        }

        float rate = IOUtils.getFloat("Give rating (0 - 5) :");
        String time = IOUtils.getDateTime();

        Review writtenReview = new Review(writtenMovie, writer, nameReview, bodies, rate, time);

        writtenReview.printReviewDetail();


    }


    public static void main(String args[]) throws Exception
    {

        MovieReviewSocialNetwork socialSystem = new MovieReviewSocialNetwork();

        User currentUser = new User(null, null, null);

        allusers.initialize();
        allmovies.initialize();

        String inputEmail = IOUtils.getString("Enter your email: ");
        String inputPassword = IOUtils.getString("Enter your password: ");


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

                    break;
                case 4:

                    break;
                case 5:
                    System.exit(10);
                    break;
            }
        }


    }
}
