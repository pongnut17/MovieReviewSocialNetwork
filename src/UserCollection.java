/**
 * UserCollection.java
 *
 * A UserCollection is a group of users
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;

public class UserCollection
{
    private ArrayList<User> users = new ArrayList<>();

    /**
     * Add new user to ArrayList<User>.
     *
     * @param user User to add
     * @return true unless false if it already existed.
     */
    public boolean addUser(User user)
    {
        for (User currentUser : users)
        {
            if (currentUser.getUsername().equals(user.getUsername()) || currentUser.getEmail().equals(user.getEmail()))
            {
                return false;
            }
        }
        return users.add(user);
    }

    /**
     * Remove user from ArrayList<User>.
     *
     * @param user User to remove
     * @return true unless false if it doesn't existed
     */
    public boolean removeUser(User user)
    {
        return users.remove(user);
    }

    /**
     * Get user by email.
     *
     * @param email email to find
     * @return User object
     */
    public User getUserbyEmail(String email)
    {
        for (User currentUser : users)
        {
            if (currentUser.getEmail().equals(email))
            {
                return currentUser;
            }
        }
        return null;
    }

    /**
     * Get user by username.
     *
     * @param username to find
     * @return User object
     */
    public User getUserbyUsername(String username)
    {
        for (User currentUser : users)
        {
            if (currentUser.getUsername().equals(username))
            {
                return currentUser;
            }
        }
        return null;
    }

    /**
     * Get total users count.
     *
     * @return Users size
     */
    public int getTotalUser()
    {
        return users.size();
    }

    /**
     * Get ArrayList<User> of all users.
     *
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsers()
    {
        return users;
    }
}