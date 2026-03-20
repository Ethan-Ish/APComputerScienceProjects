/**
 * SAMPLE RUN: (Feel free to edit to your own liking)
 * 
 * Welcome to The OHS Pixel Movie Database
 * 
 * Options
 * 1) Find all movies with a particular actor.
 * 2) Search for a movie by keyword.
 * 3) Exit
 * 
 * Choice: 1
 * Enter actor's name:
 * Kevin Bacon
 * 
 * Finding movies with Kevin Bacon...
 * [Animal House,1978, Actors:[Karen Allen, Kevin Bacon, ...,James Widdoes],
 *  Apollo 13,1995, Actors:[Ivan Allen, David Andrews, Kevin Bacon, ...,Walter von Huene],
 *  Few Good Men, A, 1992, Actors:[Kevin Bacon, Xander Berkeley, ..., Noah Wyle] ]
 * 
 * Options
 * 1) Find all movies with a particular actor.
 * 2) Search for a movie by keyword.
 * 3) Exit
 * 
 * Choice: 2
 * Enter search keyword: Ghost
 * 
 * Finding movies with the word "Ghost" in the title.... 
 * [ Ghost, 1990, Actors [Rick Aviles, Alma Beltran, ..., Charlotte Zucker],
 *   Ghostbusters, 1984, Actors: [William Atherton, Dan Aykroyd, ..., Christopher Wynkoop],
 *   Ghostbusters II, 1989, Actors: [Dan Aykroyd, Robert Alan Beuth, ..., Wilhelm von Homburg] ]
 * 
 */

import java.util.*;
import java.io.*;
//import java.NumberUtils.*;
public class MovieRunner 
{
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<String> movieList = readFile("movies-top-grossing.txt");
        
        System.out.println(movieList.size() + 
                           " movies have been imported from the file " +
                           "movies-top-grossing.txt\n" );
        System.out.println("For example, the second movie is:\n" + movieList.get(1) + "\n");
        
        
        
           
        // create an empty database
        MovieDatabase database = new MovieDatabase();
        
        // add movies to the database
        database.addUnformattedMoviesToDatabase(movieList);
        /*
        // some sample database queries
        System.out.println("Finding movies with the word \"Ghost\" in the title.... \n" +
                               database.search("Ghost"));
       
        System.out.println("Finding movies with Kevin Bacon...\n" + 
                               database.findMoviesWithActor("Kevin Bacon"));
        */                       
        
        boolean quit = false;
        String welcome = "Welcome to The OHS Pixel Movie Database!";
        String options = "\n Options \n 1) Find all movies with a particular actor. \n 2) Search for a movie by keyword. \n 3) Exit";
        System.out.println(welcome);
        while(!quit)
        {
            System.out.println(options);
            boolean valid = false;
            String input = "";
            int choice = -1;
            while(!valid) {
                input = scanner.nextLine();
                valid = true;
                choice = -1;
                try{
                    choice = Integer.parseInt(input);
                }
                catch(Exception e){
                    valid = false;
                }
                if(valid) { if(!(choice > 0 && choice <= 3)) { valid = false; } }
                if(!valid)
                {
                    System.out.println("Invalid input, please try again.");
                }
            }
            System.out.println("Choice: " + Integer.toString(choice));
            switch(choice)
            {
                case 1:
                    System.out.println("Enter actor's name:");
                    input = scanner.nextLine();
                    System.out.println("\nFinding movies with " + input + "...");
                    System.out.println(database.findMoviesWithActor(input));
                    break;
                case 2:
                    System.out.println("Enter search term:");
                    input = scanner.nextLine();
                    System.out.println("\nFinding movies with the word \"" + input + "\" in the title...");
                    System.out.println(database.search(input));
                    break;
                case 3:
                    System.out.println("Quitting!");
                    quit = true;
                    break;
            }
        }
        System.exit(0);
    }
    
    /**
    *  method that reads in movies (in raw format) from a file
    */
    private static List<String> readFile(String fileName)
    {
        // Location of file to read
        File file = new File(fileName);
        List<String> movies = new ArrayList<String>();
        
 
        try 
        {
 
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) 
            {
                
                movies.add(scanner.nextLine());
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        return movies;
    }
}