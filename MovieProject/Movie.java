import java.util.List;
import java.util.ArrayList;
/**
 * Movie class that encapsulates some basic information about a movie
 */
public class Movie
{
    // instance variables 
    private String title;   // the title of the movie

    private int year;       // the year of the movie

    private List<String> actors; // a List of the main actors in the movie
    

    /**
     * Constructor for objects of class Movie
     * pre-condition: the actors' names will be passed in as: 
     * FirstName LastName 
     * with no commas. 
     * Note: Some actors do not have a last name, like Madonna.
     */
    public Movie(String title, int year, List<String> actors){
        this.title = new String(title);
        this.year = year;
        this.actors = new ArrayList<String>(actors);
    }

    /**
     * returns the title of the movie
     */
    public String getTitle()  
    {
        return new String(title);
    }
    
    /**
     * returns the year the movie was released
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * returns a List of all the main actors in the movie
     */
    public List<String> getActors()
    {
        return new ArrayList<String>(actors);
    }
    
    /**
     * returns a String representation of a Movie object 
         in the format:
         
         Title: 101 Dalmatians 
         Year: 1999
         Actors : [John Benfield, ... , Mark Williams]
     */
    public String toString()
    {
        String returnStr = "";//"\n";
        returnStr = returnStr + "Title: " + title;// + "\n";
        returnStr = returnStr + ", Year: " + Integer.toString(year);//  + "\n";
        String actorsList = "[";
        for(String actor : actors)
        {
            actorsList = actorsList + actor + ", ";
        }
        actorsList = actorsList.substring(0, actorsList.length() - 2) + "]";
        returnStr = returnStr + ", Actors: " + actorsList + "\n";
        return returnStr;
    }
    
    /**
     * Returns true if both the year and title of this and that are equal
     */
    public boolean equals(Object that){
        boolean returnBool = false;
        if(that instanceof Movie)
        {
            Movie thatMovie = (Movie)that;
            if(thatMovie.getTitle().equals(title) && (thatMovie.getYear() == year))
            {
                returnBool = true;
            }
        }
        return returnBool;
    }
    
}
