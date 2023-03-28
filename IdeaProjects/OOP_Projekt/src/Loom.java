public abstract class Loom{
    private double kõhu_täisolek; //0-1
    private double täis_kõht;
    private double päevas_kuluv_toiteväärtus;
    private boolean sõõb_taimi;
    private boolean sõõb_loomi;
    private boolean on_taim;
    private double toiteväärtus;
    private double tõenäosus_saab_söögi_kätte;
    private double võitlusvõime; //taime või looma võime vältida ohvriks jäämist 1 - võitlusvõime puudub, 0 - pole võimalik süüa.
    private int katsete_arv; // mittu korda saab loom päevas sõõki otsida
    public Loom(double kõhu_täisolek, double täis_kõht, double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime, boolean sõõbLoomi, boolean sõõbTaimi) {
        this.toiteväärtus = toiteväärtus;
        this.võitlusvõime = võitlusvõime;
        this.kõhu_täisolek = täis_kõht*kõhu_täisolek;
        this.tõenäosus_saab_söögi_kätte = tõenäosus_saab_sõõgi_kätte;
        this.katsete_arv = (int)päevas_kuluv_toiteväärtus*30;
        this.täis_kõht = täis_kõht;
        this.päevas_kuluv_toiteväärtus = päevas_kuluv_toiteväärtus;
        this.on_taim = false;


    }
    public Loom(){
    }
// aktiivsust enam pole lihtsalt kütivad alati ja kui kõht täis siis paljunevad
    public boolean kasPaljuneb(){
        return true;
    }

    // SIIT EDASI ABSTRAKTSED KLASSID
    abstract Loom laps();

    // SIIT EDASI GETTERID JA SETTERID
    public double getKõhu_täisolek() {
        return kõhu_täisolek;
    }

    public void setKõhu_täisolek(double kõhu_täisolek) {
        this.kõhu_täisolek = kõhu_täisolek;
    }

    public double getTäis_kõht() {
        return täis_kõht;
    }

    public void setTäis_kõht(double täis_kõht) {
        this.täis_kõht = täis_kõht;
    }

    public double getPäevas_kuluv_toiteväärtus() {
        return päevas_kuluv_toiteväärtus;
    }

    public void setPäevas_kuluv_toiteväärtus(double päevas_kuluv_toiteväärtus) {
        this.päevas_kuluv_toiteväärtus = päevas_kuluv_toiteväärtus;
    }

    public boolean isSõõb_taimi() {
        return sõõb_taimi;
    }

    public void setSõõb_taimi(boolean sõõb_taimi) {
        this.sõõb_taimi = sõõb_taimi;
    }

    public boolean isSõõb_loomi() {
        return sõõb_loomi;
    }

    public void setSõõb_loomi(boolean sõõb_loomi) {
        this.sõõb_loomi = sõõb_loomi;
    }

    public boolean getOn_taim() {
        return on_taim;
    }

    public void setOn_taim(boolean on_taim) {
        this.on_taim = on_taim;
    }

    public double getToiteväärtus() {
        return toiteväärtus;
    }

    public void setToiteväärtus(double toiteväärtus) {
        this.toiteväärtus = toiteväärtus;
    }

    public double getVõitlusvõime() {
        return võitlusvõime;
    }

    public void setVõitlusvõime(double võitlusvõime) {
        this.võitlusvõime = võitlusvõime;
    }

    public int getKatsete_arv() {
        return katsete_arv;
    }

    public void setKatsete_arv(int katsete_arv) {
        this.katsete_arv = katsete_arv;
    }

    public double getTõenäosus_saab_söögi_kätte() {
        return tõenäosus_saab_söögi_kätte;
    }

    public void setTõenäosus_saab_söögi_kätte(double tõenäosus_saab_söögi_kätte) {
        this.tõenäosus_saab_söögi_kätte = tõenäosus_saab_söögi_kätte;
    }
}
