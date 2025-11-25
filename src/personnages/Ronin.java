package personnages;

public class Ronin extends Humain {
	private int honneur=1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = (getArgent()*10)/100;
		parler("Marco, prend ces " + don + " sous");
		perdreArgent(don);
		beneficiaire.recevoir(don);
	}
}
