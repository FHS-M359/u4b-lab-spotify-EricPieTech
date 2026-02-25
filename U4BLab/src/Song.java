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
    /**
     * Formats and returns the song object as a String
     * @return the song as a properly formatted String
     */
    public String toString(){
        return(String.format("%-25s %-25s %-30s %-5d %-10s", title, artist, album, year, genre));
    }
    public int getYear() {
        return year;
    }
    public String getGenre() {
        return genre;
    }
    public String getArtist() {
        return artist;
    }
}
