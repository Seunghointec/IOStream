package be.intecbrussel.IOstream.Exercise1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExerciseApp {

    public static void main(String[] args) {
        //created Path for working directory and file
        Path pathOfFile = Path.of("/Users/seunghokang/Downloads/folder/FromSeunghoToPearl/message.txt");
        Path pathOfFileAnimal = Path.of("/Users/seunghokang/Downloads/folder/FromSeunghoToPearl/Animal.txt");

        try {
            Files.createDirectories(pathOfFile.getParent());
            System.out.println("Directory is created!");

            if ((Files.notExists(pathOfFile) || (Files.notExists(pathOfFileAnimal)))) {
                Files.createFile(pathOfFile);
                Files.createFile(pathOfFileAnimal);
                System.out.println("A File has been created");
            } else {
                System.out.println("This file is already there.");
            }

        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }


        try (FileWriter fileWriter = new FileWriter(String.valueOf(pathOfFile));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write("Hello\n");
                bufferedWriter.write("People");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader =
                     new FileReader(String.valueOf(pathOfFile))) {
            BufferedReader bufferedReader = new BufferedReader (fileReader);
            String line;
            while ((line = bufferedReader.readLine()) !=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Animal animal = new Animal("Amoeba proteus", false);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/seunghokang/Downloads/folder/FromSeunghoToPearl/Animal.txt"))) {
            objectOutputStream.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/seunghokang/Downloads/folder/FromSeunghoToPearl/Animal.txt"))) {
            while ((animal = (Animal) objectInputStream.readObject()) !=null) {
                System.out.println(animal);
            }
        } catch (EOFException ex) {
            System.out.println("End of the file");
        } catch (ClassNotFoundException | IOException cfe) {
            cfe.printStackTrace();
        }
    }
}