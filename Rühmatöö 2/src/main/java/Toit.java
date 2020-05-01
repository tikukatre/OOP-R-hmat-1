public class Toit {
    private String toit;
    private double kogus;
    private int kalorid;  // 100g kohta

    public Toit(String toit, double kogus, int kalorid) {
        this.toit = toit;
        this.kogus = kogus;
        this.kalorid = kalorid;
    }

    public String getToit() {
        return toit;
    }

    public void setToit(String toit) {
        this.toit = toit;
    }

    public double getKogus() {
        return kogus;
    }

    public void setKogus(double kogus) {
        this.kogus = kogus;
    }

    public int getKalorid() {
        return kalorid;
    }

    public void setKalorid(int kalorid) {
        this.kalorid = kalorid;
    }
    public double kaloreid(){
        return Math.round(((double)this.kalorid*(this.kogus/100))*100.0)/100.0;   // Arvutab kui palju kaloreid oli selles koguses toidus, mis inimene sõi
    }

    @Override
    public String toString() {
        return "\nToidu nimetus: " + toit + "\nKogus: " + kogus + "g\nKaloreid 100g kohta: " + kalorid + "\nKaloreid koguse kohta: " + kaloreid() + "kcal";
    }
}

