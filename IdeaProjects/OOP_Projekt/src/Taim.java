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
        double suuruse_suhe; // loomade suuruste erinevuse mõju
        if (saak.getTäis_kõht() >= this.getTäis_kõht()) {
            suuruse_suhe = this.getTäis_kõht() / saak.getTäis_kõht();
            if (Math.random() < ((1 - saak.getTõenäosus_saab_söögi_kätte()) * (1 - this.getVõitlusvõime()) * (1 - suuruse_suhe))) {
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
