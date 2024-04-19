public class Arbre {
    public String caractere;
    public int valeur;
    public Arbre enfantDroit;
    public Arbre enfantGauche;

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

    public void afficher() {
        afficherArbre(this, 0);
    }

    private void afficherArbre(Arbre arbre, int niveau) {
        if (arbre == null) {
            return;
        }

        // Afficher l'arbre de manière récursive
        afficherArbre(arbre.enfantGauche, niveau + 1);

        for (int i = 0; i < niveau; i++) {
            System.out.print("    "); // Indentation pour chaque niveau
        }

        if (arbre.caractere != null) {
            System.out.println("[" + arbre.caractere + ", " + arbre.valeur + "]");
        } else {
            System.out.println("[" + arbre.valeur + "]");
        }

        afficherArbre(arbre.enfantDroit, niveau + 1);
    }

    public void codageHuffman() {
        codage(this, 0, "");
    }

    private void codage(Arbre arbre, int niveau, String code) {
        if (arbre == null) {
            return;
        }

        // Afficher l'arbre de manière récursive
        codage(arbre.enfantGauche, niveau + 1, code + "0");

        
        if (arbre.caractere != null) {
            System.out.println(arbre.caractere + " : " + code);
        } 

        codage(arbre.enfantDroit, niveau + 1, code +"1");
    }

}

