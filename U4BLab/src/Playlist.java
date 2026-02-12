import java.io.*;
import java.util.*;
public class Playlist{
    static ArrayList<Song> songs = new ArrayList<>();
    public static void readSongs() throws FileNotFoundException{
        Scanner inFile = new Scanner(new File("spotify_unique_years_artists.txt"));
        while(inFile.hasNextLine()){
            String[] temp = inFile.nextLine().split(",");
            Song tempSong = new Song(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5]);
            songs.add(tempSong);
        }
        inFile.close();
    }
    public void printList(ArrayList<Song> input){

    }
}