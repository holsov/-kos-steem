public class Omnivoor  extends Olend{
    public Omnivoor(double kõhu_täisolek, double täis_kõht, double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime) {
        super(kõhu_täisolek, täis_kõht, päevas_kuluv_toiteväärtus, tõenäosus_saab_sõõgi_kätte, toiteväärtus, võitlusvõime, true, true);
    }
    public Omnivoor laps(){
        return new Omnivoor(this.getKõhu_täisolek(), this.getTäis_kõht(), this.getPäevas_kuluv_toiteväärtus(), this.getTõenäosus_saab_söögi_kätte(), this.getToiteväärtus(), this.getVõitlusvõime());
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
