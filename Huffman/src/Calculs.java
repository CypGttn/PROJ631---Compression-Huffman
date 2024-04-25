import java.io.File;

public class Calculs {
    private String nomFichier; 
    
    public Calculs(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public void Compression() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");

        // Vérifier si le fichier existe
        if(file.exists()) {
            // Obtenir la taille du fichier en octets
            long fileSize = file.length();
            
            // Afficher la taille du fichier
            System.out.println("La taille du fichier est : " + fileSize + " octets");
        } else {
            System.out.println("Le fichier n'existe pas.");
        }

    }
}
