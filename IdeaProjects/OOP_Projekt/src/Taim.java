public class Taim extends FloraFauna{
    public Taim(double toiteväärtus,double võitlusvõime) {
        super(toiteväärtus,võitlusvõime);
        this.setOn_taim(true);
    }

    @Override
    int getKatsete_arv() {
        return 0;
    }

    @Override
    void setKõhu_täisolek(double d) {

    }

    @Override
    double getKõhu_täisolek() {
        return 0;
    }

    void setKõhu_täisolek() {
    }
}
