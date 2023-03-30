public class Taim extends Olend {
    private double paljunemis_tõenäosus;
    public Taim(double toiteväärtus,double võitlusvõime, double paljunemis_tõenäosus) {
        this.setToiteväärtus(toiteväärtus);
        this.setVõitlusvõime(võitlusvõime);
        this.setOn_taim(true);
        this.setTõenäosus_saab_söögi_kätte(0);
        this.setKatsete_arv(0);
        this.paljunemis_tõenäosus = paljunemis_tõenäosus;
    }
    @Override
    public boolean kasPaljuneb(){//võiks olla mingi counter
        return Math.random() < paljunemis_tõenäosus;
    }
    public Taim laps(){
        return new Taim(this.getToiteväärtus(),this.getVõitlusvõime(), paljunemis_tõenäosus);
    }

    @Override
    public boolean saabKätte(Olend saak) {
        return false;
    }

    @Override
    boolean saabJagu(Olend saak) {
        return false;
    }
}
