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

    public static ArrayList<String> FrequenceCaractere(String mot){
        ArrayList<String> decompoMot = new ArrayList<String>();
        
        for (int i = 0; i < mot.length(); i++) {
			decompoMot.add(String.valueOf(mot.charAt(i)));
		}
        return decompoMot; 
    }

    public static ArrayList<String> Doublons(ArrayList<String> decompoMot) {
        ArrayList<String> enleverDoublons = new ArrayList<String>();

        for (int i =0; i< decompoMot.size(); i++ ) {
            if (!enleverDoublons.contains(decompoMot.get(i))) {
                enleverDoublons.add(decompoMot.get(i));
            }
        }
        return enleverDoublons;
    }

    public static ArrayList<Integer> Count(ArrayList<String> decompoMot, ArrayList<String> enleverDoublons){
        ArrayList<Integer> frequenceLettre = new ArrayList<Integer>();
        for (int i = 0; i < enleverDoublons.size(); i++) {
            String element = enleverDoublons.get(i);
            int count = 0; 
            for (int j = 0; j < decompoMot.size(); j++) {
                String lettre = decompoMot.get(j);
                if (lettre.equals(element)){
                    count++; 
                }
            }
            frequenceLettre.add(count);

         
        }   
        return frequenceLettre;
    }

    public static LinkedHashMap<String, Integer> Dictionnaire(ArrayList<String> enleverDoublons, ArrayList<Integer> frequenceLettre){
        // Création d'un LinkedHashMap avec des chaînes de caractères comme clés et des entiers comme valeurs
        LinkedHashMap<String, Integer> dico = new LinkedHashMap<>();

        for (int i=0; i < enleverDoublons.size();i++){
            String element = enleverDoublons.get(i);
            Integer valeur = frequenceLettre.get(i); 
            dico.put(element, valeur); 
        }

        return dico;
    }

    public static LinkedHashMap<String, Integer> TrierDico(LinkedHashMap<String, Integer> dico){
        // using entryset() method
        List<Map.Entry<String, Integer> > list
            = new ArrayList<Map.Entry<String, Integer> >(
                dico.entrySet());
  
        // Comparable Interface function to
        // sort the values of List
        Collections.sort(
            list,
            new Comparator<Map.Entry<String, Integer> >() {
                // Comparing entries
                public int compare(
                    Entry<String, Integer> entry1,
                    Entry<String, Integer> entry2)
                    {
                        int compareValue = entry1.getValue().compareTo(entry2.getValue());
                        if (compareValue != 0) {
                            return compareValue;
                        } else {
                            // If values are equal, compare by ASCII codes of keys
                            return entry1.getKey().compareTo(entry2.getKey());
                        }
                    }
                });
        // Clear the above LinkedHashMap
        // using clear() method
        dico.clear();
  
        // Iterating over elements using for each loop
        for (Map.Entry<String, Integer> entry : list) {
  
            // Put all sorted value back to the
            // LinkedHashMap
            dico.put(entry.getKey(), entry.getValue());
        }
        return dico;
  
    }

    public static void FichierFreq(LinkedHashMap<String, Integer> dico, String nomFichier) {
        int somme = 0; 

        // Iterating over elements using for each loop
        for (Map.Entry<String, Integer> entry : dico.entrySet()) {
            somme = somme + entry.getValue();
        }
        System.out.println("Nombre total de caractère :" + somme );
        String fileName = nomFichier +"_freq.txt";

        try {
            // Créer un flux de sortie vers le fichier binaire
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream dos = new DataOutputStream(fos);

            // Écrire des données dans le fichier binaire
            dos.writeUTF(String.valueOf(somme));
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
