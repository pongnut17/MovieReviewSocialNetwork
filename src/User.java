import java.util.ArrayList;
import java.util.TreeSet;

public class User
{
    private String Email;
    private String Password;
    private String Username;
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

    public ArrayList<String> getFollowing() {
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

    public boolean removeFavoriteGenre(String genre)
    {
        return favoriteGenre.remove(genre);
    }
}
