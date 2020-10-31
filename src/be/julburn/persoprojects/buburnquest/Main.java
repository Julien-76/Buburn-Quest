package be.julburn.persoprojects.buburnquest;
import java.util.Scanner;
import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException {

        boolean combat;
        Heros julburn = new Heros();
        julburn.setNom();
        julburn.setStats();
        julburn.afficheHeros();
        for (int cpt = 0; cpt < 10; cpt++)
            System.out.println("\n");
        julburn.intro();
        for (int cpt = 0; cpt < 5; cpt++)
            System.out.println("\n");
        for(int cpt = 0; cpt < 7; cpt++) {             // Début des tours
            if (julburn.etat) {
                julburn.avancement(cpt);
                julburn.setDirection();
                combat = julburn.getCombat();
                if (combat) {
                    julburn.fighting(julburn);
                }
                if (julburn.getEtat()) {
                    julburn.setCoffre(julburn);
                }
            }
        }
        if (julburn.getEtat()) {
            julburn.sortie();
        }
        System.out.println("\n\n\t\t\t_________\n\t\t\t|THE END|\n\t\t\t---------");
    }
}
		
	

