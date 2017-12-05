/**
 * MovieFileReader.java
 *
 * Class to read information all movie database from a file.
 *
 * Each line of the file has the following structure
 *
 * Justice_League 2017 Action,Adventure,Fantasy
 *
 * First field is movie name
 * Second field is year of movie
 * Third field is all genres of movie
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.util.ArrayList;
import java.util.Collections;

public class MovieFileReader extends TextFileReader
{
    private String title = null;
    private int year = 0;

    /**
     * Try to convert a underscore in string to a space.
     *
     * @param stringToConvert String that contains underscore
     * @return String that already converted
     */
    private String convertUnderscoreToSpace(String stringToConvert)
    {
        String value = stringToConvert; /* start by assuming bad value */
        value = value.replaceAll("_", " ");
        return value;
    }
    /**
     * Try to convert a string to an integer.
     *
     * @param stringToConvert String that we think should be an integer
     * @return integer value or -999 if conversion error occurred.
     */
    private int convertToInt(String stringToConvert)
    {
        int value = -999; /* start by assuming bad value */
        try
        {
            value = Integer.parseInt(stringToConvert);
        }
        catch (NumberFormatException nfe)
        {
        }
        return value;
    }

    /**
     * Get the next movie. This method reads a line (if necessary)
     * then creates and returns a Movie as specified.
     *
     * @return new Movie, or null if the file is finished
     */
    public Movie getMovie()
    {
        Movie newMovie = null;
        String line = getNextLine();
        if (line != null)
        {
            String fields[] = line.split(" ");
            if (fields.length == 3)
            {
                title = convertUnderscoreToSpace(fields[0]);
                year = convertToInt(fields[1]);

                String substring = fields[2];
                String genres[] = substring.split(",");
                ArrayList<String> allgenres = new ArrayList<>();
                for (String currentGenre : genres)
                {
                    allgenres.add(currentGenre);
                }
                Collections.sort(allgenres);
                newMovie = new Movie(title, year, allgenres);
            }
        }
        return newMovie;  /* will be null if we've reached EOF */
    }
}