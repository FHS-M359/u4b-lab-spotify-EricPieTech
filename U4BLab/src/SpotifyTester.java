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
                System.out.println();
            }
            if(choice < 1 || choice > 7)
                System.out.println("Please enter a number between 1-7.\n");
            if(choice >= 1 && choice <= 7)
                runMenu();
        }
        inSys.close();
    }
    /**
     * Helper method that runs different Playlist methods depending on the user's input
     * @throws FileNotFoundException
     */
    private static void runMenu() throws FileNotFoundException {
        Playlist p = new Playlist();
        Playlist.readSongs();
        if (choice == a_z) {
            Playlist.sortA_Z();
            System.out.println(p);
        }
        if (choice == z_a) {
            Playlist.sortZ_A();
            System.out.println(p);
        }
        if (choice == new_old) {
            Playlist.sortNew_Old();
            System.out.println(p);
        }
        if (choice == old_new) {
            Playlist.sortOld_New();
            System.out.println(p);
        }
        if (choice == genre) {
            System.out.println("Enter genre to search by:");
            inSys.nextLine();
            Playlist.sortByGenre(inSys.nextLine());
            if(p.toString().length() > 196){
                System.out.println(p);
            }
            else
                System.out.println();
        }
        if (choice == all)
            System.out.println(p);
        if (choice == quit) {
            running = false;
        }
    }
}