import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Isik {
    private String nimi;
    private int vanus;
    private double pikkus;
    private double kehakaal;
    private int aktiivsus;
    ArrayList<String> tegevused= new ArrayList<>();
    String[] algtegevused = {"Kõnni toas tasa ringi,2","Pühi põrandaid,3.3","Tee kergeid venitusi,2.3","Tantsi,7.8","Tee süüa,2.5", "Korrasta voodi ja vaheta linad,3.3", "Sörgi kohapeal,7.0","Tee intensiivselt kätekõverdusi,8",
            "Tee kääri hüppeid,8","Tee intensiivselt kõhulihaseid,8","Tee mõõdukalt kätekõverdusi,3.8"};

    public Isik(String nimi, int vanus, double pikkus, double kehakaal, int aktiivsus) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.pikkus = pikkus;
        this.kehakaal = kehakaal;
        this.aktiivsus = aktiivsus;
        //Lisame algtegevused listi
       /* for (int i = 0; i <algtegevused.length ; i++) {
            tegevused.add(algtegevused[i]);
        }

        */
       /* for(String tegevus:algtegevused){
            tegevused.add(tegevus);
        }

        */
       //IntellJ soovitus pole kindel kas töötab (29-04-20)
        tegevused.addAll(Arrays.asList(algtegevused));

    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getVanus() {
        return vanus;
    }

    public void setVanus(int vanus) {
        this.vanus = vanus;
    }

    public double getPikkus() {
        return pikkus;
    }

    public void setPikkus(double pikkus) {
        this.pikkus = pikkus;
    }

    public double getKehakaal() {
        return kehakaal;
    }

    public void setKehakaal(double kehakaal) {
        this.kehakaal = kehakaal;
    }

    public int getAktiivsus() {
        return aktiivsus;
    }

    public void setAktiivsus(int aktiivsus) {
        this.aktiivsus = aktiivsus;
    }

    public String tegevuseSuvalineSoovitus(){
        //Soovitab suvalist tegevust tegevustelistist
        int listiSuurus = tegevused.size();
        return tegevused.get((int)(Math.random()*listiSuurus));
    }


    public double kehamassiindeks(){
        return Math.round((this.kehakaal/(this.pikkus*this.pikkus))*100.0)/100.0;
    }
    public String soovitus(){
        //Kontrollib mis kategooriasse kehamassiindeks kuulub ning jagab soovitusi.
        double BMI = kehamassiindeks();
        String soovitus = "";
        if ( BMI < 18.6){

            soovitus="Tarbi rohkem toitu,\noled alakaalus.";
        }
        if ( BMI > 25){

            soovitus="Pead rohkem liigutama,\noled natuke ülekaalus";
        }
        if (BMI > 30){

            soovitus="Tee trenni või tarbi vähem toitu,\nsest oled üsna ülekaalus.";
        }
        if( BMI > 18.5 & BMI <= 25 ){

            soovitus="Oled normaalkaalus.";
        }
        return soovitus;
    }


    public Map<Double,String> kaloritekulu(){
        //Kaloritekulu arvutamine soovitatud tegevuse kohta
        //Luuakse kujund Map<Double,String> , kus võtmeks saab kaloritekulu arv ja väärtuseks tekst, mis soovitab tegevust ja annab informatsiooni selle kohta.
        Map<Double,String> tulemus = new HashMap<>();

        int suvalisedMinutid = (int)(Math.random()*61); //Genereerib suvaliselt minutite arvu 0-st kuni 1 tunnini, kui palju tegevust võiks teha.
        String[] tegevus = tegevuseSuvalineSoovitus().split(","); //Jaotab tegevuse kaheks: tegevuse nimetus ja tegevuse MET väärtus
        double kaloritekulu = suvalisedMinutid* (Double.parseDouble(tegevus[1])*this.kehakaal)/200; //Arvutab kui palju kaloreidkulub tegevust tehes minutite kohta

        String tekst = tegevus[0] + ": "+suvalisedMinutid+ " minutit\nKulutab: " + Math.round(kaloritekulu*100)/100 + " kalorit.";
        kaloritekulu=Math.round(kaloritekulu*100.0)/100.0;
        tulemus.put(kaloritekulu,tekst);
        return tulemus;
    }


    abstract double BMR();
    //Põhiline ainevahetuse kiirus/ Basal Metabolic Rate https://www.verywellfit.com/what-is-bmr-or-basal-metabolic-rate-3495380;

    abstract double vajaminevadKalorid();
    //Inimesele vajaminevate kalorite arvutamine, tema akttivuse ja BMRiga seoses

    @Override
    public String toString() {
        return "Nimi: " + nimi +"\n"+
                "Vanus: "+ vanus +"\n"+
                "Pikkus: "+ pikkus +"\n"+
                "Kehakaal: "+ kehakaal+"\n"+
                "Aktiivus: "+aktiivsus+"\n";
    }
}
