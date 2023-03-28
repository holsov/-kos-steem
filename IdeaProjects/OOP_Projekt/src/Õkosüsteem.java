import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Õkosüsteem {
    public static void main(String[] args) {
        List<FloraFauna> õkosüsteem = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            õkosüsteem.add(new Taim(0.1,0.1));
        }
        for (int i = 0; i < 5; i++) {
            õkosüsteem.add(new Loom(0.7,0.3,0.1,0.5,0.5,0.5,false,true));
        }
        for (int i = 0; i < 2; i++) {
            õkosüsteem.add(new Loom(0.7,1,0.3,0.5,1.3,0.5,false,true));
        }
        int i = 0;
        while(i < õkosüsteem.size()){ //käib iga olendi läbi
            int j = 0;
            FloraFauna olend = õkosüsteem.get(i); //viide olendile listis
            if(!olend.getOn_taim()){ // ei ole taim
                for (j = 0; j < olend.getKatsete_arv();j++){
                    int saak = (int)(Math.random()* õkosüsteem.size()); // genereerib saagi indeksi

                    if(olend.saabKätte(õkosüsteem.get(saak))){// Iga olendi korral vaatab kas olend saab teise looma kätte
                        olend.setKõhu_täisolek(olend.getKõhu_täisolek() + õkosüsteem.get(saak).getToiteväärtus());

                    }
                }


            }
        }
        //Loomad[] loomad_ja_taimed {taim,taim,herbivoor,herbivoor,herbivoor,herbivoor,kiskja,kiskja,kiskja};

    }
}