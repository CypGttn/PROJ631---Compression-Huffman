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

    public static ArrayList<String> Doublons(ArrayList<String> decompoMot) {
        ArrayList<String> enleverDoublons = new ArrayList<String>();

        for (int i =0; i< decompoMot.size(); i++ ) {
            if (!enleverDoublons.contains(decompoMot.get(i))) {
                enleverDoublons.add(decompoMot.get(i));
            }
        }
        return enleverDoublons;
    }

    public static ArrayList<Integer> Count(ArrayList<String> decompoMot, ArrayList<String> enleverDoublons){
        ArrayList<Integer> frequenceLettre = new ArrayList<Integer>();
        for (int i = 0; i < enleverDoublons.size(); i++) {
            String element = enleverDoublons.get(i);
            int count = 0; 
            for (int j = 0; j < decompoMot.size(); j++) {
                String lettre = decompoMot.get(j);
                if (lettre.equals(element)){
                    count++; 
                }
            }
            frequenceLettre.add(count);

         
        }   
        return frequenceLettre;
    }
}
