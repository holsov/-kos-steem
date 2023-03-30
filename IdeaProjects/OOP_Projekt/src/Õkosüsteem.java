import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Õkosüsteem {
    public static void main(String[] args) {
        List<Olend> õkosüsteem = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            õkosüsteem.add(new Taim(0.1,0.8));
        }
        for (int i = 0; i < 5; i++) {
            õkosüsteem.add(new Herbivoor(0.7,2.0,0.1,0.5,0.5,0.5));
        }
        for (int i = 0; i < 0; i++) {
            õkosüsteem.add(new Karnivoor(0.7,1,0.3,0.5,1.3,0.5));
        }
        for (int i = 0; i < 5; i++) {
            õkosüsteem.add(new Omnivoor(0.8, 2.0, 0.3, 0.6, 2.0, 0.1));
            
        }

        for (int i = 0; i < õkosüsteem.size(); i++) {
            System.out.println(õkosüsteem.get(i));
            
        }

        System.out.println("alguseis: ");
        for (int i = 0; i < õkosüsteem.size(); i++) {
            System.out.println(õkosüsteem.get(i));
            
        }

        // Siit algab päeva tegevus

        int i = 0;
        for (int p = 0; p < 1; p++) {//päevade arv
            i = 0;
            int ökosysteemi_suurus = õkosüsteem.size();
            while (i < õkosüsteem.size()) { //käib iga olendi läbi
                int j = 0;
                Olend olend = õkosüsteem.get(i); //viide olendile listis

                if (!olend.getOn_taim()) { // ei ole taim
                    System.out.println("ei ole taim");
                    for (j = 0; j < olend.getKatsete_arv(); j++) {
                        int saak = (int) (Math.random() * õkosüsteem.size()); // genereerib saagi indeksi

                        if (olend.saabKätte(õkosüsteem.get(saak))) { // olend tõenäosus_saab_söögi_kätte - saak tõenäosus_saab_söögi_kätte ja siis veel kotroll kas ta üldse tahab saaki süüa(sobiv toidugrupp ja mitte sama liik)
                            olend.setKõhu_täisolek(Math.min(olend.getTäis_kõht(), olend.getKõhu_täisolek() + õkosüsteem.get(saak).getToiteväärtus()));
                            õkosüsteem.remove(saak);

                            
                        } else if (!olend.saabJagu(õkosüsteem.get(saak))) { // kas looma saab saagist jagu (sõltub loomade kõhutäisolekust ja võitlusvõimest ilmselt lihtsalt korrutab läbi. Siis suuremad loomad on tugevamad ka)
                            õkosüsteem.remove(i);
                            break;
                        }

                    }
                    

                }
                if (olend.kasPaljuneb()) {
                    System.out.println(olend.getClass() + "kohu taisolek: " + olend.getKõhu_täisolek());
                    olend.setKõhu_täisolek(olend.getKõhu_täisolek() / 3.0);
                    õkosüsteem.add(olend.laps());
                }
                olend.setKõhu_täisolek(olend.getKõhu_täisolek() - olend.getPäevas_kuluv_toiteväärtus());
                // if (olend.getKõhu_täisolek() < 0) {
                //     õkosüsteem.remove(i);
                // }
                i++;// kui ei saanud päeva jooksul surma siis liigub järgmise olendi juurde
            }
        }

        System.out.println("loppseis: ");
        for (int j = 0; j < õkosüsteem.size(); j++) {
            System.out.println(õkosüsteem.get(j));
            
        }

    }
}