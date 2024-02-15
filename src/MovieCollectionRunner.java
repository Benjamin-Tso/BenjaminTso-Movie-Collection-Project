import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
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
             movies.remove(1);
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
                System.out.println("");
                collection.searchTitles(readUserInput.nextLine());
            } else if (menuOption.equals("c")) {
                System.out.println("");
                collection.searchCast(readUserInput.nextLine());
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }

    }
}
