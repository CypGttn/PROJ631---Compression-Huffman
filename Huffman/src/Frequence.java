//Import des modules java
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Frequence {
    private String mot;
    private ArrayList<String> decompoMot; 
    private ArrayList<String> enleverDoublons; 
    private ArrayList<Integer> frequenceLettre; 

    
    //Getters et Setters
    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    public ArrayList<String> getDecompoMot() {
        return decompoMot;
    }

    public void setDecompoMot(ArrayList<String> decompoMot) {
        this.decompoMot = decompoMot;
    }

    public ArrayList<String> getEnleverDoublons() {
        return enleverDoublons;
    }

    public void setEnleverDoublons(ArrayList<String> enleverDoublons) {
        this.enleverDoublons = enleverDoublons;
    }

    public ArrayList<Integer> getFrequenceLettre() {
        return frequenceLettre;
    }

    public void setFrequenceLettre(ArrayList<Integer> frequenceLettre) {
        this.frequenceLettre = frequenceLettre;
    }

    public Frequence(String mot, ArrayList<String> decompoMot, ArrayList<String> enleverDoublons,
            ArrayList<Integer> frequenceLettre) {
        this.mot = mot;
        this.decompoMot = decompoMot;
        this.enleverDoublons = enleverDoublons;
        this.frequenceLettre = frequenceLettre;
    }

    //On crée une liste contenant tous les caractères de la liste
    public ArrayList<String> FrequenceCaractere(String mot){
        ArrayList<String> decompoMot = new ArrayList<String>();
        
        for (int i = 0; i < mot.length(); i++) {
			decompoMot.add(String.valueOf(mot.charAt(i)));
		}
        return decompoMot; 
    }

    //Enlève les doublons de la liste des caractères
    public ArrayList<String> Doublons(ArrayList<String> decompoMot) {
        ArrayList<String> enleverDoublons = new ArrayList<String>();

        for (int i =0; i< decompoMot.size(); i++ ) {
            //Si le caractère n'est pas déjà dans la liste des caractères on l'ajoute 
            if (!enleverDoublons.contains(decompoMot.get(i))) {
                enleverDoublons.add(decompoMot.get(i));
            }
        }
        return enleverDoublons;
    }

    //Compte la fréquence de chaque caractère 
    public ArrayList<Integer> Count(ArrayList<String> decompoMot, ArrayList<String> enleverDoublons){
        //On crée une liste vide qui va accueillir les valeurs de fréquences
        ArrayList<Integer> frequenceLettre = new ArrayList<Integer>();
        //On parcourt la liste sans doublons de caractère
        for (int i = 0; i < enleverDoublons.size(); i++) {
            String element = enleverDoublons.get(i);
            int count = 0; 
            //On parcourt la liste avec doublons, et on compte le nombre d'itérations du caractère
            for (int j = 0; j < decompoMot.size(); j++) {
                String lettre = decompoMot.get(j);
                if (lettre.equals(element)){
                    count++; 
                }
            }
            //La fréquence est ajoutée dans la liste
            frequenceLettre.add(count);

         
        }   
        return frequenceLettre;
    }

    //Création du dictionnaire associant caractère à sa fréquence 
    public LinkedHashMap<String, Integer> Dictionnaire(ArrayList<String> enleverDoublons, ArrayList<Integer> frequenceLettre){
        // Création d'un LinkedHashMap avec des chaînes de caractères comme clés et des entiers comme valeurs
        LinkedHashMap<String, Integer> dico = new LinkedHashMap<>();

        for (int i=0; i < enleverDoublons.size();i++){
            //On prend le caractère dans la liste sans doublons
            String element = enleverDoublons.get(i);
            //Et sa fréquence dans la liste des fréquence
            Integer valeur = frequenceLettre.get(i); 
            //On les ajoute au dictionnaire 
            dico.put(element, valeur); 
        }

        return dico;
    }

    public LinkedHashMap<String, Integer> TrierDico(LinkedHashMap<String, Integer> dico){
        //Créer une liste qui prend la liste des entrées
        List<Map.Entry<String, Integer> > list
            = new ArrayList<Map.Entry<String, Integer> >(
                dico.entrySet());
  
        // Trier la liste 
        Collections.sort(
            list,
            new ArbreComparator<String, Integer>());
        //On vide le dictionnaire
        dico.clear();
  
        // On parcours les entrées
        for (Map.Entry<String, Integer> entry : list) {
  
            // Puis on remet tous dans le dictionnaire
            dico.put(entry.getKey(), entry.getValue());
        }
        return dico;
  
    }

    //Creer le fichier contenant toutes les fréquences 
    public void FichierFreq(LinkedHashMap<String, Integer> dico, String nomFichier) {
        int somme = 0; 

        // Parcours chaque élément de la liste pour trouver la valeur, et puis ajoute cette valeur à la somme
        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            somme = somme + 1;
        }
        System.out.println("Nombre total de caractère :" + somme );
        //Créer le nouveau fichier en prenant en le nom du fichier texte + _freq.txt
        String fileName = nomFichier +"_freq.txt";

        try {
            // Créer un flux de sortie vers le fichier binaire
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // On note la somme dans la première ligne du fichier
            dos.writeUTF(String.valueOf(somme));
            //Puis on ajoute chaque caractère et sa fréquence 
            for (Map.Entry<String, Integer> entry : dico.entrySet()) {
                dos.writeUTF("\n" + entry.getKey() + " " + String.valueOf(entry.getValue()));
            }

            // Fermer les flux
            dos.close();
            fos.close();
            System.out.println("Le fichier fréquence a été créé avec succès.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
            e.printStackTrace();
        }








    }
}
