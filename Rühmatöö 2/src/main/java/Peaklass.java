import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.Map;

import static java.lang.System.in;

public class Peaklass extends Application {

    public static String tegevusKulutabToidu(Map<Double,String> tegevuseKulu, double  toidukaloreid ){
        Double kulu=0.0;
        String lause;
        for (Double arv:tegevuseKulu.keySet()) {
            kulu=arv;
        }
        if(toidukaloreid<kulu){
            lause ="Tegevus nõuab rohkem kaloreid, kui toidust saad.";
        } else if(toidukaloreid==kulu){
            lause ="Tegevus nõuab sama palju kaloreid, kui toidust saad.";
        }else{
           lause="Tegevus kulutab vähem kaloreid, kui toidust saad.";
        }
        return lause;
    }

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createBorderPane(), 800, 450);
        stage.setTitle("OOP Rühmatöö 2");
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


        //Keskmine osa (võid teha ka eraldi meetodiks nagu see praegu on, mis tagastab Vboxi
       VBox keskel = new VBox();
       keskel.setSpacing(10);
       keskel.setPadding(new Insets(5));
       keskel.setAlignment(Pos.CENTER_LEFT);

        Label sugu=new Label("Sugu ");

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


        HBox nupud = new HBox();
        nupud.setSpacing(50);
        nupud.setPadding(new Insets(25,25,5,5));
        nupud.setAlignment(Pos.CENTER_LEFT);
        Button kinnita = new Button("Kinnita");
        Button tyhista = new Button("Kustuta");
        nupud.getChildren().addAll(kinnita,tyhista);
        //väljade lisamine keskel olevasse kasti
        keskel.getChildren().addAll(sugu, soovalik, nimi,nimeSisestus,vanus,
                vanuseSisestus,pikkus,pikkuseSisestus,kehakaal,kehakaaluSisestus,nupud);


        StackPane vasempool = new StackPane();
        vasempool.setPrefSize(300,450);
        vasempool.setPadding(new Insets(5));
        Label info = new Label("Siia kuvatakse saadud info");
        //Võid fonti muuta
        info.setFont(new Font("Arial",15));

        vasempool.getChildren().addAll(info);
        vasempool.setAlignment(Pos.TOP_CENTER);


        VBox toidukast=new VBox();
        toidukast.setSpacing(25);
        toidukast.setPadding(new Insets(5));
        toidukast.setAlignment(Pos.CENTER_LEFT);
        toidukast.setMaxSize(250,100);
        Label nimetus=new Label("Toidu nimetus:");
        Label kogus=new Label("Kogus");
        Label kaloreid= new Label("Kaloreid 100g kohta ");
        TextField nimetuseSisestus=new TextField();
        nimeSisestus.setMaxWidth(100);
        TextField koguseSisestus=new TextField();
        koguseSisestus.setMaxWidth(40);
        TextField kaloeridSisestus=new TextField();
        kaloeridSisestus.setMaxWidth(40);
        toidukast.getChildren().addAll(nimetus,nimetuseSisestus,kogus,koguseSisestus,kaloreid,kaloeridSisestus);









        borderPane.setTop(vbox);
        borderPane.setLeft(vasempool);
        borderPane.setCenter(keskel);
        borderPane.setRight(toidukast);

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
        Aktiivsus.getChildren().addAll(esimene,teine,kolmas,neljas);


        //Sündmused
        //Soovaliku vastuse kontrolliminepeale kinnitamist
        kinnita.setOnAction(e->
        {

            //Praegu võtab aktiivsuse argumendiks ühe!!!

            if(mees.isSelected()&&nimeSisestus.getText()!=null && vanuseSisestus.getText()!=null&&pikkuseSisestus.getText()!=null&&kehakaaluSisestus.getText()!=null){
                //System.out.println("Mees"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                Isik isend= new Mees(nimeSisestus.getText(),Integer.parseInt(vanuseSisestus.getText()),Double.parseDouble(pikkuseSisestus.getText()),Double.parseDouble(kehakaaluSisestus.getText()),1);
                naitaInfot(info,isend);

            }else if(naine.isSelected()&&nimeSisestus.getText()!=null && vanuseSisestus.getText()!=null&&pikkuseSisestus.getText()!=null&&kehakaaluSisestus.getText()!=null){
                //System.out.println("Naine"+nimeSisestus.getText()+vanuseSisestus.getText()+pikkuseSisestus.getText()+kehakaaluSisestus.getText());
                Isik isend = new Naine(nimeSisestus.getText(),Integer.parseInt(vanuseSisestus.getText()),Double.parseDouble(pikkuseSisestus.getText()),Double.parseDouble(kehakaaluSisestus.getText()),1);
                naitaInfot(info,isend);
            }

        });
        //Tühistab väljad, kui kustuta nuppu on vajutatud.
        tyhista.setOnAction(e->{
            mees.setSelected(false);
            naine.setSelected(false);
            nimeSisestus.clear();
            vanuseSisestus.clear();
            pikkuseSisestus.clear();
            kehakaaluSisestus.clear();
            info.setText("");

        });


        return borderPane;
    }


    void naitaInfot(Label info, Isik isik){
        Map<Double,String> tegevusekulu = isik.kaloritekulu();
        double voti=0.0;
        for(double kulu : tegevusekulu.keySet()){
            voti=kulu;

        }
        info.setText(isik.toString() +isik.soovitus()+"\n"+tegevusekulu.get(voti));

    }

    private static void salvesta() throws IOException {
        try (DataOutputStream tekst = new DataOutputStream(new FileOutputStream("andmed.dat"))){}
    }

    private static void failiKirjutamine() throws IOException {
        try (BufferedReader kasutajaSisend = new BufferedReader(new InputStreamReader(System.in))){


        }
    }



}
