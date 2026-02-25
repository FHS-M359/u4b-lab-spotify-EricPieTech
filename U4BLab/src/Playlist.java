import java.io.*;
import java.util.*;
public class Playlist{
    private static ArrayList<Song> songs = new ArrayList<>();
    public Playlist(){}
    /**
     * Reads in the data from the text file formats it as an ArrayList of Song objects
     * @throws FileNotFoundException
     */
    public static void readSongs() throws FileNotFoundException{
        songs = new ArrayList<>();
        Scanner inFile = new Scanner(new File("U4BLab/spotify_unique_years_artists.txt"));
        while(inFile.hasNextLine()){
            String[] temp = inFile.nextLine().split(",");
            Song tempSong = new Song(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), temp[5]);
            songs.add(tempSong);
        }
        inFile.close();
    }
    /**
     * Uses a linear search to remove all songs from the list that do not match with the specified genre
     * @param input A String containing the genre to sort by
     */
    public static void sortByGenre(String input){
        for(int i = songs.size()-1; i >= 0; i--)
            if(!songs.get(i).getGenre().equalsIgnoreCase(input))
                songs.remove(i);
        if(songs.isEmpty())
            System.out.println("There are no " + input + " songs in the playlist.");
    }
    /**
     * Uses selection sort to rearrange the list to display the artists by name from A to Z
     */
    public static void sortA_Z(){
        for(int i = 0; i < songs.size()-1; i++){
            int minIndex = i;
            for(int j = i+1; j < songs.size(); j++) {
                String str1 = songs.get(j).getArtist();
                String str2 = songs.get(minIndex).getArtist();
                if(str1.compareToIgnoreCase(str2) <= 0)
                    minIndex = j;
            }
            songs.set(minIndex, songs.set(i, songs.get(minIndex)));
        }
    }
    /**
     * Uses selection sort to rearrange the list to display the artists by name from Z to A
     */
    public static void sortZ_A(){
        for(int i = 0; i < songs.size()-1; i++){
            int minIndex = i;
            for(int j = i+1; j < songs.size(); j++) {
                String str1 = songs.get(j).getArtist();
                String str2 = songs.get(minIndex).getArtist();
                if(str1.compareToIgnoreCase(str2) >= 0)
                    minIndex = j;
            }
            songs.set(minIndex, songs.set(i, songs.get(minIndex)));
        }
    }
    /**
     * Uses insertion sort to rearrange the list by the year the songs were released from newest to oldest
     */
    public static void sortNew_Old(){
        for(int i = 1; i < songs.size(); i++){
            Song temp = songs.get(i);
            int pos = i;
            while(pos > 0 && songs.get(pos-1).getYear() < temp.getYear()){
                songs.set(pos, songs.get(pos-1));
                pos--;
            }
            songs.set(pos, temp);
        }
    }
    /**
     * Uses insertion sort to rearrange the list by the year the songs were released from oldest to newest
     */
    public static void sortOld_New(){
        for(int i = 1; i < songs.size(); i++){
            Song temp = songs.get(i);
            int pos = i;
            while(pos > 0 && songs.get(pos-1).getYear() > temp.getYear()){
                songs.set(pos, songs.get(pos-1));
                pos--;
            }
            songs.set(pos, temp);
        }
    }
    /**
     * Formats and returns the playlist object as a String
     * @return the playlist as a properly formatted String
     */
    public String toString() {
        String output = "Title                     Artist                    Album                          Year  Genre\n";
        output += "----------------------------------------------------------------------------------------------------\n";
        for(Song s : songs)
            output += s + "\n";
        return (output);
    }
}