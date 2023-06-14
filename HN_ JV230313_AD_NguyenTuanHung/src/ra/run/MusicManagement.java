package ra.run;
import java.util.Scanner;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.service.SingerService;
import ra.service.SongService;

public class MusicManagement {
    public static void main(String[] args) {
        SingerService singerService = new SingerService();
        SongService songService = new SongService(singerService);

        SingerController singerController = new SingerController(singerService);
        SongController songController = new SongController(songService, singerService);

        System.out.println("**********************MUSIC-MANAGEMENT*************************");

        while (true) {
            System.out.println("1. Singer Management");
            System.out.println("2. Song Management");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(new Scanner(System.in).nextLine());

            switch (option) {
                case 1:
                    singerController.displayMenu();
                    break;
                case 2:
                    songController.displayMenu();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

