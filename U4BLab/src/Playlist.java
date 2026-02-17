import java.io.*;
import java.util.*;
public class Playlist{
    private static ArrayList<Song> songs = new ArrayList<>();
    public Playlist(){
    }
    public static void readSongs() throws FileNotFoundException{
        Scanner inFile = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));
        while(inFile.hasNextLine()){
            String[] temp = inFile.nextLine().split(",");
            Song tempSong = new Song(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5]);
            songs.add(tempSong);
        }
        inFile.close();
    }
    public static void sortByGenre(String input){
        for(int i = songs.size()-1; i >= 0; i--)
            if(!songs.get(i).getGenre().equalsIgnoreCase(input)){
                songs.remove(i);
            }
    }
    public static void sortByArtist(String direction){

    }
    public static void sortByReleaseYear(String direction){

    }
    public String toString() {
        String output = "Title                     Artist                    Album                          Year  Genre\n";
        output += "----------------------------------------------------------------------------------------------------\n";
        for(Song s : songs)
            output += s + "\n";
        return (output);
    }
}