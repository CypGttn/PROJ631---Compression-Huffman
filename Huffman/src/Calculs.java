import java.io.File;
import java.util.ArrayList;

public class Calculs {
    private String nomFichier;
    private ArrayList<String> fichiers;  

    public Calculs(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Calculs(ArrayList<String> fichiers) {
        this.fichiers = fichiers;
    }

    public double Compression() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");
        File texte = new File(nomFichier + ".txt");

        // Vérifier si le fichier existe
        if(file.exists()) {
            // Obtenir la taille du fichier en octets
            double fileSize = file.length();
            double texteSize = texte.length(); 

            return 1-fileSize/texteSize; 
        
        } else {
            return 0; 
        }
        
    }

    public double TauxMoyen() {
        double taux = 0;
        double nbElement = 0; 

        for(int i = 0; i<fichiers.size();i++){
            Calculs fichier = new Calculs(fichiers.get(i));
            taux = taux + fichier.Compression();
            nbElement ++;

        }
        return taux/nbElement; 
    }
}
