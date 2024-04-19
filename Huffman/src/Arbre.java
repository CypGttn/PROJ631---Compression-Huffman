public class Arbre {
    public String caractere;
    public int valeur;
    public Arbre enfantDroit;
    public Arbre enfantGauche;

    public Arbre(String caractere, int valeur, Arbre enfantDroit, Arbre enfantGauche) {
        this.caractere = caractere;
        this.valeur = valeur;
        this.enfantDroit = enfantDroit;
        this.enfantGauche = enfantGauche;
    }

    public Arbre(String caractere, int valeur) {
        this.caractere = caractere;
        this.valeur = valeur;
    }

    

    
}
