package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissance;
	protected Humain[] memoire = new Humain[30];
	
	public Humain(String nom, String boisson, int argent) {
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + this.nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boisson);
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix>argent) {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offir un.e " + bien + " à " + prix + " sous.");
		} else {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offir un.e " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
	}
	
	protected void gagnerArgent(int gain) {
		this.argent = this.argent + gain;
	}
	
	protected void perdreArgent(int perte) {
		this.argent = this.argent - perte;
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	private void memoriser(Humain humain) {
		if (nbConnaissance==30) {
			for(int i=1; i<(nbConnaissance); i++) {
				memoire[i-1] = memoire[i];
			}
			memoire[nbConnaissance-1] = humain;
		} else {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		parler("Je connais beaucoup de monde dont: ");
		for(int i=0; i<nbConnaissance; i++) {
			System.out.print(memoire[i].getNom() );
			if (i+1<nbConnaissance)
				System.out.print(", ");
		}
		System.out.println();
	}
}
