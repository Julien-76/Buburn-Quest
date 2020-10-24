package be.julburn.persoprojects.buburnquest;

import java.io.IOException;
import java.util.Scanner;

public class Coffre {

    int valeur;
    boolean etat = false;
    String taille;

    public void setStats(){
        float probEtat = (float)Math.random();
        if (probEtat < 0.5) {
            this.etat = true;
            float probTaille = (float) Math.random();
            if (probTaille < 0.5) {
                this.taille = "petit";
            }
            else {
                this.taille = "gros";
            }
            float probStatut = (float)Math.random();
            if (probStatut < 0.5 && this.taille.equals("petit")){
                this.valeur = -7;
            }
            else if (probStatut < 0.5 && this.taille.equals("gros")) {
                this.valeur = -13;
            }
                else if (probStatut >= 0.5 && this.taille.equals("petit")){
                    this.valeur = 5;
                }
                else {
                    this.valeur = 15;
            }
        }
    }

    public void choixCoffre(Heros geralt) throws IOException {
        System.out.println("Tu trouves un coffre...");
        System.in.read();
        System.out.println("C'est peut être un trésor, mais c'est peut être aussi un piège...");
        System.in.read();
        System.out.println("Que fais-tu ?\n1. Je l'ouvre ! ! !\n2. Je suis prudent, je n'y touche pas");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        while (choix != 1 && choix != 2){
            System.out.println("Choix incorrect\n");
            System.in.read();
            System.out.println("Que fais-tu ?\n1. Je l'ouvre ! ! !\n2. Je suis prudent, je n'y touche pas");
            choix = sc.nextInt();
        }
        if (choix == 1){
            System.out.println("\nTu n'as pas peur et tu ouvres le coffre...");
            System.in.read();
            this.ouvertureCoffre(geralt);
        }
        else {
            System.out.println("\nTu as raison d'être prudent. Tu passes à coté du coffre....");
            System.in.read();
        }
    }

    public void ouvertureCoffre(Heros geralt) throws IOException {
        if (this.getValeur() < 0){
            System.out.println("Mon Dieu, c'est un piège ! !");
            System.in.read();
            System.out.println("\nUn " + this.getTaille() + " piège...\nPV : " + this.getValeur());
            geralt.pv = geralt.pv + this.getValeur();
            System.in.read();
        }
        else {
            System.out.println("C'est un trésor ! !");
            System.in.read();
            System.out.println("Un " + this.getTaille() + " trésor...\nTu récupères " + this.getValeur() + " PV");
            geralt.pv = geralt.pv + this.getValeur();
            System.in.read();
        }
    }

    public String getTaille(){
        return this.taille;
    }

    public int getValeur(){
        return this.valeur;
    }
}
