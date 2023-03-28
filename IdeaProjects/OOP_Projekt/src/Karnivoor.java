public class Karnivoor  extends Loom{
    public Karnivoor(double kõhu_täisolek, double täis_kõht, double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime) {
        super(kõhu_täisolek, täis_kõht, päevas_kuluv_toiteväärtus, tõenäosus_saab_sõõgi_kätte, toiteväärtus, võitlusvõime, true, false);
    }
    public Karnivoor laps(){
        return new Karnivoor(this.getKõhu_täisolek(), this.getTäis_kõht(), this.getPäevas_kuluv_toiteväärtus(), this.getTõenäosus_saab_söögi_kätte(), this.getToiteväärtus(), this.getVõitlusvõime());
    }
    public Karnivoor() {
    }
}
