public class Herbivoor extends Olend {
    public Herbivoor(double kõhu_täisolek, double täis_kõht, double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime) {
        super(kõhu_täisolek, täis_kõht, päevas_kuluv_toiteväärtus, tõenäosus_saab_sõõgi_kätte, toiteväärtus, võitlusvõime, false, true);
    }
    public Herbivoor laps(){
        return new Herbivoor(this.getKõhu_täisolek(), this.getTäis_kõht(), this.getPäevas_kuluv_toiteväärtus(), this.getTõenäosus_saab_söögi_kätte(), this.getToiteväärtus(), this.getVõitlusvõime());
    }

    @Override
    public boolean saabKätte(Olend saak) {
        System.out.println(saak.getVõitlusvõime()*this.getTõenäosus_saab_söögi_kätte());
        Olend[] sööb = {new Taim(0.0, 0.0)};
        if (Math.random() < (saak.getVõitlusvõime() * this.getTõenäosus_saab_söögi_kätte())) {
            for (int i = 0; i < sööb.length; i++) {
                if (sööb[i].getClass().equals(saak.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    boolean saabJagu(Olend saak) {
        if (saak.getOn_taim()) {
            return true;
        }
        double suuruse_suhe; // loomade suuruste erinevuse mõju
        if (saak.getTäis_kõht() >= this.getTäis_kõht()) {
            suuruse_suhe = this.getTäis_kõht() / saak.getTäis_kõht();
            if (Math.random() < ((1 - saak.getTõenäosus_saab_söögi_kätte()) * (1 - this.getVõitlusvõime()) * suuruse_suhe)) {
                return true;
            }
            return false;
        } else {
            suuruse_suhe = saak.getTäis_kõht() / this.getTäis_kõht();
            if (Math.random() < ((1 - saak.getTõenäosus_saab_söögi_kätte()) * (1 - this.getVõitlusvõime()) * (1 - suuruse_suhe))) {
                return true;
            }
            return false;
        }
    }
}
