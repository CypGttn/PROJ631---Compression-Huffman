//Import des modules java
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class App {
    public static void main(String[] args) {
        //Chemin du fichier
        String nomFichier = "textesimple"; 
        String filePath = nomFichier + ".txt";
        //Lecture du fichier à partir d'un chemin donné
        String fic = LectureFichier.LireFichier(filePath);
        //Création de la liste avec tous les caractères du texte
        ArrayList<String> avecDoublons = Frequence.FrequenceCaractere(fic);
        //On en enlève les doublons
        ArrayList<String> sansDoublons = Frequence.Doublons(avecDoublons);
        //En utilisant la liste et la liste sans les doublons, on compte les occurences de chaque caractere
        ArrayList<Integer> frequenceLettre = Frequence.Count(avecDoublons, sansDoublons) ;
        //On crée un dictionnaire associant le caractère et sa fréquence
        LinkedHashMap<String, Integer> dico = Frequence.Dictionnaire(sansDoublons, frequenceLettre);
        //On trie le dictionnaire par fréquence de caractère croissante
        LinkedHashMap<String, Integer> dicoTrier = Frequence.TrierDico(dico);
        //Création du fichier contenant les fréquences
        Frequence.FichierFreq(dicoTrier, nomFichier);   
        //En utilisant le dictionnaire trié, on crée notre arbre selon le modèle d'Huffman
        ConstructionArbre tree = new ConstructionArbre(dicoTrier);
        //On crée une liste avec toutes les branches
        tree.CreerBranche(); 
        //On remplit notre arbre en créant les noeuds
        tree.Noeud();
        //On affiche l'arbre en donnant la valeur des noeuds et s'il y en a le caratère associé
        tree.afficherArbre(); 
        //On crée le code binaire à partir de l'arbre
        tree.AfficherCode(avecDoublons);
        tree.DocBin(nomFichier, avecDoublons);
        System.out.println(tree.AfficherCode(avecDoublons));
        // Calculs de compression 
        Calculs calc = new Calculs(nomFichier); 
        System.out.println(calc.Compression());
        //Compression moyenne pour plusieurs fichiers 
    
        // Initialize an ArrayList
        //ArrayList<String> textes = new ArrayList<>(Arrays.asList("textesimple", "extraitalice", "alice"));
        Calculs plusieurs = new Calculs(sansDoublons);
        System.out.println(plusieurs.TauxMoyen());

        

    }
}
