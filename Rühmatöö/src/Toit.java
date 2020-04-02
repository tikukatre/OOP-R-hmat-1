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
        return Math.round(((double)this.kalorid*(this.kogus/100))*100)/100;   // Arvutab kui palju kaloreid oli selles koguses toidus, mis inimene sõi
    }

    @Override
    public String toString() {
        return "Toit: " + toit + ", kogus " + kogus + "g, kalorid 100g kohta on selles " + kalorid + ", kaloreid toidus koguse kohta on " + kaloreid() + "kcal";
    }
}
