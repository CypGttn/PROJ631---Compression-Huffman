import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConstructionArbre {
    public ArrayList<String> enleverDoublons; 
    public ArrayList<Integer> frequenceLettre;
    public LinkedHashMap<String, Integer> dico;
    public ArrayList<Arbre> arbre;

    public ConstructionArbre(LinkedHashMap<String, Integer> dico) {
        this.dico = dico;
        this.arbre = new  ArrayList<Arbre>(); 
    }

    public  ArrayList<Arbre> CreerBranche() { 

        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            arbre.add(new Arbre(key, value));
        }
        return arbre; 
    }

    public void Noeud(){
        for (Arbre feuille : arbre ) {
            if (arbre.size() == 1) {
                System.out.println("Arbre construit");
            }
            else {

                Arbre feuille1 = arbre.get(0);
                Arbre feuille2 = arbre.get(1);

                int somme = feuille1.valeur + feuille2.valeur; 

                Arbre noeud = new Arbre(somme, feuille1, feuille2); 
                arbre.remove(feuille1);
                arbre.remove(feuille2); 
                arbre.add(noeud);
                Collections.sort(arbre, new ArbreComparator()); 
                Noeud(); 

            }

        }
    }

    public void afficherArbre() {
        if (arbre.size() == 1) {
            arbre.get(0).afficher(); // Appel de la méthode afficher de la classe Arbre
        } else {
            System.out.println("L'arbre n'est pas encore construit.");
        }
    }

}
