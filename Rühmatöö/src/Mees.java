public class Mees extends Isik {



    public Mees(String nimi, int vanus, double pikkus, double kehakaal, int aktiivsus) {
        super(nimi, vanus, pikkus, kehakaal, aktiivsus);
    }

    @Override
    double BMR() {
        return 88.362 + (13.397 * super.getKehakaal())+(4.799 * (super.getPikkus()*100))-(5.677 * super.getVanus());
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
