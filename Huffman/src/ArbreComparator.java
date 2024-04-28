//Import des modules java
import java.util.Comparator;
import java.util.Map;

//Définit la valeur du noeud comme moyen de comparaison
//Est utilisé dans le tri de dictionnaire lorsque les noeuds sont crées
public class ArbreComparator <K extends Comparable<? super K>, V extends Comparable<? super V>> implements Comparator<Map.Entry<K, V>> {
    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
        int cmp1 = a.getValue().compareTo(b.getValue());
        if (cmp1 != 0) {
            return cmp1;
        } else {
            return a.getKey().compareTo(b.getKey());
        }
    }
}