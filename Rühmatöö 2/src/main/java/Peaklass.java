import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Peaklass extends Application {

    public static void tegevusKulutabToidu(double toidukaloreid, double tegevuseKulu ){
        if(toidukaloreid<tegevuseKulu){
            System.out.println("Tegevus nõuab rohkem kaloreid, kui toidust saad.");
        }if(toidukaloreid==tegevuseKulu){
            System.out.println("Tegevus nõuab sama palju kaloreid, kui toidust saad.");
        }else{
            System.out.println("Tegevus kulutab vähem kaloreid, kui toidust saad.");
        }
    }

    public static void main(String[] args) {
        launch(args);


        //Kood vanast projektist, mis tuleb nüüd javafx graafikaga ümber teha
        /*
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
         */
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createBorderPane(), 600, 450);
        stage.setTitle("Layout Demo");
        stage.setScene(scene);
        stage.show();
    }

    public BorderPane createBorderPane() {

        BorderPane borderPane = new BorderPane();

        ToolBar ylemineriba = new ToolBar(new Separator(),
                new Button("Vaata andmeid"), new Separator(), new Button("Salvesta andmed"),new Separator(),
                new Button("Muuda andmeid"));

        VBox vbox = new VBox();
        vbox.getChildren().addAll(ylemineriba);


        TabPane tabPaneLeft = new TabPane();
        Tab tab1 = new Tab("Project List");
        tabPaneLeft.getTabs().addAll(tab1, new Tab("Explorer"));

        TabPane tabPaneRight = new TabPane();
        tabPaneRight.getTabs().addAll(new Tab("Outline"),
                new Tab("Task List"));

        //Keskmine osa (võid teha ka eraldi meetodiks nagu see praegu on, mis tagastab Vboxi
       VBox keskel = new VBox();
       keskel.setSpacing(10);
       keskel.setPadding(new Insets(5,5,5,5));
       keskel.setAlignment(Pos.CENTER_LEFT);

        Label sugu=new Label("Sugu ");

        //Soovaliku kast, et nad oleksid üks teise kõrval mitte all võid teha sarnase kehalise aktiivuse kohta
        HBox soovalik = new HBox();
        soovalik.setSpacing(25);
        soovalik.setPadding(new Insets(5));
        soovalik.setAlignment(Pos.CENTER_LEFT);
        RadioButton mees = new RadioButton("Mees");
        RadioButton naine = new RadioButton("Naine");
        soovalik.getChildren().addAll(mees,naine);



        //Muud lihtsamad väljas
        Label nimi=new Label("Nimi ");
        Label vanus=new Label("Vanus ");
        Label pikkus= new Label("Pikkus(m) ");
        Label kehakaal=new Label("Kehakaal(kg) ");
        TextField nimeSisestus=new TextField();
        nimeSisestus.setMaxWidth(100);
        TextField vanuseSisestus=new TextField();
        vanuseSisestus.setMaxWidth(40);
        TextField pikkuseSisestus=new TextField();
        pikkuseSisestus.setMaxWidth(40);
        TextField kehakaaluSisestus=new TextField();
        kehakaaluSisestus.setMaxWidth(40);

        //väljade lisamine keskel olevasse kasti
       keskel.getChildren().addAll(sugu, soovalik, nimi,nimeSisestus,vanus,vanuseSisestus,pikkus,pikkuseSisestus,kehakaal,kehakaaluSisestus);



        borderPane.setTop(vbox);
        borderPane.setLeft(tabPaneLeft);
        borderPane.setCenter(keskel);
        //borderPane.setRight(tabPaneRight);


        return borderPane;
    }
}
