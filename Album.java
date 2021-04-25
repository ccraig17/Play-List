import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title)==null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song checkSong : this.songs) {
            if (checkSong.getTitle().equals(title)) {
                return checkSong;
            }
        }
        return null;
    }
    //create two overloaded Methods to add songs via Track Number and title.
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber-1;
        if(index >=0 && index <=playList.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("The Album does not have " + trackNumber);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if(checkedSong !=null){
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The playlist does not contain " + title);
        return false;
    }
}
