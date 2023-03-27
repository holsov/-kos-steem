import java.util.ArrayList;
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
        System.out.println("Hello world!");
        //Loomad[] loomad_ja_taimed {taim,taim,herbivoor,herbivoor,herbivoor,herbivoor,kiskja,kiskja,kiskja};

    }
}