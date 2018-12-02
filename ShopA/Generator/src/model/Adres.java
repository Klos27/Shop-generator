package model;
import Util.RandomString;

import java.util.Random;

public class Adres {
    public long adres_id = 0;
    public String ulica;
    public int nr_domu;
    public int nr_mieszkania;
    public int kod_pocztowy;
    public String miasto;
    public String wojewodztwo;

    public static Adres generateAdres(){
        Adres adres = new Adres();
        adres.ulica = generateUlica();
        adres.nr_domu = generateNr_domu();
        adres.nr_mieszkania = generateNr_mieszkania();
        adres.kod_pocztowy = generateKod_pocztowy();
        adres.miasto = generateMiasto();
        adres.wojewodztwo = generateWojewodztwo();
        return adres;
    }

    public static String generateUlica() {
        RandomString randomString = new RandomString(new Random().nextInt(16) + 4);
        return randomString.nextString();
    }

    public static int generateNr_domu() {
        return (new Random().nextInt(1000) + 1);
    }

    public static int generateNr_mieszkania() {
        return (new Random().nextInt(1000) + 1);
    }

    public static int generateKod_pocztowy() {
        return (new Random().nextInt(99000) + 1000);
    }

    public static String generateMiasto() {
        RandomString randomString = new RandomString(new Random().nextInt(16) + 4);
        return randomString.nextString();
    }

    public static String generateWojewodztwo() {
        Random rand = new Random();
        String[] wojewodztwa = {
                "dolnośląskie",
                "kujawsko-pomorskie",
                "lubelskie",
                "lubuskie",
                "łódzkie",
                "małopolskie",
                "mazowieckie",
                "opolskie",
                "podkarpackie",
                "podlaskie",
                "pomorskie",
                "śląskie",
                "świętokrzyskie",
                "warmińsko-mazurskie",
                "wielkopolskie",
                "zachodniopomorskie"
        };
        return wojewodztwa[rand.nextInt(16)];
    }
}
