package application;

import java.io.File;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file path: ");
        String strPath = scanner.nextLine();

        File path = new File(strPath);

        System.out.println("getName: " + path.getName());// retorna o nome do arquivo
        System.out.println("getParent: " + path.getParent());// retorna o caminho do arquivo
        System.out.println("getPath: " + path.getPath());// retorna o caminho do arquivo

        scanner.close();
    }
}


