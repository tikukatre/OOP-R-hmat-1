import javax.swing.*;

public class Peaklass {

    public static void tegevusKulutabToidu(double toidukaloreid, double tegevuseKulu ){
        if(toidukaloreid<tegevuseKulu){
            System.out.println("Tegevus nõuab rohkem kaloreid, kui toidust saad.");
        } else if(toidukaloreid==tegevuseKulu){
            System.out.println("Tegevus nõuab sama palju kaloreid, kui toidust saad.");
        }else{
            System.out.println("Tegevus kulutab vähem kaloreid, kui toidust saad.");
        }
    }

    public static void main(String[] args) {
        String sisestatakse = JOptionPane.showInputDialog(null, "Palun sisestada andmeid järgmiselt:\nSugu nimi vanus pikkus(m) kehakaal(kg) aktiivsus toit kogus kalorid(100g kohta).\nAktiivsus valida numbrina 1-4: Minimaalne (1),kerge (2),keskmine (3),väga aktiivne (4). \nKõik andmed palume sisestada järjest, tühikud vahel, ilma komadeta. ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);

        String[] sisestatudAndmed = sisestatakse.split(" ");

        Toit toit = new Toit(sisestatudAndmed[6],Double.parseDouble(sisestatudAndmed[7]),Integer.parseInt(sisestatudAndmed[8]));
        System.out.println(toit);
        //Loome isiku vastavalt soole
        if(sisestatudAndmed[0].equalsIgnoreCase("Naine")){//Kontrollib, kas esimene siestatud sõna on naine.
            Isik isik = new Naine(sisestatudAndmed[1],Integer.parseInt(sisestatudAndmed[2]),Double.parseDouble(sisestatudAndmed[3]),Double.parseDouble(sisestatudAndmed[4]),Integer.parseInt(sisestatudAndmed[5]));
            System.out.println(isik);
            isik.soovitus();
            System.out.println("Suvaliselt soovitatud tegevus:");
            double kulu = isik.kaloritekulu();
            tegevusKulutabToidu(toit.kaloreid(),kulu);

        }if(sisestatudAndmed[0].equalsIgnoreCase("Mees")){//Kontrollib, kas esimene siestatud sõna on mees.
            Isik isik = new Mees(sisestatudAndmed[1],Integer.parseInt(sisestatudAndmed[2]),Double.parseDouble(sisestatudAndmed[3]),Double.parseDouble(sisestatudAndmed[4]),Integer.parseInt(sisestatudAndmed[5]));
            System.out.println(isik);
            isik.soovitus();
            System.out.println("Suvaliselt soovitatud tegevus:");
            double kulu = isik.kaloritekulu();
            tegevusKulutabToidu(toit.kaloreid(),kulu);

        }



    }
}
