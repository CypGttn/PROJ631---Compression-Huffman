import java.io.File;
import java.util.ArrayList;

public class Calculs {
    private String nomFichier;
    private ArrayList<String> caractere;  

    public Calculs(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public Calculs(ArrayList<String> caractere) {
        this.caractere = caractere;
    }

    public double Compression() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");
        File texte = new File(nomFichier + ".txt");

        // Vérifier si le fichier existe
        if(file.exists()) {
            // Obtenir la taille du fichier en octets
            double fileSize = file.length();
            System.out.println(fileSize);
            double texteSize = texte.length(); 
            System.out.println(texteSize); 

            return 1-(fileSize/texteSize); 
        
        } else {
            return 0; 
        }
        
    }

    //Taux Moyen de compression de plusieurs fichiers
    public double TauxMoyen() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");
        

        double taux=1.0;
		double res= file.length();

		taux=res/caractere.size();
		
		return taux;

    }
}
