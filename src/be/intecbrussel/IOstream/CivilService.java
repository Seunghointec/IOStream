package be.intecbrussel.IOstream;

import java.io.*;

public class CivilService implements Serializable {
    public static void main(String[] args) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/seunghokang/Downloads/folder/Maternity.txt"))) {
            Person person;
            while ((person = (Person) objectInputStream.readObject()) !=null) {
                System.out.println(person);
            }
            System.in.read();
        } catch (EOFException ex) {
            System.out.println("End of the file");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException | IOException cfe) {
            cfe.printStackTrace();
        }
    }
}