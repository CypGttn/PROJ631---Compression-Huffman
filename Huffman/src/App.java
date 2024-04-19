import java.util.ArrayList;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        String fic = LectureFichier.LireFichier("C:\\Users\\Guitton Cyprien\\Downloads\\PROJ631 -Algo\\PROJ631---Compression-Huffman\\textesimple.txt");
        ArrayList<String> avecDoublons = Frequence.FrequenceCaractere(fic);
        ArrayList<String> sansDoublons = Frequence.Doublons(avecDoublons);
        ArrayList<Integer> frequenceLettre = Frequence.Count(avecDoublons, sansDoublons) ;
        LinkedHashMap<String, Integer> dico = Frequence.Dictionnaire(sansDoublons, frequenceLettre);
        LinkedHashMap<String, Integer> dicoTrier = Frequence.TrierDico(dico);

        ConstructionArbre tree = new ConstructionArbre(dicoTrier);
        System.out.println(tree.CreerBranche()); 

    }
}
