//Import des modules java
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class App {
    public static void main(String[] args) {
        //
        String fic = LectureFichier.LireFichier("C:\\Users\\Guitton Cyprien\\Downloads\\PROJ631 -Algo\\PROJ631---Compression-Huffman\\textesimple.txt");
        //Création de la liste avec tous les caractères du texte
        ArrayList<String> avecDoublons = Frequence.FrequenceCaractere(fic);
        //On en enlève les doublons
        ArrayList<String> sansDoublons = Frequence.Doublons(avecDoublons);
        //En utilisant la liste et la liste sans les doublons, on compte les occurences de chaque caractere
        ArrayList<Integer> frequenceLettre = Frequence.Count(avecDoublons, sansDoublons) ;
        //On crée un dictionnaire associant le caractère et sa fréquece
        LinkedHashMap<String, Integer> dico = Frequence.Dictionnaire(sansDoublons, frequenceLettre);
        //On trie le dictionnaire par fréquence de caractère croissante
        LinkedHashMap<String, Integer> dicoTrier = Frequence.TrierDico(dico);
        //En utilisant le dictionnaire trié, on crée notre arbre selon le modèle d'Huffman
        ConstructionArbre tree = new ConstructionArbre(dicoTrier);
        //On crée une liste avec toutes les branches
        tree.CreerBranche(); 
        //On remplit notre arbre en créant les noeuds
        tree.Noeud();
        //On affiche l'arbre en donnant la valeur des noeuds et s'il y en a le caratère associé
        tree.afficherArbre(); 
        //On crée le code binaire à partir de l'arbre
        tree.AfficherCode();
        tree.DocBin("textesimple");
        System.out.println(tree.AfficherCode());

    }
}
