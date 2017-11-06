import java.util.ArrayList;

public class User
{
    private String Email;
    private String Password;
    private String Username;
    private ArrayList<String> favoriteGenre;
    private UserCollection follower;
    private UserCollection following;
    private ReviewCollection ownReview;

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

    public String getPassword()
    {
        return Password;
    }

    public String getUsername()
    {
        return Username;
    }

    public ArrayList<String> getFavoriteGenre()
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
