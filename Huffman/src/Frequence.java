//Import des modules java
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.*;

public class Frequence {
    private String mot;
    private ArrayList<String> decompoMot; 
    private ArrayList<String> enleverDoublons; 
    private ArrayList<Integer> frequenceLettre; 

    public Frequence(String mot, ArrayList<String> decompoMot, ArrayList<String> enleverDoublons,
            ArrayList<Integer> frequenceLettre) {
        this.mot = mot;
        this.decompoMot = decompoMot;
        this.enleverDoublons = enleverDoublons;
        this.frequenceLettre = frequenceLettre;
    }

    //On crée une liste contenant tous les caractères de la liste
    public static ArrayList<String> FrequenceCaractere(String mot){
        ArrayList<String> decompoMot = new ArrayList<String>();
        
        for (int i = 0; i < mot.length(); i++) {
			decompoMot.add(String.valueOf(mot.charAt(i)));
		}
        return decompoMot; 
    }

    //Enlève les doublons de la liste des caractères
    public static ArrayList<String> Doublons(ArrayList<String> decompoMot) {
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
    public static ArrayList<Integer> Count(ArrayList<String> decompoMot, ArrayList<String> enleverDoublons){
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
    public static LinkedHashMap<String, Integer> Dictionnaire(ArrayList<String> enleverDoublons, ArrayList<Integer> frequenceLettre){
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

    public static LinkedHashMap<String, Integer> TrierDico(LinkedHashMap<String, Integer> dico){
        //Créer une liste qui prend la liste des entrées
        List<Map.Entry<String, Integer> > list
            = new ArrayList<Map.Entry<String, Integer> >(
                dico.entrySet());
  
        // Trier la liste 
        Collections.sort(
            list,
            new Comparator<Map.Entry<String, Integer> >() {
                // Compare la valeur des entrées
                public int compare(
                    Entry<String, Integer> entry1,
                    Entry<String, Integer> entry2)
                    {
                        int compareValue = entry1.getValue().compareTo(entry2.getValue());
                        if (compareValue != 0) {
                            return compareValue;
                        } else {
                            // Si les valeurs sont égales, alors on compare en utilisant le code ASCII
                            return entry1.getKey().compareTo(entry2.getKey());
                        }
                    }
                });
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
    public static void FichierFreq(LinkedHashMap<String, Integer> dico, String nomFichier) {
        int somme = 0; 

        // Parcours chaque élément de la liste pour trouver la valeur, et puis ajoute cette valeur à la somme
        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            somme = somme + entry.getValue();
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
