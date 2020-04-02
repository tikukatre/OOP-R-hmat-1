public class Mees extends Isik {



    public Mees(String nimi, int vanus, double pikkus, double kehakaal, int aktiivsus) {
        super(nimi, vanus, pikkus, kehakaal, aktiivsus);
    }

    @Override
    double BMR() {
        return 88.362 + (13.397 * super.getKehakaal())+(4.799 * (super.getPikkus()*100))-(5.677 * super.getVanus());
    }
    @Override
    double kaloritekulu() {
        int suvalisedMinutid = (int)Math.random()*61;
        String[] tegevus = super.tegevuseSuvalineSoovitus().split(",");
        Double kaloritekulu = suvalisedMinutid* (Integer.parseInt(tegevus[1])*super.getKehakaal());
        return kaloritekulu;
    }

    @Override
    double vajaminevadKalorid() {
        return BMR() * super.getAktiivsus();
    }
}
