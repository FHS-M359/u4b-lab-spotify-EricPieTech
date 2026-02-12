public class Song {
    private String title, artist, album, genre;
    private int year, duration;
    public Song(String title, String artist, String album, int duration, int year, String genre){
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.year = year;
        this.genre = genre;
    }
    public String toString(){
        return(String.format("%-25s %-25s %-30s %-5d %-10s", title, artist, album, year, genre));
    }
}
