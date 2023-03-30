import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Õkosüsteem {
    public static void main(String[] args) throws IOException {
        ArrayList<Olend> õkosüsteem = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            õkosüsteem.add(new Taim(0.2,0.9, 0.15));
        }
        for (int i = 0; i < 30; i++) {
            õkosüsteem.add(new Herbivoor(0.7,2.0,0.1,0.5,2,0.9));
        }
        for (int i = 0; i < 12; i++) {
            õkosüsteem.add(new Karnivoor(0.7,5,1,0.7,4,0.1));
        }
        // for (int i = 0; i < 5; i++) {
        //     õkosüsteem.add(new Omnivoor(0.8, 2.0, 0.3, 0.6, 5, 0.9));
            
        // }

        // kasutaja sisend
        // ArrayList<Olend> õkosüsteem = loe_sisend();

        System.out.println("alguseis: ");
        for (int i = 0; i < õkosüsteem.size(); i++) {
            System.out.println(õkosüsteem.get(i));
            
        }

        // Siit algab päeva tegevus

        int i = 0;
        for (int p = 0; p < 10; p++) {//päevade arv
            i = 0;
            int ökosysteemi_suurus = õkosüsteem.size();
            while (i < Math.min(ökosysteemi_suurus, õkosüsteem.size())) { //käib iga olendi läbi
                int j = 0;
                Olend olend = õkosüsteem.get(i); //viide olendile listis

                if (!olend.getOn_taim()) { // ei ole taim ehk on loom
                    for (j = 0; j < olend.getKatsete_arv() && olend.getKõhu_täisolek() < olend.getTäis_kõht(); j++) {
                        int saak = (int) (Math.random() * õkosüsteem.size()); // genereerib saagi indeksi

                        if (olend.saabKätte(õkosüsteem.get(saak)) && olend != õkosüsteem.get(saak)) { // olend tõenäosus_saab_söögi_kätte - saak tõenäosus_saab_söögi_kätte ja siis veel kotroll kas ta üldse tahab saaki süüa(sobiv toidugrupp ja mitte sama liik)
                            if(saak<i){i--;} //muidu liiguvad kõik elemendid listis vasakule, aga indeks jääb samaks ja viitab valele elemendile
                            olend.setKõhu_täisolek(Math.min(olend.getTäis_kõht(), olend.getKõhu_täisolek() + õkosüsteem.get(saak).getToiteväärtus()));
                            õkosüsteem.remove(saak);
                            
                        } else if (!olend.saabJagu(õkosüsteem.get(saak)) && ((õkosüsteem.get(saak).getOn_taim() && olend.isSõõb_taimi()) || ((!õkosüsteem.get(saak).getOn_taim()) && olend.isSõõb_loomi()))) { // kas looma saab saagist jagu (sõltub loomade kõhutäisolekust ja võitlusvõimest ilmselt lihtsalt korrutab läbi. Siis suuremad loomad on tugevamad ka)
                            if (õkosüsteem.get(saak).isSõõb_loomi()) {
                                õkosüsteem.get(saak).setKõhu_täisolek(Math.min(õkosüsteem.get(saak).getTäis_kõht(), õkosüsteem.get(saak).getKõhu_täisolek() + olend.getToiteväärtus()));
                            }
                            õkosüsteem.remove(õkosüsteem.indexOf(olend));
                            break;
                        }

                    }
                    

                }
                if (olend.kasPaljuneb()) {
                    olend.setKõhu_täisolek(olend.getKõhu_täisolek() / 2);
                    õkosüsteem.add(olend.laps());
                }
                olend.setKõhu_täisolek(olend.getKõhu_täisolek() - olend.getPäevas_kuluv_toiteväärtus());
                if (olend.getKõhu_täisolek() < 0) {
                    õkosüsteem.remove(i);
                } else {
                    i++;// kui ei saanud päeva jooksul surma siis liigub järgmise olendi juurde
                }
                
            }
        }

        System.out.println("loppseis: ");
        for (int j = 0; j < õkosüsteem.size(); j++) {
            System.out.println(õkosüsteem.get(j));
            
        }
        int t = 0,o = 0,h = 0,k = 0;
        for (int j = 0; j < õkosüsteem.size(); j++) {
            if(õkosüsteem.get(j).getOn_taim()){
                t++;
            }else if(õkosüsteem.get(j).isSõõb_loomi() && õkosüsteem.get(j).isSõõb_taimi()){
                o++;
            }else if(õkosüsteem.get(j).isSõõb_taimi()){
                h++;
            }else if(õkosüsteem.get(j).isSõõb_loomi()){
                k++;
            }
        }
        System.out.println("Taimi on: "+t);
        System.out.println("Herbivoore on: "+h);
        System.out.println("Karnivoore on: "+k);
        System.out.println("Omnivoore on: "+o);

    }

    public static ArrayList<Olend> loe_sisend() throws IOException {
        ArrayList<Olend> olendid = new ArrayList<>();
        try (Scanner kasutaja_sisend = new Scanner(System.in)) {
            System.out.println("Sisesta herbivooride arv, kõhutäisolek (0-1), maksimaalselt täis kõht, päevas kuluv toiteväärtus, tõenäosus et saab saagi kätte, tema toiteväärtus, võitlusvõime");
            
            int arv = kasutaja_sisend.nextInt();
            double kõhutäisolek = kasutaja_sisend.nextDouble();
            double max_kõht = kasutaja_sisend.nextDouble();
            double päevas_kulub = kasutaja_sisend.nextDouble();
            double tõenäosus_saab_söögi_kätte = kasutaja_sisend.nextDouble();
            double toiteväärtus = kasutaja_sisend.nextDouble();
            double võitlusvõime = kasutaja_sisend.nextDouble();

            for (int i = 0; i < arv; i++) {
                olendid.add(new Herbivoor(kõhutäisolek, max_kõht, päevas_kulub, tõenäosus_saab_söögi_kätte, toiteväärtus, võitlusvõime));
            }

            System.out.println("Sisesta karnivooride arv, kõhutäisolek (0-1), maksimaalselt täis kõht, päevas kuluv toiteväärtus, tõenäosus et saab saagi kätte, tema toiteväärtus, võitlusvõime");
            
            arv = kasutaja_sisend.nextInt();
            kõhutäisolek = kasutaja_sisend.nextDouble();
            max_kõht = kasutaja_sisend.nextDouble();
            päevas_kulub = kasutaja_sisend.nextDouble();
            tõenäosus_saab_söögi_kätte = kasutaja_sisend.nextDouble();
            toiteväärtus = kasutaja_sisend.nextDouble();
            võitlusvõime = kasutaja_sisend.nextDouble();

            for (int i = 0; i < arv; i++) {
                olendid.add(new Karnivoor(kõhutäisolek, max_kõht, päevas_kulub, tõenäosus_saab_söögi_kätte, toiteväärtus, võitlusvõime));
            }

            System.out.println("Sisesta omnivooride arv, kõhutäisolek (0-1), maksimaalselt täis kõht, päevas kuluv toiteväärtus, tõenäosus et saab saagi kätte, tema toiteväärtus, võitlusvõime");
            
            arv = kasutaja_sisend.nextInt();
            kõhutäisolek = kasutaja_sisend.nextDouble();
            max_kõht = kasutaja_sisend.nextDouble();
            päevas_kulub = kasutaja_sisend.nextDouble();
            tõenäosus_saab_söögi_kätte = kasutaja_sisend.nextDouble();
            toiteväärtus = kasutaja_sisend.nextDouble();
            võitlusvõime = kasutaja_sisend.nextDouble();

            for (int i = 0; i < arv; i++) {
                olendid.add(new Omnivoor(kõhutäisolek, max_kõht, päevas_kulub, tõenäosus_saab_söögi_kätte, toiteväärtus, võitlusvõime));
            }

            System.out.println("Sisesta taimede arv, toiteväärtus, võitlusvõime, paljunemise tõenäosus");
            
            arv = kasutaja_sisend.nextInt();
            toiteväärtus = kasutaja_sisend.nextDouble();
            võitlusvõime = kasutaja_sisend.nextDouble();
            double paljunemis_tõenäosus = kasutaja_sisend.nextDouble();

            for (int i = 0; i < arv; i++) {
                olendid.add(new Taim(toiteväärtus, võitlusvõime, paljunemis_tõenäosus));
            }

        }
        return olendid;
    }
}