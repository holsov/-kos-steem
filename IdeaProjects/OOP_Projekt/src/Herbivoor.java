public class Herbivoor extends Olend {
    public Herbivoor(double kõhu_täisolek, double täis_kõht, double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime) {
        super(kõhu_täisolek, täis_kõht, päevas_kuluv_toiteväärtus, tõenäosus_saab_sõõgi_kätte, toiteväärtus, võitlusvõime, false, true);
    }
    public Herbivoor laps(){
        return new Herbivoor(this.getKõhu_täisolek(), this.getTäis_kõht(), this.getPäevas_kuluv_toiteväärtus(), this.getTõenäosus_saab_söögi_kätte(), this.getToiteväärtus(), this.getVõitlusvõime());
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
