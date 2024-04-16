import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String fic = LectureFichier.LireFichier("C:\\Users\\Guitton Cyprien\\Downloads\\PROJ631 -Algo\\PROJ631---Compression-Huffman\\textesimple.txt");
        ArrayList<String> avecDoublons = Frequence.FrequenceCaractere(fic);
        ArrayList<String> sansDoublons = Frequence.Doublons(avecDoublons);
        System.out.println(Frequence.Count(avecDoublons, sansDoublons));
    }
}
