/**
 * User.java
 *
 * Simple class representing a user object.
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;
import java.util.Collections;

public class User implements Comparable<User>
{
    private String Email;
    private String Password;
    private String Username;
    private ArrayList<String> favoriteGenres;
    private ArrayList<String> following;
    private int similar = 0;

    public User(String Email, String Password, String Username, ArrayList<String> genres)
    {
        this.Email = Email;
        this.Password = Password;
        this.Username = Username;
        Collections.sort(genres);
        this.favoriteGenres = genres;
        following = new ArrayList<>();
    }

    /**
     * Add following from user.
     *
     * @return true, unless incorrect user
     */
    public boolean addFollowing(String addfollowing)
    {
        return following.add(addfollowing);
    }

    /**
     * Remove following from user.
     *
     * @return true, unless incorrect user
     */
    public boolean removeFollowing(String unfollowing)
    {
        return following.remove(unfollowing);
    }

    /**
     * Add similar count for suggest feature.
     */
    public void addSimilar()
    {
        similar++;
    }

    /**
     * Reset similar count for suggest feature.
     */
    public void resetSimilar()
    {
        similar = 0;
    }

    /**
     * Get similar count for suggest feature.
     *
     * @return similar count
     */
    public int getSimilar()
    {
        return similar;
    }
    /**
     * Get username of user.
     *
     * @return username of user
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     * Get email of user.
     *
     * @return email of user
     */
    public String getEmail()
    {
        return Email;
    }

    /**
     * Get all favorite genres of user.
     *
     * @return TreeSet of all favorite genres
     */
    public ArrayList<String> getFavoriteGenres()
    {
        return favoriteGenres;
    }

    /**
     * Get all following of user.
     *
     * @return ArrayList<String> of following
     */
    public ArrayList<String> getFollowing()
    {
        return following;
    }

    /**
     * Get email of user.
     *
     * @return email of user
     */
    public String getPassword()
    {
        return Password;
    }

    @Override
    public int compareTo(User o)
    {
        if (getSimilar() == o.getSimilar())
        {
            return getUsername().compareTo(o.getUsername());
        }
        else
        {
            return Integer.compare(o.getSimilar(), getSimilar());
        }
    }
}