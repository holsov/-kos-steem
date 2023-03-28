import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Õkosüsteem {
    public static void main(String[] args) {
        List<Loom> õkosüsteem = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            õkosüsteem.add(new Taim(0.1,0.1));
        }
        for (int i = 0; i < 5; i++) {
            õkosüsteem.add(new Herbivoor(0.7,0.3,0.1,0.5,0.5,0.5));
        }
        for (int i = 0; i < 2; i++) {
            õkosüsteem.add(new Karnivoor(0.7,1,0.3,0.5,1.3,0.5));
        }

        // Siit algab päeva tegevus
        int i = 0;
        while(i < õkosüsteem.size()){ //käib iga olendi läbi
            int j = 0;
            Loom olend = õkosüsteem.get(i); //viide olendile listis
            if(!olend.getOn_taim()){ // ei ole taim
                for (j = 0; j < olend.getKatsete_arv();j++){
                    int saak = (int)(Math.random()* õkosüsteem.size()); // genereerib saagi indeksi

                    if(olend.saabKätte(õkosüsteem.get(saak))){ // olend tõenäosus_saab_söögi_kätte - saak tõenäosus_saab_söögi_kätte ja siis veel kotroll kas ta üldse tahab saaki süüa(sobiv toidugrupp ja mitte sama liik)
                        olend.setKõhu_täisolek(olend.getKõhu_täisolek() + õkosüsteem.get(saak).getToiteväärtus());
                    }
                    if(olend.saabJagu(õkosüsteem.get(saak))){ // kas looma saab saagist jagu (sõltub loomade kõhutäisolekust ja võitlusvõimest ilmselt lihtsalt korrutab läbi. Siis suuremad loomad on tugevamad ka)

                    }
                }


            }
            if(olend.kasPaljuneb()){
                õkosüsteem.add( olend.laps());
            }
        }
        //Loomad[] loomad_ja_taimed {taim,taim,herbivoor,herbivoor,herbivoor,herbivoor,kiskja,kiskja,kiskja};

    }
}