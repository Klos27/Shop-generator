package model;

import Util.RandomString;

import java.util.Random;

public class Uzytkownik {
    public long uzytkownik_id = 0;
    public String imie;
    public String nazwisko;
    public String email;
    public String telefon;
    public String plec;
    public int typ;

    public static Uzytkownik generateUzytkownik(){
        Uzytkownik uzytkownik = new Uzytkownik();
        uzytkownik.imie = generateImie();
        uzytkownik.nazwisko = generateNazwisko();
        uzytkownik.email = generateEmail(uzytkownik);
        uzytkownik.telefon = generateTelefon();
        uzytkownik.plec = generatePlec();
        uzytkownik.typ = generateTyp();
        return uzytkownik;
    }

    public static String generateImie(){
        RandomString randomString = new RandomString(new Random().nextInt(16) + 4);
        return randomString.nextString();
    }
    public static String generateNazwisko(){
        RandomString randomString = new RandomString(new Random().nextInt(16) + 4);
        return randomString.nextString();
    }
    public static String generateEmail(Uzytkownik user){
        return user.imie + "." + user.nazwisko + "@email.com";
    }
    public static String generateTelefon(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("48");
        sb.append(rand.nextInt(9) + 1);
        for(int i = 0; i < 8; i++)
            sb.append(rand.nextInt(10));
        return sb.toString();
    }
    public static String generatePlec(){
        Random rand = new Random();
        String[] plec = {"male", "female"};
        return plec[rand.nextInt(2)];
    }
    public static int generateTyp(){
        return 1;
    }
}
