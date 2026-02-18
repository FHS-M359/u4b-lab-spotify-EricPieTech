import java.io.*;
import java.util.*;
public class SpotifyTester {
    private static final int a_z = 1;
    private static final int z_a = 2;
    private static final int new_old = 3;
    private static final int old_new = 4;
    private static final int genre = 5;
    private static final int all = 6;
    private static final int quit = 7;
    private static boolean running = true;
    private static int choice = -1;
    static Scanner inSys = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
        while(running){
            System.out.println(" === Spotify Menu === \n1. Sort by artist (A -> Z)\n2. Sort by artist (Z -> A)");
            System.out.println("3. Sort by year (New -> Old)\n4. Sort by year (Old -> New)\n5. Sort by genre");
            System.out.println("6. Display All Songs\n7. Close App");
            try{
                choice = inSys.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid Input. Please enter numbers only.");
                inSys.nextLine();
            }
            if(choice < 1 || choice > 7)
                System.out.println("Please enter a number between 1-7.");
            if(choice >= 1 && choice <= 7)
                runMenu();
        }
        inSys.close();
    }
    private static void runMenu() throws FileNotFoundException {
        Playlist p = new Playlist();
        Playlist.readSongs();
        if (choice == a_z) {
            Playlist.sortByArtist("a-z");
            System.out.println(p);
        }
        if (choice == z_a) {
            Playlist.sortByArtist("z-a");
            System.out.println(p);
        }
        if (choice == new_old) {
            Playlist.sortByReleaseYear("new-old");
            System.out.println(p);
        }
        if (choice == old_new) {
            Playlist.sortByReleaseYear("old-new");
            System.out.println(p);
        }
        if (choice == genre) {
            System.out.println("Enter genre to search by:");
            inSys.nextLine();
            Playlist.sortByGenre(inSys.nextLine());
            if(p.toString().length() > 103){//fix
                System.out.println(p);
            }
        }
        if (choice == all)
            System.out.println(p);
        if (choice == quit) {
            running = false;
        }
    }
}
