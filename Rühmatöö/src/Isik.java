public abstract class Isik {
    private String nimi;
    private int vanus;
    private double pikkus;
    private double kehakaal;
    private int aktiivsus;

    public Isik(String nimi, int vanus, double pikkus, double kehakaal, int aktiivsus) {
        this.nimi = nimi;
        this.vanus = vanus;
        this.pikkus = pikkus;
        this.kehakaal = kehakaal;
        this.aktiivsus = aktiivsus;
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

    public double kehamassiindeks(){
        return this.kehakaal/(this.pikkus*this.pikkus);
    }

    abstract double BMR();
    //Põhiline ainevahetuse kiirus/ Basal Metabolic Rate https://www.verywellfit.com/what-is-bmr-or-basal-metabolic-rate-3495380;
}
