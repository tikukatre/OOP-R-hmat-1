import javax.swing.*;

public class Peaklass {
    public static void main(String[] args) {
        //System.out.println("Palun sisestada andmeid järgmiselt: sugu nimi vanus pikkus kehakaal aktiivsus toit kogus kalorid(100g kohta). Kõik andmed palume sisestada järjest," +
        //        "tühikud vahel, ilma komadeta.");

        String sisestatakse = JOptionPane.showInputDialog(null, "Palun sisestada andmeid järgmiselt:\nSugu nimi vanus pikkus(m) kehakaal(kg) aktiivsus toit kogus kalorid(100g kohta).\nAktiivsus valida numbrina 1-4: Minimaalne (1),kerge (2),keskmine (3),väga aktiivne (4). \nKõik andmed palume sisestada järjest, tühikud vahel, ilma komadeta. ", "Andmete sisestamine",
                JOptionPane.QUESTION_MESSAGE);

        String[] sisestatudAndmed = sisestatakse.split(" ");

        if(sisestatudAndmed[0].equalsIgnoreCase("Naine")){
            Isik isik = new Naine(sisestatudAndmed[1],Integer.parseInt(sisestatudAndmed[2]),Double.parseDouble(sisestatudAndmed[3]),Double.parseDouble(sisestatudAndmed[4]),Integer.parseInt(sisestatudAndmed[5]));

        }if(sisestatudAndmed[0].equalsIgnoreCase("Mees")){
            Isik isik = new Mees(sisestatudAndmed[1],Integer.parseInt(sisestatudAndmed[2]),Double.parseDouble(sisestatudAndmed[3]),Double.parseDouble(sisestatudAndmed[4]),Integer.parseInt(sisestatudAndmed[5]));

        }
        Toit toit = new Toit(sisestatudAndmed[6],Double.parseDouble(sisestatudAndmed[7]),Integer.parseInt(sisestatudAndmed[8]));
        System.out.println(toit.kaloreid());
        /*
        if(args[0].equalsIgnoreCase("Naine")){
            Isik isik = new Naine(args[1],Integer.parseInt(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));

        }else if (args[0].equalsIgnoreCase("Mees")){
            Isik isik = new Mees(args[1],Integer.parseInt(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4]),Integer.parseInt(args[5]));
        }
        Toit toit = new Toit(args[6],Double.parseDouble(args[7]),Integer.parseInt(args[8]));

         */
    }
}
