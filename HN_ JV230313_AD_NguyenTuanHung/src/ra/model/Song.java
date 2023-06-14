package ra.model;

import ra.service.SingerService;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(SingerService singerService) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter song ID: ");
        songId = scanner.nextLine();

        System.out.print("Enter song name: ");
        songName = scanner.nextLine();

        System.out.print("Enter descriptions: ");
        descriptions = scanner.nextLine();

        System.out.println("Select singer by ID:");
        singerService.displaySingers();
        String singerId = scanner.nextLine();
        singer = singerService.getSingerById(singerId);

        System.out.print("Enter song writer: ");
        songWriter = scanner.nextLine();

        createdDate = new Date();

        System.out.print("Enter song status (true for active, false for inactive): ");
        songStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("Song ID: " + songId);
        System.out.println("Song Name: " + songName);
        System.out.println("Descriptions: " + descriptions);
        System.out.println("Singer: " + singer.getSingerName());
        System.out.println("Song Writer: " + songWriter);
        System.out.println("Created Date: " + createdDate);
        System.out.println("Song Status: " + (songStatus ? "Active" : "Inactive"));
    }


}
