package controleur;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Point;

import modele.*;
import vue.PanneauDessin;

public class GestionSouris implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener{
	//Attributs
	private PanneauDessin monPanneau;
	private int x1, y1, x2, y2, x3 , y3;
	//Constructeur
	public GestionSouris(PanneauDessin panneau){
		this.monPanneau = panneau;
	}
	//Méthodes
	PanneauDessin getPanneauDessin() {
		return this.monPanneau;
	}
	void dessinerElastique(int x1, int y1, int x2, int y2) {
		int xSup, ySup, xInf, yInf;
		if(x1>x2){
		xSup = x1; xInf = x2;
		} else {
		xSup = x2; xInf = x1;
		}
		if(y1>y2){
		ySup = y1;
		yInf = y2;
		} else {
		ySup = y2;
		yInf = y1;
		}
		Graphics gc = this.monPanneau.getGraphics();
		gc.setXORMode(this.monPanneau.getBackground());
		gc.drawRect(xInf,yInf,xSup-xInf,ySup-yInf);
	}
	//Souris
	public void mouseClicked(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {
		//Lorsque la souris rentre sur une zone d'écran
	}
	public void mouseExited(MouseEvent e) {
		//lorsque la souris quitte une zone où se trouve le composant
	}
	public void mousePressed(MouseEvent e) {
		this.x1 = e.getX();
		this.y1 = e.getY();
		this.x2 = x1;
		this.y2 = y1;
	}
	public void mouseReleased(MouseEvent e) {
		//On calcule hauteur et largeur
		boolean negative = false;
		boolean fill = false;
		if(this.x2>this.x1){
			this.x3 = this.x2-this.x1;
		}
		else if(x2<x1){
			this.x3 = x1-x2;
			negative = true;
		}
		if(this.y2>this.y1) {
			this.y3 = this.y2-this.y1;
		}
		else if(x2>x1){
			this.y3 = y1-y2;
			negative = true;
		}
		// on dessine une derni`ere fois l’´elastique:
		//dessinerElastique(this.x1,this.y1,this.x2,this.y2);
		// on r´ecup`ere le bouton s´electionn´:
		String boutonSelectionne = this.monPanneau.getFenetre().getPanneauBoutons().getMonControleur().choix();
		String remplissage = this.monPanneau.getFenetre().getPanneauBoutons().getGestionCouleur().choix();
		if(remplissage.equals("Filled"))
			fill = true;
		else
			fill = false;
		// on cr´ee la forme:
		Forme nouvelleForme = new Carre(new Point(this.x1,this.y1),this.x3,false); //init
		if(!negative)
		{
			if(boutonSelectionne.equals("Rectangle")){
				nouvelleForme = new Rectangle(new Point(this.x1,this.y1),this.x3,y3,fill);
			}
			else if(boutonSelectionne.equals("Carre")){
				nouvelleForme = new Carre(new Point(this.x1,this.y1),this.x3,fill);
			}
			else if(boutonSelectionne.equals("Ellipse")) {
				nouvelleForme = new Ellipse(new Point(this.x1,this.y1),this.x3,this.y3,fill);
			}
			else if(boutonSelectionne.equals("Cercle")) {
				nouvelleForme = new Cercle(new Point(this.x1,this.y1),this.x3,fill);
			}
			else if(boutonSelectionne.equals("Ligne")) {
				nouvelleForme = new Ligne(new Point(this.x1,this.y1),e.getX(),e.getY());
			}
		}
		else 
		{
			if(boutonSelectionne.equals("Rectangle")){
				nouvelleForme = new Rectangle(new Point(this.x2,this.y2),this.x3,y3,fill); //Petit bug
			}
			else if(boutonSelectionne.equals("Carre")){
				nouvelleForme = new Carre(new Point(this.x2,this.y2),this.x3,fill);
			}
			else if(boutonSelectionne.equals("Ellipse")) {
				nouvelleForme = new Ellipse(new Point(this.x2,this.y2),this.x3,this.y3,fill);
			}
			else if(boutonSelectionne.equals("Cercle")) {
				nouvelleForme = new Cercle(new Point(this.x2,this.y2),this.x3,fill);
			}
			else if(boutonSelectionne.equals("Ligne")) {
				nouvelleForme = new Ligne(new Point(this.x1,this.y1),e.getX(),e.getY());
			}
		}
		
		// on ajoute la forme au panneau dessin:
		this.monPanneau.ajouterForme(nouvelleForme);
		// et on redessine le panneau dessin:
		this.monPanneau.repaint();
	}
	public void mouseDragged(MouseEvent e){
		dessinerElastique(this.x1,this.y1,this.x2,this.y2);
		this.x2 = e.getX();
		this.y2 = e.getY();
		dessinerElastique(this.x1,this.y1,this.x2,this.y2);
	}
	public void mouseMoved(MouseEvent e) {
		
	}
}
