import java.io.File;

public class Calculs {
    private String nomFichier; 

    public Calculs(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public double Compression() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");
        File texte = new File(nomFichier + ".txt");

        // Vérifier si le fichier existe
        if(file.exists()) {
            // Obtenir la taille du fichier en octets
            long fileSize = file.length();
            long texteSize = texte.length(); 

            return 1 - fileSize/texteSize; 
        
        } else {
            return 0; 
        }
        
    }
}
