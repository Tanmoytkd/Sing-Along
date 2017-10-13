package com.example.tanmoykrishnadas.singalong;

import java.util.TreeMap;

/**
 * Created by Tanmoy Krishna Das on 13-Oct-17.
 */

public class SongCollector {
    public static void collectSongs(TreeMap<String, Songs> data) {
        Songs sunny = new Songs();
        sunny.insert("Fat Old Sun","Pink Floyd","fatoldsun");
        sunny.insert("Happy","Pharrell Williams","happy");
        sunny.insert("Shurjo","Aurtohin","shurjo");
        data.put("sunny", sunny);

        Songs rainy = new Songs();
        rainy.insert("E Bhara Badara","Ustaad Rashid Khan","bharabadar");
        rainy.insert("Brishti Tomake Dilam","Srikanta Acharya","brishtitomakedilam");
        rainy.insert("Raindrops Keep Falling On My Head","BJ Thomas","raindrops");
        data.put("rainy", rainy);

        Songs snowy = new Songs();
        snowy.insert("Born To Die","Lana Del Rey","borntodie");
        snowy.insert("Do You Wanna Build A Snowman","Agatha LeeMonn; Kristen Bell; Katie Lopez ","douwannabuildasnowman");
        snowy.insert("Pindare Polasher Bon","Wrong Tuli","pindarepolasherbon");
        data.put("snowy", snowy);

        Songs windy = new Songs();
        windy.insert("Megh Boleche Jabo Jabo","Arnob","meghboleche");
        windy.insert("Amar Mon Mojaiya Re","Shah Abdul Karim(remake by Habib feat Kaya","monmojaiya");
        windy.insert("While My Guitar Gently Weeps","The Beatles","whilemy");
        data.put("windy", windy);

        Songs general = new Songs();
        general.insert("TKD", "kdkddk", "porano");
        data.put("general", general);
    }
}
