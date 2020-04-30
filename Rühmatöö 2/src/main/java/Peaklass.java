import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
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
        Scene scene = new Scene(createBorderPane(), 250, 200);
        stage.setTitle("Layout Demo");
        stage.setScene(scene);
        stage.show();
    }

    public BorderPane createBorderPane() {

        BorderPane borderPane = new BorderPane();
/*
        MenuBar menuBar = new MenuBar();
        Menu peaMenyy = new Menu("Logitud andmed");
        peaMenyy.getItems().addAll(new MenuItem("Salvesta uued andmed"),
                new SeparatorMenuItem(), new MenuItem("Vaata logituid andmeid"));

        Menu abiMenyy = new Menu("Abi");
        abiMenyy.getItems().addAll(new MenuItem("Kuidas andmeid sisestada?"),
                new SeparatorMenuItem(), new MenuItem("Rohkem infot programmist."));
        menuBar.getMenus().addAll(peaMenyy, abiMenyy);


 */
        ToolBar toolbar = new ToolBar(new Separator(),
                new Button("Vaata andmeid"), new Separator(), new Button("Salvesta andmed"),new Separator(),
                new Button("Muuda andmeid"));

        VBox vbox = new VBox();
        vbox.getChildren().addAll( toolbar);

        /*TreeItem<String> ti = new TreeItem<>("Projects");
        ti.getChildren().addAll(
                new TreeItem<String>("Project 1"),
                new TreeItem<String>("Project 2"),
                new TreeItem<String>("Project 3"),
                new TreeItem<String>("Project 4"));
        TreeView<String> tv = new TreeView<String>(ti);

         */

        TabPane tabPaneLeft = new TabPane();
        Tab tab1 = new Tab("Project List");
        //tab1.setContent(tv);
        tabPaneLeft.getTabs().addAll(tab1, new Tab("Explorer"));

        TabPane tabPaneRight = new TabPane();
        tabPaneRight.getTabs().addAll(new Tab("Outline"),
                new Tab("Task List"));

        borderPane.setTop(vbox);
        borderPane.setLeft(tabPaneLeft);
        borderPane.setCenter(new TextArea());
        borderPane.setRight(tabPaneRight);
        borderPane.setBottom(new Label("Status text: Borderpane demo"));

        return borderPane;
    }
}
