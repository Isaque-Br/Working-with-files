package application;

import entities.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> List = new ArrayList<>(); // List of Products

        System.out.println("Enter file path: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr); // File object created
        String sourceFolderStr = sourceFile.getParent(); // Extracting the path of the folder that contains the file

        boolean success = new File(sourceFolderStr + "/out").mkdirs(); // Creating a folder inside the folder that contains the file

        String targetFileStr = sourceFolderStr + "/out/summary.csv"; // Creating a file inside the folder that contains the file
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

            String itemCsv = br.readLine(); // Reading the file
            while (itemCsv != null) { // Enquanto não item nao for null ele vai ler o arquivo

                String[] fields = itemCsv.split(","); // Quebrando linha e Separando os campos por virgula
                String name = fields[0]; // Pegando o primeiro campo nome
                double price = Double.parseDouble(fields[1]); // Pegando o segundo campo preço
                int quantity = Integer.parseInt(fields[2].trim()); // Pegando o terceiro campo quantidade

                List.add(new Product(name, price, quantity)); // Adicionando os campos na lista

                itemCsv = br.readLine(); // passando para a proxima linha
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product item : List) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());

            sc.close();
        }
    }
}



// /Users/zaki/DEV-IZAK/WORKING-WITH-FILES/ExercicioProposto/input.csv


// TV LED, 1290.99, 1
// Video Game Chair, 350.50, 3
// Iphone X, 900.00, 2
// Samsung Galaxy 9, 850.00, 2