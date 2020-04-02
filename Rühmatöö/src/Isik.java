import java.util.ArrayList;

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
        for (int i = 0; i <algtegevused.length ; i++) {
            tegevused.add(algtegevused[i]);
        }

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
        int listiSuurus = tegevused.size();
        String tegevus = tegevused.get((int)(Math.random()*listiSuurus));
        return tegevus;
    }


    public double kehamassiindeks(){
        return this.kehakaal/(this.pikkus*this.pikkus);
    }

    public double kaloritekulu(){
        //Kaloritekulu arvutamine soovitatud tegevuse kohta
        int suvalisedMinutid = (int)(Math.random()*61); //Genereerib suvaliselt minutite arvu 0-st kuni 1 tunnini, kui palju tegevust võiks teha.
        String[] tegevus = tegevuseSuvalineSoovitus().split(","); //Jaotab tegevuse kaheks: tegevuse nimetus ja tegevuse MET väärtus
        Double kaloritekulu = suvalisedMinutid* (Double.parseDouble(tegevus[1])*this.kehakaal)/200; //Arvutab kui palju kaloreidkulub tegevust tehes minutite kohta
        System.out.println(tegevus[0] + ": "+suvalisedMinutid+ " minutit kulutab " + Math.round(kaloritekulu*100)/100);
        return Math.round(kaloritekulu*100)/100;
    }


    abstract double BMR();
    //Põhiline ainevahetuse kiirus/ Basal Metabolic Rate https://www.verywellfit.com/what-is-bmr-or-basal-metabolic-rate-3495380;

    abstract double vajaminevadKalorid();
    //Inimesele vajaminevate kalorite arvutamine, tema akttivuse ja BMRiga seoses

    @Override
    public String toString() {
        return "Nimi= " + nimi;
    }
}
