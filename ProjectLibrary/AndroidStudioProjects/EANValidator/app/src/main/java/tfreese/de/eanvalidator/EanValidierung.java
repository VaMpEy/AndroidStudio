package tfreese.de.eanvalidator;

/**
 * EAN Validierung
 *
 * Prüfziffernrechner
 * https://www.gs1-germany.de/serviceverzeichnis/pruefziffernrechner/
 * 
 * Beispiele:
 * 4012700963109 Pelikan Textmarker 440 Blau
 * 5449000017888 Coca Cola, 1 Liter
 * 9783446426634 Grundkurs Programmieren in Java
 * 
 * siehe auch http://www.codecheck.info
 * 
 * @author Thomas Freese
 * @version 16.01.2018
 */
public class EanValidierung {

    public static void main(String[] args) {
        long ean;
//        ean = 54_49000_01788_8L; // gültig
//        ean = 40_12700_96130_9L; // ungültig! = 3
//        ean = 40_44836_46263_5L; // ungültig! = 8
//        ean = 97_83446_42663_4L; // gültig
        ean = 40_04870_00162_0L; // gültig!  
        
        int pruefziffer = 0;

        String eanStr = String.valueOf(ean);
        if (eanStr.length() == 13) {
            int summe1 = 0;
            int summe2 = 0;
            int gesamtsumme = 0;

            for (int i = 0; i < eanStr.length() - 1; i += 2) {
                summe1 += Character.getNumericValue(eanStr.charAt(i));
//                summe1 += eanStr.charAt(i) - 48;
                summe2 += Character.getNumericValue(eanStr.charAt(i + 1));
            }

            gesamtsumme = summe1 + summe2 * 3;
//            int naechsteDurch10teilbareZahl = gesamtsumme + 9 - (gesamtsumme + 9) % 10;
//            pruefziffer = naechsteDurch10teilbareZahl - gesamtsumme;
            pruefziffer = (10 - gesamtsumme % 10) % 10;

            System.out.print("Die EAN " + ean + " ist ");
            if (pruefziffer == Character.getNumericValue(eanStr.charAt(12)))
                System.out.println("gültig!");
            else
                System.out.println("ungültig!");

            System.out.println("Summe 1 = " + summe1);
            System.out.println("Summe 2 = " + summe2);
            System.out.println("Gesamtsumme = " + gesamtsumme);
//            System.out.println("nächste durch 10 teilbare Zahl = " + naechsteDurch10teilbareZahl);
            System.out.println("Prüfziffer = " + pruefziffer);
        }
        else {
            System.err.println("Die EAN ist nicht 13-stellig!");
        }

    }
}
