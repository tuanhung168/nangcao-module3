package ra.service;

import ra.model.Singer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingerService {
    private List<Singer> singers;

    public SingerService() {
        singers = new ArrayList<>();
    }

    public void addSinger() {
        Singer singer = new Singer();
        singer.inputData();
        singers.add(singer);
        System.out.println("Singer added successfully.");
    }

    public void displaySingers() {
        if (singers.isEmpty()) {
            System.out.println("No singers available.");
        } else {
            System.out.println("Singer List:");
            for (Singer singer : singers) {
                singer.displayData();
                System.out.println("----------------------");
            }
        }
    }

    public void updateSinger(int singerId) {
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                singer.inputData();
                System.out.println("Singer updated successfully.");
                return;
            }
        }
        System.out.println("Singer not found.");
    }

    public void deleteSinger(int singerId) {
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                if (hasSongs(singerId)) {
                    System.out.println("Cannot delete singer. Singer has associated songs.");
                } else {
                    singers.remove(singer);
                    System.out.println("Singer deleted successfully.");
                }
                return;
            }
        }
        System.out.println("Singer not found.");
    }

    private boolean hasSongs(int singerId) {
        return false;
    }

    public Singer getSingerById(String singerId) {
        return null;
    }

}
