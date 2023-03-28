public class Taim extends Olend {
    private int paljunemiskiirus;
    private int paljunemiseni_jäänud;
    public Taim(double toiteväärtus,double võitlusvõime) {
        this.setToiteväärtus(toiteväärtus);
        this.setVõitlusvõime(võitlusvõime);
        this.setOn_taim(true);
        this.setTõenäosus_saab_söögi_kätte(0);
    }
    @Override
    public boolean kasPaljuneb(){//võiks olla mingi counter
        return true;
    }
    public Taim laps(){
        return new Taim(this.getToiteväärtus(),this.getVõitlusvõime());
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
