package ra.service;
import java.util.Comparator;

import ra.model.Song;

import java.util.ArrayList;
import java.util.List;


public class SongService {
    private List<Song> songs;
    private SingerService singerService;

    public SongService(SingerService singerService) {
        songs = new ArrayList<>();
        this.singerService = singerService;
    }

    public void addSong() {
        SingerService singerService = new SingerService();
        Song song = new Song();
        song.inputData(singerService);
        System.out.println("Song added successfully.");
    }

    public void displaySongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            System.out.println("Song List:");
            for (Song song : songs) {
                song.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void updateSong(String songId) {
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                song.inputData(singerService);
                System.out.println("Song updated successfully.");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    public void deleteSong(String songId) {
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                songs.remove(song);
                System.out.println("Song deleted successfully.");
                return;
            }
        }
        System.out.println("Song not found.");
    }

    public void searchBySingerOrGenre(String keyword) {
        System.out.println("Search results:");
        for (Song song : songs) {
            if (song.getSinger().getSingerName().equalsIgnoreCase(keyword) ||
                    song.getSinger().getGenre().equalsIgnoreCase(keyword)) {
                song.displayData();
                System.out.println("----------------------");
            }
        }
    }



    public void displaySongsByAscendingName() {
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            songs.sort(Comparator.comparing(Song::getSongName));
            System.out.println("Songs sorted by name in ascending order:");
            for (Song song : songs) {
                System.out.println("Song Name: " + song.getSongName());
                System.out.println("Singer: " + song.getSinger().getSingerName());
                System.out.println("----------------------");
            }
        }
    }

    public void displayLatestSongs() {
        if (songs.isEmpty()) {
            System.out.println("No songs available.");
        } else {
            songs.sort(Comparator.comparing(Song::getCreatedDate).reversed());
            int count = 0;
            System.out.println("Latest Songs:");
            for (Song song : songs) {
                System.out.println("Song Name: " + song.getSongName());
                System.out.println("Singer: " + song.getSinger().getSingerName());
                System.out.println("----------------------");
                count++;
                if (count == 10) {
                    break;
                }
            }
        }
    }


    public void searchSingerByNameOrGenre(String keyword) {
        System.out.println("Search results:");
        boolean found = false;
        for (Song song : songs) {
            if (song.getSinger().getSingerName().equalsIgnoreCase(keyword) ||
                    song.getSinger().getGenre().equalsIgnoreCase(keyword)) {
                System.out.println("Song Name: " + song.getSongName());
                System.out.println("Singer: " + song.getSinger().getSingerName());
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No songs found for the given singer or genre.");
        }
    }
}
