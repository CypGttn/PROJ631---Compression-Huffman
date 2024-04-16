import java.io.File;
import java.util.ArrayList; 

public class Frequence {
    private String mot;
    private ArrayList<String> decompoMot; 
    private ArrayList<String> enleverDoublons; 
    private ArrayList<Integer> frequenceLettre; 




    public static ArrayList<String> FrequenceCaractere(String mot){
        ArrayList<String> decompoMot = new ArrayList<String>();
        
        for (int i = 0; i < mot.length(); i++) {
			decompoMot.add(String.valueOf(mot.charAt(i)));
		}
        return decompoMot; 
    }
}
