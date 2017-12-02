import java.util.ArrayList;
import java.util.TreeSet;

public class User implements Comparable<User>
{
    private String Email;
    private String Password;
    private String Username;
    private int Similar = 0;
    private TreeSet<String> favoriteGenre = new TreeSet<String>();
    private ArrayList<String> following = new ArrayList<>();

    public User(String Email, String Password, String Username)
    {
        this.Email = Email;
        this.Password = Password;
        this.Username = Username;
    }

    public String getEmail()
    {
        return Email;
    }

    public ArrayList<String> getFollowing()
    {
        return following;
    }

    public void addFollowing(String targetUsername)
    {
        following.add(targetUsername);
    }

    public void removeFollowing(String targetUsername)
    {
        following.remove(targetUsername);
    }


    public String getPassword()
    {
        return Password;
    }

    public String getUsername()
    {
        return Username;
    }

    public TreeSet<String> getFavoriteGenre()
    {
        return favoriteGenre;
    }

    public boolean addFavoriteGenre(String genre)
    {
        return favoriteGenre.add(genre);
    }


    public void addSimilar()
    {
        this.Similar += 1;
    }
    public void resetSimilar()
    {
        this.Similar = 0;
    }

    public int getSimilar()
    {
        return this.Similar;
    }

    @Override
    public int compareTo(User o)
    {
        if (this.getSimilar() == o.getSimilar())
        {
            return this.getUsername().compareTo(o.getUsername());
        }
        else
        {
            return Integer.compare(o.getSimilar(), this.getSimilar());
        }
    }

    public boolean removeFavoriteGenre(String genre)
    {
        return favoriteGenre.remove(genre);
    }
}