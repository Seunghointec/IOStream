package be.intecbrussel.IOstream;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Person implements Serializable {

    private LocalDate birthDay; //something very personal don't want to show (i.e. sensitive) ignore the print
    private String lastName;
    private String firstName;
    private transient Timer heartbeat;

    public Person(String lastName, String firstName, LocalDate birthDay) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDay = birthDay;
        heartbeat = new Timer(true);
        heartbeat.scheduleAtFixedRate(new HeartBeat(), 0,10000);
    }

    private class HeartBeat extends TimerTask  {
        @Override
        public void run() {
            System.out.println("*");
        }
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthDay +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}





