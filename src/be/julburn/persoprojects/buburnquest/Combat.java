package be.julburn.persoprojects.buburnquest;
import java.io.IOException;
import java.util.Scanner;

public class Combat {

    public void setInitiative(Heros geralt, Demon eredin) throws IOException {
    int choixHeros;
    float choixDemon;
    this.afficheStats(geralt, eredin);
    System.in.read();
    System.out.println("\nQue fais-tu ?\n1. Attaquer\n2. Défendre");
    Scanner sc = new Scanner(System.in);
    choixHeros = sc.nextInt();
    while (choixHeros != 1 && choixHeros != 2){
        System.out.println("Choix incorrect\n");
        System.in.read();
        System.out.println("Que fais-tu ?\n1. Attaquer\n2. Défendre");
        choixHeros = sc.nextInt();
    }
    choixDemon = (float)Math.random();
    if (choixHeros == 1){
        System.out.println("\nTu attaques le Démon ! !");
        if (choixDemon < 0.5){
            System.in.read();
            System.out.println("mais le Démon esquive et contre-attaque...");
            this.attaqueDemon(geralt, eredin);
        }
        else {
            this.attaqueHeros(geralt, eredin);
        }
    } else {
        System.out.println("\nTu joues la défense");
        System.in.read();
        if (choixDemon < 0.5){
            System.out.println("Le Démon attaque mais ta défense le bloque");
            System.in.read();
            System.out.println("Tu le frappes après l'avoir bloqué");
            this.attaqueHeros(geralt, eredin);
        } else {
            System.out.println("mais le Démon te surprend quand tu ne l'attendais pas");
            this.attaqueDemon(geralt, eredin);
        }
    }

    }

    public void attaqueDemon(Heros geralt, Demon eredin) throws IOException{

        System.in.read();
        float proba = (float)Math.random();
        if (proba <0.2){
            System.out.println("Mais il ne te touche pas...");
        }
        else {
            System.out.println("Il te blesse !");
            geralt.pv = geralt.getPv() - eredin.getForce();
        }
    }

    public void attaqueHeros(Heros geralt, Demon eredin) throws IOException{

        System.in.read();
        float proba = (float)Math.random();
        if (proba < 0.2){
            System.out.println("mais tu ne le touches malheureuseument pas");
        }
        else {
            System.out.println("Tu le blesses");
            float cc = (float)Math.random();
            if (cc < 0.15 && geralt.getForce() == 30){
                System.in.read();
                System.out.println("Coup Critique !");
                eredin.pv = eredin.getPv() - 6;
            }
            eredin.pv = eredin.getPv() - geralt.getForce();
        }

    }

    public void afficheStats(Heros geralt, Demon eredin) throws IOException{
        System.in.read();
        System.out.println("\nPV de " + geralt.getNom() + " : " + geralt.getPv());
        System.out.println("PV du Démon : " + eredin.getPv());
    }

    public void finCombat(Heros geralt, Demon eredin){
        if (eredin.getPv() <= 0) {
            System.out.println("\nLe Démon est mort");
            eredin.etat = false;
        }
        if (geralt.getPv() <= 0){
            System.out.println("\nTu es mort...");
            geralt.etat = false;
        }
    }
}
