public abstract class FloraFauna {
    private boolean on_taim;
    private double toiteväärtus;
    private double võitlusvõime; //taime või looma võime vältida ohvriks jäämist 1 - võitlusvõime puudub, 0 - pole võimalik süüa.

    public FloraFauna(double toiteväärtus,double võitlusvõime) {
        this.toiteväärtus = toiteväärtus;
        this.võitlusvõime = võitlusvõime;
    }

    public void setOn_taim(boolean on_taim) {
        this.on_taim = on_taim;
    }
    public boolean isOn_taim() {
        return on_taim;
    }

    public double getToiteväärtus() {
        return toiteväärtus;
    }

    public double getVõitlusvõime() {
        return võitlusvõime;
    }

    public void setVõitlusvõime(double võitlusvõime) {
        this.võitlusvõime = võitlusvõime;
    }
    //Loomad[] loomad_ja_taimed {taim,taim,herbivoor,herbivoor,herbivoor,herbivoor,kiskja,kiskja,kiskja};
}
