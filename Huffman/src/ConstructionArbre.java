import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConstructionArbre {
    public ArrayList<String> enleverDoublons; 
    public ArrayList<Integer> frequenceLettre;
    public LinkedHashMap<String, Integer> dico;

    public ConstructionArbre(LinkedHashMap<String, Integer> dico) {
        this.dico = dico;
    }

    public  ArrayList<Arbre> CreerBranche() {
        ArrayList<Arbre> feuilles = new ArrayList<Arbre>(); 

        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            feuilles.add(new Arbre(key, value));
        }
        return feuilles; 
    }

    public ArrayList<Arbre> Noeud(){
        ArrayList<Arbre> arbre = CreerBranche();
        for (Arbre feuille : arbre ) {
            if (arbre.size() == 1) {
                return arbre;
            }
            else {
                
                Arbre feuille1 = arbre.get(0);
                Arbre feuille2 = arbre.get(1);

                int somme = feuille1.valeur + feuille2.valeur; 

                Arbre noeud = new Arbre(somme, feuille1, feuille2); 

                arbre.add(noeud);



            }

        }
        
        
        Arbre noeudUn = new Arbre(feuille1.valeur+feuille2.valeur, feuille1, feuille2); 

    }

}
