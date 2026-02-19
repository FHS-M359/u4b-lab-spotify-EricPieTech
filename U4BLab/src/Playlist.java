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
            if(!songs.get(i).getGenre().equalsIgnoreCase(input))
                songs.remove(i);
        if(songs.isEmpty())
            System.out.println("There are no " + input + " songs in the playlist.");
    }
    public static void sortA_Z(){ //fix
        for(int i = 0; i < songs.size()-1; i++){
            int minIndex = i;
            for(int j = i+1; j < songs.size(); j++) {
                String str1 = songs.get(i).getArtist().substring(0,1);
                String str2 = songs.get(j).getArtist().substring(0,1);
                if (str1.compareTo(str2) <= minIndex)
                    minIndex = j;
            }
            songs.set(minIndex, songs.set(i, songs.get(minIndex)));
        }
    }
    public static void sortZ_A(){

    }
    public static void sortNew_Old(){

    }
    public static void sortOld_New(){

    }
    public String toString() {
        String output = "Title                     Artist                    Album                          Year  Genre\n";
        output += "----------------------------------------------------------------------------------------------------\n";
        for(Song s : songs)
            output += s + "\n";
        return (output);
    }
}