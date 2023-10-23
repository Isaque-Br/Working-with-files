package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

    public static void main(String[] args) {

    String path = "/Users/zaki/DEV-IZAK/WORKING-WITH-FILES/test.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) { // INSTANCIANDO O OBJETO BR COMO FILE READER E PASSANDO O PATH COMO ARGUMENTO
            String line = br.readLine(); // LENDO A PRIMEIRA LINHA DO ARQUIVO

            while (line != null) { // ENQUANTO A LINHA NÃO FOR NULA
                System.out.println(line); // IMPRIMIR A LINHA
                line = br.readLine(); // LER A PRÓXIMA LINHA
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


// BLOCO TRY WITH RESOURCES
// O BLOCO TRY WITH RESOURCES É UMA ESTRUTURA QUE GARANTE QUE O OBJETO INSTANCIADO DENTRO DOS PARÊNTESES DO TRY SEJA FECHADO AUTOMATICAMENTE APÓS O FIM DO BLOCO TRY