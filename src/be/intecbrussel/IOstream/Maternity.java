package be.intecbrussel.IOstream;

import java.io.*;
import java.time.LocalDate;

public class Maternity implements Serializable {
    public static void main(String[] args) {

        Person person = new Person("Kang", "Seungho", LocalDate.of(1975, 9, 21));
        Person person1 = new Person("Lee", "kyungMi", LocalDate.of(1981, 5,27));
        System.out.println(person.getBirthDay());
        System.out.println(person.getLastName());
        System.out.println(person.getFirstName());
        person1.setBirthDay(LocalDate.of(1981,5,27));
        person1.setFirstName("kyungMi");
        person1.setLastName("Lee");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/seunghokang/Downloads/folder/Maternity.txt"))) {
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(person1);
            System.in.read(); //output * per second until we stop the program
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}