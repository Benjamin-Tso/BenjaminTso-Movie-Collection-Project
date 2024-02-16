import java.awt.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
public class MovieCollectionRunner {
    public static void main(String[] args) {
        File f;
        ArrayList<String> movies = new ArrayList<>();
        Scanner readFile;
        try {
             f = new File("movies_data.csv");
             readFile = new Scanner(f);
             while(readFile.hasNextLine()){
                 movies.add(readFile.nextLine());
             }
             readFile.close();
             movies.remove(0);
        }catch(FileNotFoundException e){
            System.out.println("file not found");
            System.exit(1);
        }
        MovieCollection collection = new MovieCollection(movies.toArray(new String[0]));
        Scanner readUserInput = new Scanner(System.in);
        System.out.println("Welcome to the movie collection!");
        String menuOption = "";

        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = readUserInput.nextLine();

            if (menuOption.equals("t")) {
                System.out.print("Title: ");
                Movie[] searchedTitles= collection.searchTitles(readUserInput.nextLine());
                if(searchedTitles.length==0){
                    System.out.println("no matches");
                }
                else{
                    String[] titles = new String[searchedTitles.length];
                    for(int i = 0 ; i<searchedTitles.length;i++){
                        titles[i] = searchedTitles[i].getTitle();
                    }
                    Movie.insertionStringArrSort(titles);
                    for(int i = 0; i<titles.length;i++){
                        System.out.println((i+1)+". "+titles[i]);
                    }
                    boolean pick = false;
                    int titleNum = 0;
                    while(!pick){
                        try{
                            System.out.print("number: ");
                            titleNum = Integer.parseInt(readUserInput.nextLine());
                            if(titleNum> titles.length){
                                Integer.parseInt("too high");
                            }
                            pick = true;
                        }catch(NumberFormatException e){
                            System.out.println("invalid");
                        }
                    }
                    Movie choice = null;
                    for(Movie m : searchedTitles){
                        if(m.getTitle().equals(titles[titleNum-1])){
                            choice = m;
                        }
                    }
                    assert choice != null;
                    System.out.println("Title: "+choice.getTitle());
                    System.out.println("Runtime: "+choice.getRuntime());
                    System.out.println("Directed By: "+choice.getDirector());
                    System.out.println("Cast: "+ Arrays.toString(choice.getCast()).replaceAll("\\|",",").substring(1).replace("]",""));
                    System.out.println("User Rating: " + choice.getUserRating());
                    System.out.println();
                }
            } else if (menuOption.equals("c")) {
                System.out.print("Name: ");
                String[] searchedCast =  collection.searchCast(readUserInput.nextLine());
                if(searchedCast.length==0){
                    System.out.println("no matches");
                }
                else{
                    for(int i = 0; i<searchedCast.length;i++){
                        System.out.println((i+1)+". "+searchedCast[i].replace(',',' '));
                    }
                    boolean pick = false;
                    int actorNum = 0;
                    while(!pick){
                        try{
                            System.out.print("number: ");
                            actorNum = Integer.parseInt(readUserInput.nextLine());
                            if(actorNum> searchedCast.length){
                                Integer.parseInt("too high");
                            }
                            pick = true;
                        }catch(NumberFormatException e){
                            System.out.println("invalid");
                        }
                    }
                    Movie[] actorMovies = collection.actorMovies(searchedCast[actorNum-1].replace(',',' '));
                    String[] titles = new String[actorMovies.length];
                    for(int i = 0; i<titles.length;i++){
                        titles[i] = actorMovies[i].getTitle();
                    }
                    Movie.insertionStringArrSort(titles);
                    for(int i = 0; i<titles.length;i++){
                        System.out.println((i+1)+". "+titles[i]);
                    }
                    boolean pick2 = false;
                    int titleNum = 0;
                    while(!pick2){
                        try{
                            System.out.print("number: ");
                            titleNum = Integer.parseInt(readUserInput.nextLine());
                            if(titleNum> titles.length){
                                Integer.parseInt("too high");
                            }
                            pick2 = true;
                        }catch(NumberFormatException e){
                            System.out.println("invalid");
                        }
                    }
                    Movie choice = null;
                    for(Movie m : actorMovies){
                        if(m.getTitle().equals(titles[titleNum-1])){
                            choice = m;
                        }
                    }
                    assert choice != null;
                    System.out.println("Title: "+choice.getTitle());
                    System.out.println("Runtime: "+choice.getRuntime());
                    System.out.println("Directed By: "+choice.getDirector());
                    System.out.println("Cast: "+ Arrays.toString(choice.getCast()).replaceAll("\\|",",").substring(1).replace("]",""));
                    System.out.println("User Rating: " + choice.getUserRating());
                    System.out.println();
                }
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

    }
}
