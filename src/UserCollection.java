import java.util.ArrayList;

public class UserCollection
{
    private ArrayList<User> users = new ArrayList<User>();


    public void printUser()
    {

    }

    public boolean addUser(User user)
    {
        for (User currentUser : users)
        {
            if (currentUser.getUsername().equals(user.getUsername()) ||
                    currentUser.getEmail().equals(user.getEmail()))
            {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public boolean removeUser(User user)
    {
        return users.remove(user);
    }

    public int getTotalUser()
    {
        return users.size();
    }

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

    public User login(String email, String password)
    {
        for (User currentUser : users)
        {
            if (currentUser.getEmail().equals(email) && currentUser.getPassword().equals(password))
            {
                return currentUser;
            }
        }
        return null;
    }
}