import java.io.*;
import java.util.*;
public class SpotifyTester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inSys = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println(" === Spotify Menu === \n1. Sort by artist (A -> Z)\n2. Sort by artist (Z -> A)");
            System.out.println("3. Sort by year (New -> Old)\n4. Sort by year (Old -> New)\n5. Sort by genre");
            System.out.println("6. Display All Songs\n 7. Close App");
            break; //remove
        }

            Playlist p = new Playlist();
        Playlist.readSongs();
        System.out.println(p);
    }
}
