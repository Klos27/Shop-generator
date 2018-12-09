package model;
import Util.RandomString;

import java.util.Random;

public class Adres {
    public long adres_id = 0;
    public String ulica;
    public int nr_domu;
    public String miejscowosc;
    public int kod_pocztowy;
    public String kraj;
    public String wojewodztwo;

    private static final Random rand = new Random();

    public static Adres generateAdres(){
        Adres adres = new Adres();
        adres.ulica = generateUlica();
        adres.nr_domu = generateNr_domu();
        adres.kod_pocztowy = generateKod_pocztowy();
        adres.kraj = generateKraj();
        adres.miejscowosc = generateMiasto();
        adres.wojewodztwo = generateWojewodztwo(adres.kraj);
        return adres;
    }

    public static String generateUlica() {
        RandomString randomString = new RandomString(rand.nextInt(16) + 4);
        return randomString.nextString();
    }

    public static int generateNr_domu() {
        return (rand.nextInt(1000) + 1);
    }

    public static int generateNr_mieszkania() {
        return (rand.nextInt(1000) + 1);
    }

    public static int generateKod_pocztowy() {
        return (rand.nextInt(99000) + 1000);
    }

    public static String generateMiasto() {
        RandomString randomString = new RandomString(rand.nextInt(16) + 4);
        return randomString.nextString();
    }

    public static String generateKraj() {
        String[] kraje = {
                "Polska",
                "Niemcy",
        };
        return kraje[rand.nextInt(2)];
    }

    public static String generateWojewodztwo(String kraj) {
        String[] wojewodztwaPL = {
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

        String[] wojewodztwaDE = {
                "Baden-Wurttemberga",
                "Bayern",
                "Berlin",
                "Brandenburg",
                "Bremen",
                "Hamburg",
                "Hessen",
                "Mecklenburg-Vorpommern",
                "Niedersachsen",
                "Nordrhein-Westfalen",
                "Rheinland-Pfalz",
                "Saarland",
                "Sachsen",
                "Sachsen-Anhalt",
                "Schleswig-Holstein",
                "Thuringen"
        };
        return kraj.equals("Polska") ?  wojewodztwaPL[rand.nextInt(16)] : wojewodztwaDE[rand.nextInt(16)];
    }
}
