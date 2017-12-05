/**
 * UserFileReader.java
 *
 * Class to read information all user database from a file.
 *
 * Each line of the file has the following structure
 *
 * boss32734@hotmail.com 12345678 boss32734 Thriller,Crime loli123
 *
 * First field is email
 * Second field is password
 * Third field is username
 * Forth field is favorite of genres
 * Fifth field is following username
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;

public class UserFileReader extends TextFileReader
{
    private String email = null;
    private String username = null;
    private String password = null;

    /**
     * Get the next User. This method reads a line (if necessary)
     * then creates and returns a User as specified.
     *
     * @return new User, or null if the file is finished
     */
    public User getUser()
    {
        User newUser = null;
        String line;
        line = getNextLine();
        if (line != null)
        {
            String fields[] = line.split(" ");
            if (fields.length == 5)
            {
                email = fields[0];
                password = fields[1];
                username = fields[2];
                ArrayList<String> allgenres = new ArrayList<>();
                if (!fields[3].equals("-"))
                {
                    String substring = fields[3];
                    String genres[] = substring.split(",");
                    for (String currentGenre : genres)
                    {
                        allgenres.add(currentGenre);
                    }
                }
                newUser = new User(email, password, username, allgenres);
                if (!fields[4].equals("-"))
                {
                    String substring = fields[4];
                    String following[] = substring.split(",");
                    for (String currentFollowing : following)
                    {
                        newUser.addFollowing(currentFollowing);
                    }
                }
            }
        }
        return newUser;  /* will be null if we've reached EOF */
    }
}