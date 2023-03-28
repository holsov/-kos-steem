public  class Loom extends FloraFauna{
    private double kõhu_täisolek; //0-1
    private double täis_kõht;
    private double päevas_kuluv_toiteväärtus;
    private boolean sõõbTaimi;
    private boolean sõõbLoomi;
    private int katsete_arv; // mittu korda saab loom päevas sõõki otsida
    public Loom(double kõhu_täisolek,double täis_kõht,double päevas_kuluv_toiteväärtus, double tõenäosus_saab_sõõgi_kätte, double toiteväärtus, double võitlusvõime,boolean sõõbLoomi, boolean sõõbTaimi) {
        super(toiteväärtus,võitlusvõime);
        this.kõhu_täisolek = täis_kõht*kõhu_täisolek;
        this.katsete_arv = (int)päevas_kuluv_toiteväärtus*30;
        this.täis_kõht = täis_kõht;
        this.päevas_kuluv_toiteväärtus = päevas_kuluv_toiteväärtus;
        this.setOn_taim(false);


    }

    public void setKatsete_arv(int katsete_arv) {
        this.katsete_arv = katsete_arv;
    }

    public int getKatsete_arv() {
        return katsete_arv;
    }

    @Override
    void setKõhu_täisolek(double d) {
        this.kõhu_täisolek = d;
    }

    @Override
    double getKõhu_täisolek() {
        return this.kõhu_täisolek;
    }

    public boolean aktiivsus(){
        return this.kõhu_täisolek < 0.5 ? true : false;
    }

}
