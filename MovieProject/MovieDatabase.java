import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 *  A MovieDatabase is a mutable collection of Movie objects
 */
public class MovieDatabase 
{
    // A MovieDatabase HAS-A Movie
    private List<Movie> movieList;  // a List of all Movie objects in this particular MovieDatabase

    /**
     * initializes a MovieDatabase -- the database starts empty
     */
    public MovieDatabase()  
    { 
        movieList = new ArrayList<Movie>();
    }

    /**
     * adds a Movie to the database, in no particular order
     */
    public void addMovie(Movie movie)
    {
        movieList.add(movie);
    }
    
    /**
     * searches the database for Movie titles that contain the keyword
     * for example: search("Dalmation") returns a List containing
     * only one movie: the movie associated with "101 Dalmations"
     * If no movies are found, return an empty List
     */
    public List<Movie> search(String keyword)
    {
        List<Movie> returnList = new ArrayList<Movie>();
        for(Movie movie : movieList)
        {
            if(findString(keyword, movie.getTitle()))
            {
                returnList.add(movie);
            }
        }
        return returnList;
    }
    
    private boolean findString(String t, String in)
    {
        String test = (new String(t)).toUpperCase();
        String input = (new String(in)).toUpperCase();
        if(input.length() < test.length())
        {
            return false;
        }
        String[] testArr = test.split("");
        String[] inputArr = input.split("");
        for(int i = 0; i < (inputArr.length - testArr.length); i++)
        {
            int j = 0;
            boolean possible = true;
            while(possible)
            {
                if(j == testArr.length - 1)
                {
                    return true;
                }
                if(inputArr[i + j].equals(testArr[j]))
                {
                    j++;
                }
                else
                {
                    possible = false;
                }
            }
        }
        return false;
    }
                    
        
   /**
    * Returns a List of all Movie objects in which a person acted.
    * If no movies are found with this actor, return an empty List.
    * 
    * Note: the actor's name must be an exact match. 
    * 
    * For example, findMoviesWithActor("Bacon") would return an empty List
    * but findMoviesWithActor("Kevin Bacon") might return the movies 
    * Animal House, Apollo 13, and A Few Good Men.
    */

   
   public List<Movie> findMoviesWithActor(String person)
   {
       List<Movie> returnList = new ArrayList<Movie>();
       for(Movie movie : movieList){
           boolean isAdded = false;
           for(String actor : movie.getActors())
           {
               if(actor.equals(person) && !isAdded)
               {
                   returnList.add(movie);
                   isAdded = true;
               }
           }
        }
        return returnList;
   }
   
   
    
    /**
     * This method takes the most amount of work and is the most important. 
     * It loops through a List of movies formatted in the following way (as seen in the text file):
     * 
     * title: (year)/Last Name of Actor 1, First Name of Actor 1/Last Name of Actor 2, First Name of Actor 2/...
     * 
     * For example
     * Ace Ventura: When Nature Calls (1995)/Akinnuoye-Agbaje, Adewale/Allen, Kayla/...
     * 
     * From this long String, extract the following:
     * 1. movie title
     *    e.g. Ace Ventura: When Nature Calls
     * 2. year
     *    e.g. 1995
     * 3. List of actors. Each actor should be parsed to match this format:
     *              FirstName LastName 
     *    with no commas.
     *    e.g. [Adewale Akinnuoye-Agbaje, Kayla Allen, ...]
     *    Note: Some actors do not have a last name, like Madonna.
     *    
     *    
     * After extracting this information, instantiate a Movie object with all of 
     * these data fields and add it to this MovieDatabase using the addMovie method. 
     * 
     * Repeat this for each of the movies in movieList.
     * Hint: the split() method in the String class is particularly useful.
     * For example, "dog/cat/sat".split("/") returns the following array:
     *      ["dog", "cat", "sat"]
     */
    void addUnformattedMoviesToDatabase(List<String> movieList){
        for(String movie : movieList)
        {
            int yearStart = -1;
            boolean found = false;
            for(int i = 0 ; i < movie.length(); i++)
            {
                if(movie.charAt(i) == '(' && !found)
                {
                    yearStart = i;
                    found = true;
                }
            }
            String title = movie.substring(0,yearStart - 1);
            int year = Integer.parseInt(movie.substring(yearStart + 1, yearStart + 5));
            String[] names = (movie.substring(yearStart + 7)).split("/");
            List<String> actorList = new ArrayList<String>();
            for(String name : names)
            {
                String newName = "";
                String[] nameSplit = name.split(",");
                if(nameSplit.length == 2)
                {
                    newName = newName + nameSplit[1].substring(1);
                    newName = newName + " " + nameSplit[0];
                }
                else
                {
                    newName = nameSplit[0];
                }
                actorList.add(newName);
            }
            Movie newMovie = new Movie(title, year, actorList);
            this.addMovie(newMovie);
        }
    }
       
    
    
}
