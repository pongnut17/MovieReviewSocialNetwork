/**
 * IOUtils.java
 *
 * Class that provides static functions for doing terminal input
 *
 * Created by Sally Goldin, 30 April 2014
 *
 * Modified by Like a Boss, 6 December 2017
 * - Change System.out.println to System.out.print.
 */

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOUtils
{
    /**
     * Get a bare-string and returns it as the value of the function
     *
     * @return The string the user entered
     */
    public static String getBareString()
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
        {
            inputString = inputString.substring(0, pos);
        }
        return inputString;
    }

    /**
     * Creates and returns a string with the current date
     * and time, to use as a time stamp.
     *
     * @return date/time string in the form "yyyy-mm-dd hh:mm:ss"
     */
    public static String getDateTime()
    {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(now);
    }

    /**
     * Asks for an float and returns it as the value of the function
     *
     * @param prompt String to print, telling which coordinate
     * @return value entered. If not an integer, prints an error message
     *         and returns -999
     */
    public static float getFloat(String prompt)
    {
        float value = -999;
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.print(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        try
        {
            int pos = inputString.indexOf("\n");
            if (pos > 0)
            {
                inputString = inputString.substring(0, pos);
            }
            value = Float.parseFloat(inputString);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered");
        }
        return value;
    }

    /**
     * Asks for an integer and returns it as the value of the function
     *
     * @param prompt String to print, telling which coordinate
     * @return value entered. If not an integer, prints an error message
     *         and returns -999
     */
    public static int getInteger(String prompt)
    {
        int value = -999;
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.print(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        try
        {
            int pos = inputString.indexOf("\n");
            if (pos > 0)
            {
                inputString = inputString.substring(0, pos);
            }
            value = Integer.parseInt(inputString);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad number entered");
        }
        return value;
    }

    /**
     * Asks for a string and returns it as the value of the function
     *
     * @param prompt String to print, telling which coordinate
     * @return The string the user entered (maximum 100 chars long)
     */
    public static String getString(String prompt)
    {
        String inputString;
        int readBytes = 0;
        byte buffer[] = new byte[200];
        System.out.print(prompt);
        try
        {
            readBytes = System.in.read(buffer, 0, 200);
        }
        catch (IOException ioe)
        {
            System.out.println("Input/output exception - Exiting");
            System.exit(1);
        }
        inputString = new String(buffer);
        int pos = inputString.indexOf("\n");
        if (pos > 0)
        {
            inputString = inputString.substring(0, pos);
        }
        return inputString;
    }
}