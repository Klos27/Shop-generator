package model;

import Util.RandomString;

import java.util.Random;

public class Produkt {
    public long Produkt_id;
    public int kategoria_producent_id;
    public String nazwa;
    public int cena;
    public String opis;

    public static String randomOpis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis varius, ipsum sed suscipit sollicitudin, leo nisl semper lacus, volutpat varius metus ipsum quis nunc. Integer turpis turpis, sodales ac metus in, pharetra ullamcorper quam. Aliquam quis lectus dictum, elementum est ac, ornare urna. Suspendisse vehicula egestas ligula, vitae sodales sapien sagittis quis. Suspendisse potenti. Etiam vel lobortis elit, vitae facilisis arcu. Sed at congue augue. Vivamus sem magna, varius eu magna sed, mattis semper nisi. Donec a velit fermentum, aliquet odio quis, semper libero. Nullam dictum arcu in tellus pretium, vitae mattis nisl hendrerit. Proin fringilla dignissim orci, id eleifend urna laoreet id. Nulla condimentum tortor sapien, eu ullamcorper nisi maximus eu. Proin rhoncus pretium facilisis. Vivamus diam libero, viverra eu congue ut, finibus quis nisi. Suspendisse vitae pellentesque massa. Curabitur molestie erat a erat eleifend, ac molestie dolor sodales." +
            "In rhoncus ipsum at elit scelerisque, sit amet egestas libero lacinia. Duis dolor arcu, ornare at ligula sit amet, tempor maximus quam. Nulla rhoncus purus vel arcu tempor tempus. Duis a interdum mi, ac aliquam purus. Morbi ac metus porttitor, feugiat massa eget, ultrices elit. In ullamcorper sed justo vitae condimentum. Vestibulum turpis leo, ultricies malesuada nulla eu, vehicula ullamcorper dui. Phasellus sodales augue eros, quis sollicitudin turpis bibendum sed." +
            "Morbi non dolor pharetra, dignissim nisi nec, convallis purus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vivamus dignissim turpis vel neque eleifend hendrerit. Praesent mi leo, sollicitudin et fermentum at, luctus ac ipsum. Cras vestibulum purus eu felis pharetra, eu rutrum nunc pretium. Aliquam tellus purus, vehicula ac eleifend ut, pharetra sit amet purus.";
    public static Produkt generateProdukt(int iloscKategorii){
        Produkt produkt = new Produkt();
        produkt.kategoria_producent_id = new Random().nextInt(iloscKategorii) + 1;
        produkt.nazwa = generateNazwa();
        produkt.cena = generateCena();
        produkt.opis = generateOpis();
        return produkt;
    }

    public static String generateNazwa() {
        RandomString randomString = new RandomString(new Random().nextInt(26) + 4);
        return randomString.nextString();
    }

    public static int generateCena() {
        return (new Random().nextInt(10000) + 1);
    }

    public static String generateOpis() {
        Random rand = new Random();
        int length2 = rand.nextInt(100) + 10;
        int start = rand.nextInt(length2);
        int end = length2 + rand.nextInt(length2);

        return randomOpis.substring(start,end);
    }

    public static int generateStan() {
        return (new Random().nextInt(1000));
    }

    public static int generateKategoria(int iloscKategorii){
        return (new Random().nextInt(iloscKategorii) + 1);
    }
}
