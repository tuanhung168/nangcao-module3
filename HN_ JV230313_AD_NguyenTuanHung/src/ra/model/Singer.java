package ra.model;

import java.util.Scanner;

public class Singer {
    private static int singerCount = 0;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        singerCount++;
        this.singerId = singerCount;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter singer name: ");
        singerName = scanner.nextLine();

        System.out.print("Enter age: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter nationality: ");
        nationality = scanner.nextLine();

        System.out.print("Enter gender (true for male, false for female): ");
        gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Enter genre: ");
        genre = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Singer ID: " + singerId);
        System.out.println("Singer Name: " + singerName);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Gender: " + (gender ? "Male" : "Female"));
        System.out.println("Genre: " + genre);
    }
}
