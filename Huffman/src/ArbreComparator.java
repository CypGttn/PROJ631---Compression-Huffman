//Import des modules java
import java.util.Comparator;

//Définit la valeur du noeud comme moyen de comparaison
//Est utilisé dans le tri de dictionnaire lorsque les noeuds sont crées
public class ArbreComparator implements Comparator<Arbre> {
    @Override
    public int compare(Arbre a1, Arbre a2) {
        // Comparaison des valeurs des arbres
        return a1.getValeur() - a2.getValeur();
    }
}