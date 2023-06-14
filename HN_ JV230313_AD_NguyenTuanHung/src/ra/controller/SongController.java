package ra.controller;

import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class SongController {
    private SongService songService;
    private SingerService singerService;

    public SongController(SongService songService, SingerService singerService) {
        this.songService = songService;
        this.singerService = singerService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Add new song");
            System.out.println("2. Display all songs");
            System.out.println("3. Update song");
            System.out.println("4. Delete song");
            System.out.println("5. Search songs by singer or genre");
            System.out.println("6. Search singers by name or genre");
            System.out.println("7. Display songs by ascending name");
            System.out.println("8. Display latest songs");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    songService.addSong();
                    break;
                case 2:
                    songService.displaySongs();
                    break;
                case 3:
                    System.out.print("Enter song ID: ");
                    String songId = scanner.nextLine();
                    songService.updateSong(songId);
                    break;
                case 4:
                    System.out.print("Enter song ID: ");
                    songId = scanner.nextLine();
                    songService.deleteSong(songId);
                    break;
                case 5:
                    System.out.print("Enter singer or genre keyword: ");
                    String keyword = scanner.nextLine();
                    songService.searchBySingerOrGenre(keyword);
                    break;
                case 6:
                    System.out.print("Enter singer or genre keyword: ");
                    keyword = scanner.nextLine();
                    songService.searchSingerByNameOrGenre(keyword);
                    break;
                case 7:
                    songService.displaySongsByAscendingName();
                    break;
                case 8:
                    songService.displayLatestSongs();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
