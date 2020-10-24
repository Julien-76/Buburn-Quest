package be.julburn.persoprojects.buburnquest;
import java.util.Scanner;
import java.io.IOException;

public class Heros {
		public int pv, force;
		public String nom;
		public Boolean etat, hCombat = false;

	public void intro() throws IOException {
		System.out.println("Tu entres dans un donjon habité par des démons\n\ntu vas devoir arriver jusqu'au bout vivant ! ");
		System.in.read();
	}

	public void setNom(){
		Scanner sc = new Scanner(System.in);
		for(int cpt = 0; cpt < 5; cpt++)
			System.out.println("\n");
		System.out.println("Quel nom veux-tu donner à ton Héros ?");
		this.nom = sc.nextLine();
	}

	public void setStats(){
		int choix;
		this.etat = true;
				Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\nChoisi une classe pour ton Héros :\n1. Bourrin\n2. Rodeur");
		choix = sc.nextInt();
		while (choix != 1 && choix != 2){
			System.out.println("\nChoix incorrect");
			System.out.println("\nChoisi une classe pour ton Héros :\n1. Bourrin\n2. Rodeur");
			choix = sc.nextInt();
		}
		if (choix == 1){
			this.pv = 100;
			this.force = 20;
		} else {
			this.pv = 75;
			this.force = 30;
		}
	}

	public void afficheHeros() throws IOException {
		System.out.println("\n\n\n\n\n\nVoici ton Héros");
		System.in.read();
		System.out.println("\n" + this.getNom() + "\nPV : " + this.getPv() + "\nForce : " + this.getForce());
		if (this.force == 30){
			System.out.println("Chances de Coup Critique : 15%");
		}
		System.in.read();
	}

	public void avancement(int cpt) throws IOException {
		if (cpt == 6){
			System.out.println("Tu sens que la fin du donjon est à quelques mètres !");
			System.in.read();
		}
		if (cpt == 5){
			System.out.println("Tu commences à voir des lueurs de lumière, tu n'es plus loin de la sortie !");
			System.in.read();
		}
		if (cpt == 3){
			System.out.println("Tu pense avoir trouvé une piste qui te mènerait à la sortie");
			System.in.read();
		}
		if (cpt == 1){
			System.out.println("Toujours aucune trace de la sortie, tu avances aveuglement...");
			System.in.read();
		}
	}

	public String getNom(){
	    return this.nom;
	}

	public int getPv(){
	    return this.pv;
	}

	public int getForce(){
	    return this.force;
	}

	public boolean getEtat(){
	    return this.etat;
	}


	public void setDirection()throws IOException{
			int a, b;
			System.out.println("Par où aller ?\n1. Tout droit\n2. Gauche\n3. Droite");
			a = (int)((3*((float)Math.random()))+1);
			Scanner sc = new Scanner(System.in);
			b = sc.nextInt();
			while (b != 1 && b != 2 && b != 3){
				System.out.println("\n\n\n -----> CHOIX INCORRECT <-----");
				System.in.read();
				System.out.println("Par où aller ?\n1. Tout droit\n2. Gauche\n3. Droite");
				b = sc.nextInt();
			}
			if (b == a){
				System.out.println("\n\nPas de démon en vue... tu continues à avancer...");
				System.in.read();
                System.out.println("Tu en profites pour récuperer un peu...\nPV de " + this.getNom() + " : " + this.getPv() + " + 5");
                this.pv = this.getPv() + 5;
				this.hCombat = false;
			} else {
				System.out.println("\n\nUn démon surgit devant toi ! !");
				this.hCombat = true;
				System.in.read();
			}
		}
	public boolean getCombat(){
	    return this.hCombat;
	}

	public void fighting(Heros jules) throws IOException{
		Combat fight = new Combat();
		Demon grougrou = new Demon();
		grougrou.setStats();
		while (this.getPv() > 0 && grougrou.getPv() > 0) {
			fight.setInitiative(jules, grougrou);
		}
		fight.finCombat(jules, grougrou);
	}

	public void setCoffre(Heros julburn) throws IOException {
		System.in.read();
		System.out.println("Tu continues ton chemin...");
		System.in.read();
		Coffre mimic = new Coffre();
		mimic.setStats();
		if (mimic.etat){
			mimic.choixCoffre(julburn);
		}
	}

	public void sortie() throws IOException {
		System.out.println("Voilà la sortie !");
		System.in.read();
		System.out.println("Bien joué " + this.getNom() + " ! ! ");
		System.in.read();
	}
}