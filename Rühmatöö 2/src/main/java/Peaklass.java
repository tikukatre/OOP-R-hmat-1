import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class Peaklass extends Application {

    //Peameetod
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws ValeSisendErind {
        Scene stseen = new Scene(looPaigutus(), 800, 500);

        stage.setTitle("QUARANTINE SLIMMER");
        stage.setScene(stseen);
        stage.show();
    }


    //Meetod, mis loob peamise paigutuse
    public BorderPane looPaigutus() throws ValeSisendErind {
        //Peaaken.
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color:#c0fad9;");
        //Ülemineriba ehk nö tööriistariba.
        Hyperlink githubiLink = new Hyperlink("GitHub");
        Button vaata = new Button("Vaata andmeid");
        Button salvesta = new Button("Salvesta andmed");
        Button kustutaFailid = new Button("Kustuta kõik failid");
        Button juhend = new Button("Juhend");

        String Juhend = "Palun sisestage Teilt küsitud andmed õigetesse lahtritesse. Aktiivsus valida numbrina 1-4: \n" +
                "1-Minimaalne kehaline aktiivsus; \n" +
                "2-Kerge (1-2 korda nädalas liikumist); \n" +
                "3-Keskmine(3-5 korda nädalas);\n" +
                "4-Väga aktiivne (iga päev).\n" +
                "Kui olete andmed korralikult sisestanud, siis vajutage nuppu 'Kinnita', võite ka klaviatuuril vajutata 'Enter'\n" +
                "Vasakpoolne plokk arvutab aktiivsuse, soo, kehakaalu ja vanuse põhjal välja kui palju kaloried on tervislik päevas tarbida.\n" +
                "Lisaks sellele pakub programm välja suvaliselt valitud harjutuse, mida on hea kodustes tingimustes teha.\n" +
                "Parempoolne plokk arvutab välja kui palju oli Teie tarbitud toidus kaloried.";

        ToolBar ylemineriba = new ToolBar(new Separator(),
                vaata, new Separator(), salvesta, new Separator(), kustutaFailid, new Separator(),
                juhend, new Separator(), githubiLink);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(ylemineriba);


        //Keskmine osa (võid teha ka eraldi meetodiks nagu see praegu on, mis tagastab Vboxi
        VBox keskel = new VBox();
        keskel.setSpacing(10);
        keskel.setPadding(new Insets(5));
        keskel.setAlignment(Pos.CENTER_LEFT);

        Label sugu = new Label("Sugu ");

        //Soovaliku kast, et nad oleksid üks teise kõrval mitte all võid teha sarnase kehalise aktiivuse kohta
        ToggleGroup sooGrupp = new ToggleGroup();

        HBox soovalik = new HBox();
        soovalik.setSpacing(25);
        soovalik.setPadding(new Insets(5));
        soovalik.setAlignment(Pos.CENTER_LEFT);
        RadioButton mees = new RadioButton("Mees");
        mees.setToggleGroup(sooGrupp);
        RadioButton naine = new RadioButton("Naine");
        naine.setToggleGroup(sooGrupp);
        soovalik.getChildren().addAll(mees, naine);


        //Muud lihtsamad väljas
        Label nimi = new Label("Nimi ");
        Label vanus = new Label("Vanus ");
        Label pikkus = new Label("Pikkus(m) ");
        Label kehakaal = new Label("Kehakaal(kg) ");
        TextField nimeSisestus = new TextField();
        nimeSisestus.setMaxWidth(100);
        TextField vanuseSisestus = new TextField();
        vanuseSisestus.setMaxWidth(40);
        TextField pikkuseSisestus = new TextField();
        pikkuseSisestus.setMaxWidth(40);
        TextField kehakaaluSisestus = new TextField();
        kehakaaluSisestus.setMaxWidth(40);

        //Aktiivsuse valiku kast
        Label aktiivsus = new Label("Aktiivsus");
        ToggleGroup aktiivsusGrupp = new ToggleGroup();

        HBox Aktiivsus = new HBox();
        Aktiivsus.setSpacing(25);
        Aktiivsus.setPadding(new Insets(5));
        Aktiivsus.setAlignment(Pos.TOP_LEFT);
        RadioButton esimene = new RadioButton("1");
        esimene.setToggleGroup(aktiivsusGrupp);
        RadioButton teine = new RadioButton("2");
        teine.setToggleGroup(aktiivsusGrupp);
        RadioButton kolmas = new RadioButton("3");
        kolmas.setToggleGroup(aktiivsusGrupp);
        RadioButton neljas = new RadioButton("4");
        neljas.setToggleGroup(aktiivsusGrupp);
        Aktiivsus.getChildren().addAll(esimene, teine, kolmas, neljas);

        //Kinnitamine ja tühistamine
        HBox nupud = new HBox();
        nupud.setSpacing(20);
        nupud.setPadding(new Insets(25, 25, 5, 5));
        nupud.setAlignment(Pos.CENTER_LEFT);
        Button kinnita = new Button("Kinnita");
        Button tyhista = new Button("Tühista");
        nupud.getChildren().addAll(kinnita, tyhista);

        //väljade lisamine keskel olevasse kasti
        keskel.getChildren().addAll(sugu, soovalik, aktiivsus, Aktiivsus, nimi, nimeSisestus, vanus,
                vanuseSisestus, pikkus, pikkuseSisestus, kehakaal, kehakaaluSisestus, nupud);


        VBox vasempool = new VBox();
        vasempool.setPrefSize(300, 450);
        vasempool.setPadding(new Insets(5));
        Label info = new Label("Siia kuvatakse saadud isiku info");
        //Võid fonti muuta
        info.setFont(new Font("Arial", 15));
        Label toiduinfo = new Label("");
        toiduinfo.setFont(new Font("Arial", 15));


        vasempool.getChildren().addAll(info, toiduinfo);
        vasempool.setAlignment(Pos.TOP_CENTER);


        VBox toidukast = new VBox();
        toidukast.setSpacing(10);
        toidukast.setPadding(new Insets(5, 10, 5, 0));
        toidukast.setAlignment(Pos.CENTER_LEFT);
        toidukast.setPrefSize(250, 100);
        Label nimetus = new Label("Toidu nimetus:");
        Label kogus = new Label("Kogus(g)");
        Label kaloreid = new Label("Kaloreid 100g kohta ");
        TextField nimetuseSisestus = new TextField();
        nimetuseSisestus.setMaxWidth(100);
        TextField koguseSisestus = new TextField();
        koguseSisestus.setMaxWidth(40);
        TextField kaloreidSisestus = new TextField();
        kaloreidSisestus.setMaxWidth(40);

        HBox nupud2 = new HBox();
        nupud2.setSpacing(20);
        nupud2.setPadding(new Insets(25, 25, 5, 5));
        nupud2.setAlignment(Pos.CENTER_LEFT);
        Button kinnita2 = new Button("Kinnita");
        Button tyhista2 = new Button("Tühista");
        nupud2.getChildren().addAll(kinnita2, tyhista2);

        toidukast.getChildren().addAll(nimetus, nimetuseSisestus, kogus, koguseSisestus, kaloreid, kaloreidSisestus, nupud2);


        //Peaaknasse teiste komponentide lisamine.
        borderPane.setTop(vbox);
        borderPane.setLeft(vasempool);
        borderPane.setCenter(keskel);
        borderPane.setRight(toidukast);


        ArrayList<String> sisestatud = new ArrayList();
        //Lis kuhu lisatakse sisestatud andmete tekstid, et need faili salvestada.

        //Sündmused
        //Isiku loomine peale kinnitamise nupu vajutamist
        kinnita.setOnAction(e ->
        {
            int aktiivsuseValik = 0;
            if (esimene.isSelected())
                aktiivsuseValik = 1;
            else if (teine.isSelected())
                aktiivsuseValik = 2;
            else if (kolmas.isSelected())
                aktiivsuseValik = 3;
            else if (neljas.isSelected())
                aktiivsuseValik = 4;


            if (mees.isSelected() && nimeSisestus.getText() != null && vanuseSisestus.getText() != null && pikkuseSisestus.getText() != null && kehakaaluSisestus.getText() != null) {
                //System.out.println("Mees"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                Isik isend = new Mees(nimeSisestus.getText(), Integer.parseInt(vanuseSisestus.getText()), Double.parseDouble(pikkuseSisestus.getText()), Double.parseDouble(kehakaaluSisestus.getText()), aktiivsuseValik);

                naitaInfot(info, isend);
                sisestatud.add(info.getText());

            } else if (naine.isSelected() && nimeSisestus.getText() != null && vanuseSisestus.getText() != null && pikkuseSisestus.getText() != null && kehakaaluSisestus.getText() != null) {
                //System.out.println("Naine"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                Isik isend = new Naine(nimeSisestus.getText(), Integer.parseInt(vanuseSisestus.getText()), Double.parseDouble(pikkuseSisestus.getText()), Double.parseDouble(kehakaaluSisestus.getText()), aktiivsuseValik);
                naitaInfot(info, isend);
                sisestatud.add(info.getText());
            }

        });

        //Info nätamine, kui viimases lahtis vajutatakse "Enter"
        kehakaaluSisestus.setOnKeyPressed(e -> {
            if (e.getCode().equals((KeyCode.ENTER))) {
                int aktiivsuseValik = 0;
                if (esimene.isSelected())
                    aktiivsuseValik = 1;
                else if (teine.isSelected())
                    aktiivsuseValik = 2;
                else if (kolmas.isSelected())
                    aktiivsuseValik = 3;
                else if (neljas.isSelected())
                    aktiivsuseValik = 4;


                if (mees.isSelected() && nimeSisestus.getText() != null && vanuseSisestus.getText() != null && pikkuseSisestus.getText() != null && kehakaaluSisestus.getText() != null) {
                    //System.out.println("Mees"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                    Isik isend = new Mees(nimeSisestus.getText(), Integer.parseInt(vanuseSisestus.getText()), Double.parseDouble(pikkuseSisestus.getText()), Double.parseDouble(kehakaaluSisestus.getText()), aktiivsuseValik);
                    naitaInfot(info, isend);
                    sisestatud.add(info.getText());


                } else if (naine.isSelected() && nimeSisestus.getText() != null && vanuseSisestus.getText() != null && pikkuseSisestus.getText() != null && kehakaaluSisestus.getText() != null) {
                    //System.out.println("Naine"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                    Isik isend = new Naine(nimeSisestus.getText(), Integer.parseInt(vanuseSisestus.getText()), Double.parseDouble(pikkuseSisestus.getText()), Double.parseDouble(kehakaaluSisestus.getText()), aktiivsuseValik);
                    naitaInfot(info, isend);
                    sisestatud.add(info.getText());
                }
            }
        });


        //Toidu loomine peale toidu kinnitamise nupu vajutamist
        kinnita2.setOnAction(e -> {
            if (nimetuseSisestus.getText() != null && koguseSisestus.getText() != null && kaloreidSisestus.getText() != null) {
                naitaToiduInfot(toiduinfo, new Toit(nimetuseSisestus.getText(), Double.parseDouble(koguseSisestus.getText()), Integer.parseInt(kaloreidSisestus.getText())));
            }
        });

        //Toidu info näitamine, kui viimases lahtris vajutatakse "Enter"
        kaloreidSisestus.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                if (nimetuseSisestus.getText() != null && koguseSisestus.getText() != null && kaloreidSisestus.getText() != null) {
                    naitaToiduInfot(toiduinfo, new Toit(nimetuseSisestus.getText(), Double.parseDouble(koguseSisestus.getText()), Integer.parseInt(kaloreidSisestus.getText())));
                }

            }
        });

        //Linkide vajutamine tööribal
        githubiLink.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/tikukatre/OOP-R-hmat-1").toURI());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        juhend.setOnAction(e -> uusAkenJuhend("Juhend", Juhend));
        salvesta.setOnAction(e -> {
            try {
                kirjutaFaili(sisestatud);
            } catch (IOException ex) {
                uusAken("Faili salvestamine", "Faili salvestamine ei õnnestunud.");
            }

        });

        vaata.setOnAction(e -> {
            try {
                uusAkenKeritav("Failist loetud", andmedTekstina(loeFailist()));
            } catch (IOException ex) {
                uusAken("Faiist lugemine", "Failist lugemine ei õnnestunud");
            }
        });

        kustutaFailid.setOnAction(e -> {
            new File("andmed.dat").delete();
            new File("andmed.txt").delete();
        });


        //Tühistab väljad, kui kustuta nuppu on vajutatud.
        tyhista.setOnAction(e -> {
            sooGrupp.getSelectedToggle().setSelected(false);
            nimeSisestus.clear();
            vanuseSisestus.clear();
            pikkuseSisestus.clear();
            kehakaaluSisestus.clear();
            info.setText("");
            aktiivsusGrupp.getSelectedToggle().setSelected(false);
            toiduinfo.setText("");

        });
        //Tühistab kõik toiduväljad.
        tyhista2.setOnAction(e -> {
            nimetuseSisestus.clear();
            koguseSisestus.clear();
            kaloreidSisestus.clear();
        });

        return borderPane;
    }



    //Loob uue akna, mis ei lase edasi toimetada, kuni see on kinni pandud.
    //Abiks oli : https://youtu.be/SpL3EToqaXA ;
    static void uusAken(String pealkiri, String sõnum){
        Stage aken = new Stage();
        aken.initModality(Modality.APPLICATION_MODAL);
        aken.setTitle(pealkiri);
        aken.setWidth(300);
        Label tekst = new Label(sõnum);
        tekst.setStyle("-fx-background-color:#aef5cd;");
        Button sulge = new Button("Sulge");
        sulge.setOnAction(e->aken.close());
        VBox paigutus = new VBox();
        paigutus.setPadding(new Insets(10));
        paigutus.setSpacing(10);
        paigutus.getChildren().addAll(tekst,sulge);
        paigutus.setAlignment(Pos.CENTER);
        paigutus.setStyle("-fx-background-color:#c0fad9;");
        Scene stseen = new Scene(paigutus,400,300);
        aken.setScene(stseen);
        aken.showAndWait();

    }

    static void uusAkenKeritav(String pealkiri, String sõnum) {
        Stage aken = new Stage();
        aken.initModality(Modality.APPLICATION_MODAL);
        aken.setTitle(pealkiri);
        aken.setWidth(600);

        Label tekst = new Label(sõnum);
        Button sulge = new Button("Sulge");
        sulge.setOnAction(e -> aken.close());
        VBox paigutus = new VBox();
        paigutus.setStyle("-fx-background-color:#c0fad9;");
        ScrollPane keritavAken = new ScrollPane();
        keritavAken.setContent(tekst);
        keritavAken.setStyle("-fx-background-color:#c0fad9;");
        paigutus.setPadding(new Insets(10));
        paigutus.setSpacing(10);
        paigutus.getChildren().addAll(keritavAken, sulge);
        paigutus.setAlignment(Pos.CENTER);
        Scene stseen = new Scene(paigutus, 600, 300);
        aken.setScene(stseen);
        aken.showAndWait();

    }
    static void uusAkenJuhend(String pealkiri, String sõnum){
        Stage aken = new Stage();
        aken.initModality(Modality.APPLICATION_MODAL);
        aken.setTitle(pealkiri);
        aken.setWidth(700);

        Label tekst = new Label(sõnum);
        tekst.setStyle("-fx-background-color:#aef5cd;");
        Button sulge = new Button("Sulge");
        sulge.setOnAction(e->aken.close());
        VBox paigutus = new VBox();
        paigutus.setPadding(new Insets(10));
        paigutus.setSpacing(10);
        paigutus.getChildren().addAll(tekst,sulge);
        paigutus.setAlignment(Pos.CENTER);
        paigutus.setStyle("-fx-background-color:#c0fad9;");
        Scene stseen = new Scene(paigutus,400,300);
        aken.setScene(stseen);
        aken.showAndWait();

    }

    void naitaInfot(Label info, Isik isik) {
        Map<Double, String> tegevusekulu = isik.kaloritekulu();
        double voti = 0.0;
        for (double kulu : tegevusekulu.keySet()) {
            voti = kulu;

        }
        info.setText(isik.toString() + isik.soovitus() + "\n" + tegevusekulu.get(voti) + "\n\n");

    }

    void naitaToiduInfot(Label toiduinfo, Toit toit) {
        toiduinfo.setText(toit.toString());
    }


    public void kirjutaFaili(ArrayList<String> sisestatud) throws IOException {


        try (DataOutputStream br = new DataOutputStream(new FileOutputStream("andmed.dat"));
             BufferedWriter andmed = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("andmed.txt")))) {
            try {
                ArrayList<String> varasemad = loeFailist();
                if (!varasemad.isEmpty()) {
                    sisestatud.addAll(varasemad);
                    new File("andmed.dat").delete();
                }

            } finally {
                br.writeInt(sisestatud.size());
                for (String lause : sisestatud) {
                    andmed.write(lause);
                    br.writeUTF(lause);
                }
            }
        }
    }

    public ArrayList<String> loeFailist() throws IOException {
        ArrayList<String> andmed = new ArrayList<>();
        try (DataInputStream voog = new DataInputStream(new FileInputStream("andmed.dat"))) {
            int ridu = voog.readInt();
            for (int i = 0; i < ridu; i++) {
                andmed.add(voog.readUTF());
            }
        }
        return andmed;
    }


    public static String tegevusKulutabToidu(Map<Double, String> tegevuseKulu, double toidukaloreid) {
        //Meetod, mis tagastab, kas suvaline saadud tegevus kulutab toidustsaadud kalorid

        Double kulu = 0.0;
        String lause;
        for (Double arv : tegevuseKulu.keySet()) {
            kulu = arv;
        }
        if (toidukaloreid == 0 || tegevuseKulu.isEmpty()) {
            lause = "Te pole sisestanud kõiki andmeid.";
        } else if (toidukaloreid < kulu) {
            lause = "Tegevus nõuab rohkem kaloreid, kui toidust saad.";
        } else if (toidukaloreid == kulu) {
            lause = "Tegevus nõuab sama palju kaloreid, kui toidust saad.";
        } else {
            lause = "Tegevus kulutab vähem kaloreid, kui toidust saad.";
        }
        return lause;
    }

    String andmedTekstina(ArrayList<String> list) {
        String andmed = "";
        for (String lause : list) {
            andmed += lause;
        }
        return andmed;
    }


}
