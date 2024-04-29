//Import des modules java
import java.util.LinkedHashMap;

public class Arbre implements Comparable<Arbre> {
    //On définit les éléments nécessaires à la création de l'arbre
    public String caractere;
    public int valeur;
    public Arbre enfantDroit;
    public Arbre enfantGauche;

    //On initialise les constructeurs 
    public Arbre(String caractere, int valeur, Arbre enfantGauche, Arbre enfantDroit) {
        this.caractere = caractere;
        this.valeur = valeur;
        this.enfantDroit = enfantDroit;
        this.enfantGauche = enfantGauche;
    }

    public Arbre(String caractere, int valeur) {
        this.caractere = caractere;
        this.valeur = valeur;
        this.enfantDroit = null;
        this.enfantGauche = null;
    }

    public Arbre(int valeur,Arbre enfantGauche, Arbre enfantDroit) {
        this.caractere = null;
        this.valeur = valeur;
        this.enfantDroit = enfantDroit;
        this.enfantGauche = enfantGauche;
    }

    //On initialise les getters et setteurs
    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Arbre getEnfantDroit() {
        return enfantDroit;
    }

    public void setEnfantDroit(Arbre enfantDroit) {
        this.enfantDroit = enfantDroit;
    }

    public Arbre getEnfantGauche() {
        return enfantGauche;
    }

    public void setEnfantGauche(Arbre enfantGauche) {
        this.enfantGauche = enfantGauche;
    }

    //Affichage Arbre

    //Initialise l'affichage de l'arbre par un appel de fonction
    public void afficher() {
        afficherArbre(this, 0);
    }

    //Affiche l'arbre de manière récursive en parcourant les enfants droits et gauches
    private void afficherArbre(Arbre arbre, int niveau) {
        if (arbre == null) {
            return;
        }

        // Afficher l'arbre de manière récursive
        afficherArbre(arbre.enfantDroit, niveau + 1);

        for (int i = 0; i < niveau; i++) {
            System.out.print("    "); // Indentation pour chaque niveau
        }

        //Si un caractère est associé à la fréquence 
        if (arbre.caractere != null) {
            System.out.println("[" + arbre.caractere + ", " + arbre.valeur + "]");
        } 
        //Si aucun caractère n'est associé à la fréquence 
        else {
            System.out.println("[" + arbre.valeur + "]");
        }

        afficherArbre(arbre.enfantGauche, niveau + 1);
    }
    //Codage Huffman

    //Initialise un dictionnaire et fait le premier appel à la fonction codage
    public LinkedHashMap<String, String> codageHuffman() {
        LinkedHashMap<String, String> codageFreq = new LinkedHashMap<>();
        return codage(this,  "", codageFreq);
        
    }

    //Codage de chaque caractère de manière récursive
    private LinkedHashMap<String, String> codage(Arbre arbre,  String code, LinkedHashMap<String, String> codageFreq) {
        
        if (arbre.caractere != null) {
            codageFreq.put(arbre.caractere, code);
        } 
        else  {
        // Afficher l'arbre de manière récursive, enfant Gauche ajoute un 0
        codage(arbre.enfantGauche,  code + "0", codageFreq);
        // Afficher l'arbre de manière récursive, enfant droit ajoute un 1
        codage(arbre.enfantDroit, code + "1", codageFreq);
        }
        return codageFreq;
        
    }

    @Override
    public int compareTo(Arbre autreArbre) {
        // Compare les valeurs de deux arbres
        return Integer.compare(this.valeur, autreArbre.valeur);
    }

}

