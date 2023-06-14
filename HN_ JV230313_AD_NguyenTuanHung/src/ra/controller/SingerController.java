package ra.controller;

import ra.service.SingerService;

import java.util.Scanner;

public class SingerController {
    private SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Add new singer");
            System.out.println("2. Display all singers");
            System.out.println("3. Update singer");
            System.out.println("4. Delete singer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    singerService.addSinger();
                    break;
                case 2:
                    singerService.displaySingers();
                    break;
                case 3:
                    System.out.print("Enter singer ID: ");
                    int singerId = Integer.parseInt(scanner.nextLine());
                    singerService.updateSinger(singerId);
                    break;
                case 4:
                    System.out.print("Enter singer ID: ");
                    singerId = Integer.parseInt(scanner.nextLine());
                    singerService.deleteSinger(singerId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

