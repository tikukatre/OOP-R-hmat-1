public class Naine extends Isik {

    public Naine(String nimi, int vanus, double pikkus, double kehakaal, int aktiivsus) {
        super(nimi, vanus, pikkus, kehakaal, aktiivsus);
    }

    @Override
    double BMR() {
        //teisendan pikkuse meetritest sentimeeriteks ja seepärast korrutan pikkuse 100-ga.
        return 477.593 +(9.247*super.getKehakaal())+(3.098 *(super.getPikkus()*100))-(4.330 * super.getVanus());
    }

    @Override
    double vajaminevadKalorid() {
        return Math.round((BMR() * super.getAktiivsus())*100)/100;
    }

    @Override
    public String toString() {
        return super.toString() + " päevane energiavajadus on umbes " + vajaminevadKalorid();
    }
}
