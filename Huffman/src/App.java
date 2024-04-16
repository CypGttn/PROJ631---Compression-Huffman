

public class App {
    public static void main(String[] args) {
        String fic = LectureFichier.LireFichier("C:\\Users\\Guitton Cyprien\\Downloads\\PROJ631 -Algo\\PROJ631---Compression-Huffman\\textesimple.txt");
        System.out.println(Frequence.FrequenceCaractere(fic));
    }
}
