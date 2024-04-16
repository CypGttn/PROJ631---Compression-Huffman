import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureFichier {

    public static String LireFichier(String cheminFichier) {
        StringBuilder contenu = new StringBuilder();
        try {
            File fichier = new File(cheminFichier);
            Scanner scanner = new Scanner(fichier);
            while (scanner.hasNextLine()) {
                contenu.append(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contenu.toString();
    }

    
    
}
    
