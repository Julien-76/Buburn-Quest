package be.julburn.persoprojects.buburnquest;
import java.io.IOException;

public class Demon{

	public int pv, force;
	public boolean etat;


	public void setStats(){
		String taille;
		this.etat = true;
		float proba = (float)Math.random();
		if (proba < 0.5){
			this.pv = 34;
			this.force = 8;
			taille = "petit";
		} else {
			this.pv = 60;
			this.force = 12;
			taille = "grand";
		}
		System.out.println("C'est un " + taille + " démon ");
	}

	public int getForce(){
		return this.force;
	}

	public int getForceFighting(){
		int forceCoup, diff;
		if (this.getForce() == 8) {
			diff = 4;
		}else {
			diff = 6;
		}
		forceCoup = ((int)(2 * diff * (float)Math.random() +1)) + this.force - diff;
		return forceCoup;
	}

	public int getPv(){
		return this.pv;
	}
}