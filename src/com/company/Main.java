package com.company;

class Covek {
    private String ime;

    public void imenuvaj(String ime) {
        this.ime = ime;
    }

    public String citajIme() {
        return ime;
    }
    public String toString() {
        return ime;
    }
}

class Ocenka {
    private int ocenka;
    private String predmet;
    private String datum;

    public void setOcenka(int ocenka, String predmet, String datum) {
        this.ocenka = ocenka;
        this.predmet = predmet;
        this.datum = datum;
    }

    public int citajOcenka() {
        return ocenka;
    }
    public String toString() {
        return Integer.toString(ocenka);
    }
}

class Student extends Covek {
    private Ocenka[] ocenki = new Ocenka[10];
    private int momentalnoOcenki = 0;

    public void setOcenka(int ocenka, String predmet, String datum) {
        Ocenka newOcenka = new Ocenka();
        newOcenka.setOcenka(ocenka, predmet, datum);
        this.ocenki[momentalnoOcenki] = newOcenka;
        momentalnoOcenki += 1;
    }

    public float getProsek() {
        int vkupno = 0;
        for(int i=0; i<momentalnoOcenki; i++) {
            vkupno += ocenki[i].citajOcenka();
        }

        float rezultat = (float)vkupno / momentalnoOcenki;
        return rezultat;
    }
}

public class Main {

    public static void main(String[] args) {
        Student bozhidar = new Student();
        bozhidar.imenuvaj("Bozhidar");

        bozhidar.setOcenka(5, "Matematika", "15.05.2021");
        bozhidar.setOcenka(10, "Programiranje", "15.05.2021");
        bozhidar.setOcenka(8, "Angliski", "15.05.2021");

        System.out.println(bozhidar.getProsek());
    }
}
