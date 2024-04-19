import java.util.Comparator;

public class ArbreComparator implements Comparator<Arbre> {
    @Override
    public int compare(Arbre a1, Arbre a2) {
        // Comparaison des valeurs des arbres
        return a1.getValeur() - a2.getValeur();
    }
}