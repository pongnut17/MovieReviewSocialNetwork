/**
 * ReviewFileReader.java
 *
 * Class to read information all review database from a file.
 *
 * Each line of the file has the following structure
 *
 * 2017-12-01_23:51:01 pongnut17 Coco 2017 8.9 boss32734,pongnut17 Review_Title Review_Body
 *
 * First field is date of submitted
 * Second field is writer
 * Third field is movie name
 * Forth field is year of movie
 * Fifth field is rating
 * Sixth field is username who like this review
 * Seventh field is review title
 * Eighth field is review body
 *
 * Created by Like a Boss, 6 December 2017
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReviewFileReader extends TextFileReader
{
    private String movie = null;
    private String owner = null;
    private double rating = 0.0;
    private Date reviewedDate = null;
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
     * Try to convert a string to a double.
     *
     * @param stringToConvert String that we think should be an double
     * @return double value or -999.99 if conversion error occurred.
     */
    private double convertToDouble(String stringToConvert)
    {
        double value = -999.99; /* start by assuming bad value */
        try
        {
            value = Double.parseDouble(stringToConvert);
        }
        catch (NumberFormatException nfe)
        {
        }
        return value;
    }

    /**
     * Get the next Review. This method reads a line (if necessary)
     * then creates and returns a Review as specified.
     *
     * @return new Review, or null if the file is finished
     */
    public Review getReview()
    {
        Review newReview = null;

        String line = null;

        line = getNextLine();
        if (line != null)
        {
            String fields[] = line.split(" ");
            if (fields.length >= 8)
            {
                String inputReviewedDate = convertUnderscoreToSpace(fields[0]);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try
                {
                    reviewedDate = formatter.parse(inputReviewedDate);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                owner = fields[1];
                movie = convertUnderscoreToSpace(fields[2]);
                year = convertToInt(fields[3]);
                rating = convertToDouble(fields[4]);
                title = convertUnderscoreToSpace(fields[6]);
                ArrayList<String> body = new ArrayList<>();
                for (int i = 7; i < fields.length; i++)
                {
                    body.add(convertUnderscoreToSpace(fields[i]));
                }
                newReview = new Review(movie, year, rating, owner, title, body, reviewedDate);
                if (!fields[5].equalsIgnoreCase("-"))
                {
                    String substring = fields[5];
                    String likes[] = substring.split(",");
                    for (String currentLike : likes)
                    {
                        newReview.addLike(currentLike);
                    }
                }
            }
        }
        return newReview;  /* will be null if we've reached EOF */
    }
}