package modele;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Forme{
	protected boolean plein;
	public Rectangle(Point origine, int largeur, int hauteur, boolean newPlein){
		super(origine, largeur, hauteur);
		this.plein = newPlein;
	}
	public Point getOrigine() {
		return super.origine;
	}
	public int getX() {
		return super.origine.x;
	}
	public int getY() {
		return super.origine.y;
	}
	public void setOrigine(Point newOrigine) {
		super.origine = newOrigine;
	}
	public int getHauteur() {
		return super.hauteur;
	}
	public int getLargeur() {
		return super.largeur;
	}
	public void setHauteur(int newHauteur) {
		super.hauteur = newHauteur;
	}
	public void setLargeur(int newLargeur) {
		super.largeur = newLargeur;
	}
	public void dessiner(Graphics graphique) {
		if(plein)
			graphique.fillRect(getX(), getY(), super.largeur, super.hauteur);
		else
			graphique.drawRect(getX(), getY(), super.largeur, super.hauteur);
	}
}
