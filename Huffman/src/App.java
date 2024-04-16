import java.util.ArrayList;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        String fic = LectureFichier.LireFichier("C:\\Users\\Guitton Cyprien\\Downloads\\PROJ631 -Algo\\PROJ631---Compression-Huffman\\textesimple.txt");
        ArrayList<String> avecDoublons = Frequence.FrequenceCaractere(fic);
        ArrayList<String> sansDoublons = Frequence.Doublons(avecDoublons);
        ArrayList<Integer> frequenceLettre = Frequence.Count(avecDoublons, sansDoublons) ;
        LinkedHashMap<String, Integer> dico = Frequence.Dictionnaire(sansDoublons, frequenceLettre);
        System.out.println(Frequence.TrierDico(dico));
    }
}
