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
	
	public void provoquer(Yakuza adversaire) {
		int forceR = 2*honneur;
		int forceY = adversaire.getReputation();
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if (forceR>=forceY) {
			parler("Je t’ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			honneur=honneur+1;
		} else {
			int perte = getArgent();
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup");
			perdreArgent(perte);
			adversaire.gagner(perte);
			honneur=honneur-1;
		}
	}
}
