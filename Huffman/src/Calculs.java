import java.io.File;
import java.util.ArrayList;

public class Calculs {
    private String nomFichier;
    private ArrayList<String> caractere;  

    //Getters et Setters
    

    public Calculs(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public ArrayList<String> getCaractere() {
        return caractere;
    }

    public void setCaractere(ArrayList<String> caractere) {
        this.caractere = caractere;
    }

    public Calculs(ArrayList<String> caractere) {
        this.caractere = caractere;
    }

    
    public Calculs(String nomFichier, ArrayList<String> caractere) {
        this.nomFichier = nomFichier;
        this.caractere = caractere;
    }

    public double Compression() {
        // Créer un objet File en utilisant le chemin du fichier
        File file = new File(nomFichier + "_comp.bin");
        File texte = new File(nomFichier + ".txt");
        File freq = new File(nomFichier + "_freq.txt");

        // Vérifier si le fichier existe
        if(file.exists()) {
            // Obtenir la taille du fichier en octets
            double fileSize = file.length();
            
            
            double texteSize = texte.length(); 
            System.out.println("texte :" + texteSize); 
            double taillefreq = freq.length();
            System.out.println("compressé : " + fileSize);

            return 1-((fileSize+taillefreq)/texteSize); 
        
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
