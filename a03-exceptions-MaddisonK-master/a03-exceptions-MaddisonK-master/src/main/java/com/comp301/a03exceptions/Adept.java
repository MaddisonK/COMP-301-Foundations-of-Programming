package com.comp301.a03exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Adept {

  /**
   * Section 4: Try/catch/finally block execution tracing
   *
   * <p>This method should call class method section1() from the Novice class, passing in n as the
   * parameter. Surround the section1() method call in a try-catch-finally block, and use it to
   * catch only the exception that is associated with an n value of five.
   *
   * <p>Next, use the Printer object, which is passed as a parameter to section4(), to add the
   * following "print" statements to your code. See the Printer interface for information about how
   * to use the overloaded print() method of the Printer object.
   *
   * <p>If an exception is caught, use the Printer object to print "If we get here, that means an
   * exception was caught". If no exception occurs, use the Printer object to print "If we get here,
   * that means no exception occurred". Regardless of whether an exception occurs or not, use the
   * Printer object to print "If we get here, the try/catch block is done, but an exception may not
   * have been caught". If the try/catch block finishes successfully (i.e. either an exception
   * occurred and was caught or no exception occurred at all), then use the Printer object to print
   * "If we get here, we made it through the try/catch block and caught any exceptions that may have
   * occurred".
   */
  public static void section4(int n, Printer printer) {
    try {
      Novice.section1(n);
      printer.print("If we get here, that means no exception occurred");
    } catch (NullPointerException npe) {
      printer.print("If we get here, that means an exception was caught");
    } finally {
      printer.print(
          "If we get here, the try/catch block is done, but an exception may not have been caught");
    }
    printer.print(
            "If we get here, we made it through the try/catch block and caught any exceptions that may have occurred");
  }

  /**
   * Section 5: Throwing a checked exception
   *
   * <p>This method takes a URL string as input, and opens an HTTP stream that can be used to
   * download the webpage associated with the URL. The method should not catch any exceptions
   * associated with the process of downloading the webpage; any associated exceptions should be
   * thrown to the caller.
   */
  public static BufferedReader section5(String urlText) throws IOException {
    // 1. Create a URL object representing the url that will be imported. IntelliJ will tell you to
    //    add a "throws" clause to the section5() method declaration. IntelliJ will also make sure
    //    you import the URL class from java.net. Make sure you pass urlText to the constructor of
    //    URL, so that the object knows which webpage to download.
    //    See: https://docs.oracle.com/javase/7/docs/api/java/net/URL.html#URL(java.lang.String)

    // 2. Call the openStream() method on the URL object to produce an InputStream object. Save the
    //    resulting InputStream object in a local variable. IntelliJ will tell you to update the
    //    "throws" clause in the section5() method declaration. IntelliJ will also make sure you
    //    import the InputStream class from java.io.
    //    See: https://docs.oracle.com/javase/7/docs/api/java/net/URL.html#openStream()
    //    See: https://docs.oracle.com/javase/7/docs/api/java/io/InputStream.html

    // 3. Create a new InputStreamReader object that will handle downloading the contents of the
    //    webpage using the InputStream object that you created in step 2. Pass the InputStream
    //    object into the constructor for InputStreamReader. IntelliJ will make sure you import the
    //    InputStreamReader class from java.io.
    //    See:
    // https://docs.oracle.com/javase/7/docs/api/java/io/InputStreamReader.html#InputStreamReader(java.io.InputStream)

    // 4. Create a new BufferedReader object that will buffer the output of the InputStreamReader
    //    that you created in step 3. Pass the InputStreamReader object into the constructor for
    //    BufferedReader.
    //    See:
    // https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html#BufferedReader(java.io.Reader)

    // 5. Return the BufferedReader object that you created in step 4!
    InputStream stream = new URL(urlText).openStream();
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader bReader = new BufferedReader(reader);
    return bReader;
  }

  /**
   * Section 6: Catching a checked exception
   *
   * <p>This method takes a URL string as input, and calls class method section5() to obtain an open
   * BufferedReader object to the webpage. Surround the call to section5() in a try/catch/finally
   * block. Use it to catch the IOException that may be thrown if something goes wrong while
   * downloading the webpage from the internet.
   *
   * <p>In the finally block, make sure you close the BufferedReader file stream! Use the close()
   * method to accomplish this.
   *
   * <p>In the catch block, return the string "An error occurred and the page could not be
   * downloaded". See: https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html#close()
   *
   * <p>If no exception is thrown, that means we have an active stream. Check out the readLine()
   * method in the BufferedReader class; it reads the website contents one line at a time. Once
   * readLine() returns null, that means there are no lines left to read. Use a while() loop to read
   * each line of the website, and accumulate all lines in a String. Once a "null" line is
   * encountered, return the accumulated contents as a String. See:
   * https://docs.oracle.com/javase/7/docs/api/java/io/BufferedReader.html#readLine()
   */
  public static String section6(String urlText) throws IOException {
    BufferedReader bReader = null;
    try {
      bReader = section5(urlText);
      String output = "";
      String temp = bReader.readLine();
      while (temp != null) {
        output += temp;
        temp = bReader.readLine();
      }
      return output;
    } catch (IOException io) {
      return "An error occurred and the page could not be downloaded";
    } finally {
      if (bReader != null) {
        bReader.close();
      }
    }
  }
}
