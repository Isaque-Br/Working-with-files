package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory); // File::isDirectory is a method reference

        System.out.println("FOLDERS: ");
        for (File folder : folders) {
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile); // File::isFile is a method reference
        System.out.println("FILES: ");
        for (File file : files) {
            System.out.println(file);
        }

        boolean success = new File(strPath + "\\subdir").mkdir(); // Creating a new folder
        System.out.println("Directory created successfully: " + success);
        sc.close();
    }
}