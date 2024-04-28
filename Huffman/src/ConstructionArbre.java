//Import des modules java
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConstructionArbre {
    //On définit les listes et dictionnaires nécessaires pour avoir les éléments pour créer l'arbre
    public ArrayList<String> enleverDoublons; 
    public ArrayList<Integer> frequenceLettre;
    public LinkedHashMap<String, Integer> dico;
    public ArrayList<Arbre> arbre;

    //Constructeur 
    public ConstructionArbre(LinkedHashMap<String, Integer> dico) {
        this.dico = dico;
        this.arbre = new  ArrayList<Arbre>(); 
    }

    //On crée une liste de branches à partir d'un caractère et de ses valeurs
    public  ArrayList<Arbre> CreerBranche() { 

        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            arbre.add(new Arbre(key, value));
        }
        return arbre; 
    }

    //A partir de la liste des branches, on créer les Noeuds
    public void Noeud(){
        for (Arbre feuille : arbre ) {
            if (arbre.size() == 1) {
                System.out.println("Arbre construit");
            }
            else {
                //On récupère les deux premières branches de la liste
                Arbre feuille1 = arbre.get(0);
                Arbre feuille2 = arbre.get(1);

                int somme = feuille1.valeur + feuille2.valeur; 
                //On initialise le noeud avec la somme, et les deux premières branches de la liste comme enfants 
                Arbre noeud = new Arbre(somme, feuille1, feuille2); 
                //Une fois les branches utilisées dans un noeud, on les retire de la liste des branches
                arbre.remove(feuille1);
                arbre.remove(feuille2); 
                //On ajoute le noeud dans la liste des branches
                arbre.add(noeud);
                //Après ajout d'un nouvel élément, on tri la liste en utilisant les valeurs
                Collections.sort(arbre, new ArbreComparator()); 
                //On fait un appel récursive pour créer la suite des noeuds
                Noeud(); 

            }

        }
    }

    //Permet d'afficher l'arbre
    public void afficherArbre() {
        if (arbre.size() == 1) {
            arbre.get(0).afficher(); // Appel de la méthode afficher de la classe Arbre
        } else {
            System.out.println("L'arbre n'est pas encore construit.");
        }
    }

    //Permet d'afficher le code binaire
    public String AfficherCode() {
        LinkedHashMap<String, String> codage = new LinkedHashMap<String, String>();
        if (arbre.size() == 1) {
            codage = arbre.get(0).codageHuffman();
        } else {
            System.out.println("L'arbre n'est pas encore construit.");
        }   


        String codageComplet = ""; 
        for (Map.Entry<String, String> entry : codage.entrySet()) {
            codageComplet += entry.getValue(); 

        }
        return codageComplet; 
    }

    //Créer le doc compresser binaire
    public void DocBin(String nom_fichier) {
        String codageString = AfficherCode(); 
        //Prend le nom du fichier d'origine en ajoutant : _comp.bin
        String fileName = nom_fichier +"_comp.bin";

        try {
            // Créer un flux de sortie vers le fichier binaire
            FileOutputStream fos = new FileOutputStream(fileName);
            // Créer un flux de données pour écrire des données binaires
            DataOutputStream dos = new DataOutputStream(fos);

            // Écrire des données dans le fichier binaire
            dos.writeUTF(codageString);

            // Fermer les flux
            dos.close();
            fos.close();

            System.out.println("Le fichier binaire a été créé avec succès.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
            e.printStackTrace();
        }
    }



}
