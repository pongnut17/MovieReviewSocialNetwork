/**
 * UserManager.java
 *
 * This class represents the user security of this program.
 *
 * All methods are static because this is a singleton class.
 *
 * Created by Sally Goldin, 2 October 2017
 */

public class UserManager
{
    private static final String usersFileName = "allusers.txt";
    private static UserCollection allusers = new UserCollection();

    private UserManager()
    {
    }

    /**
     * Set up all the users necessary for a program
     * This could be done via reading from a file or
     * by hardcoding the data
     */
    public static void initialize()
    {
        UserFileReader reader = new UserFileReader();
        if (!reader.open(usersFileName))
        {
            System.out.println("Error opening tile file " + usersFileName + " in UserManager:initialize()");
            System.exit(0);
        }
        User nextUser;
        while ((nextUser = reader.getUser()) != null)
        {
            boolean bOk = allusers.addUser(nextUser);
            if (bOk)
            {
                System.out.println("Successfully added " + nextUser);
            }
            else
            {
                System.out.println("Error adding " + nextUser);
            }
        }
        System.out.println("UserManager initialized");
    }

    /**
     * Check email and password that matched or not.
     *
     * @param email    email of login
     * @param password password of login
     * @return User of successful login
     */
    public static User login(String email, String password)
    {
        for (User currentUser : allusers.getUsers())
        {
            if (currentUser.getEmail().equals(email) && currentUser.getPassword().equals(password))
            {
                return currentUser;
            }
        }
        return null;
    }

    /**
     * Get all users in UserCollection.
     *
     * @return UserCollection of all users
     */
    public static UserCollection getAllUsers()
    {
        return allusers;
    }
}