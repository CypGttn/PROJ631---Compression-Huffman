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
    }

    public Arbre(int valeur,Arbre enfantGauche, Arbre enfantDroit) {
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

    

    
}
