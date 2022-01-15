package vue;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import controleur.GestionBoutons;

public class PanneauBoutons extends javax.swing.JPanel{
	private Fenetre maFenetre;
	private GestionBoutons monControleur;
	private GestionCouleur controleurCouleur;
	public PanneauBoutons(Fenetre maFenetre){
		super();
		super.setPreferredSize(new Dimension(100,100));
		this.maFenetre = maFenetre;
		//Formes
		this.monControleur = new GestionBoutons();
		setLayout(new GridLayout(7,1));
		createNewButton("Rectangle");
		createNewButton("Carre");
		createNewButton("Ellipse");
		createNewButton("Cercle");
		createNewButton("Ligne");
		//Remplissage
		this.controleurCouleur = new GestionCouleur(Color.BLACK);
		add(new Checkbox("Filled", this.controleurCouleur, true));
		add(new Checkbox("Empty", this.controleurCouleur, true));
		//Couleur
		//J'en ai marre
		super.setBackground(Color.LIGHT_GRAY);
	}
	public Fenetre getFenetre(){
		 return this.maFenetre;
	 }
	 void createNewButton(String name) {
		 add(new Checkbox(name, this.monControleur, true));
	 }
	 public GestionBoutons getMonControleur() {
		 return this.monControleur;
	 }
	 public GestionCouleur getGestionCouleur() {
		 return this.controleurCouleur;
	 }
}
