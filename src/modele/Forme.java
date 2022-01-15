package modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Forme implements Dessinable{
	//Attributs
	protected int largeur;
	protected int hauteur;
	protected Point origine;
	private Color couleurDeTrait;
	//Constructeur
	Forme(Point origine, int largeur, int hauteur){
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.origine = origine;
		this.couleurDeTrait = Color.BLACK;
	}
	//Méthodes
	public abstract Point getOrigine();
	public abstract int getX();
	public abstract int getY();
	public abstract void setOrigine(Point newOrigine);
	public abstract int getHauteur();
	public abstract int getLargeur();
	public abstract void setHauteur(int newHauteur);
	public abstract void setLargeur(int newLargeur);
	public abstract void dessiner(Graphics graphique);
	//public abstract Color getCouleurDeTrait();
	//public abstract void setCouleurDeTrait(Color couleurDeTrait);
}
