package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import controleur.GestionSouris;

import java.util.ArrayList;
import modele.Forme;
import modele.*;

public class PanneauDessin extends javax.swing.JPanel{
	protected Color couleurDeFond; 
	protected List<Forme> listeDeFormes;
	protected Fenetre maFenetre;
	protected Dimension maDimension;
	private GestionSouris monControleur;
	public PanneauDessin(Fenetre maFenetre, Dimension dimension, Color couleurFond){
		super();
		this.maFenetre = maFenetre;
		this.couleurDeFond = couleurFond;
		this.maDimension = dimension;
		this.listeDeFormes = new ArrayList<Forme>();
		super.setPreferredSize(dimension);
		super.setBackground(couleurFond);
		this.monControleur = new GestionSouris(this);
        this.addMouseListener(this.monControleur);
        this.addMouseMotionListener(this.monControleur);
	}
	public Color getCouleurFond() {
		return this.couleurDeFond;
	}
	public Dimension getDimension() {
		return this.maDimension;
	}
	public void ajouterForme(Forme nouvelleForme) {
		this.listeDeFormes.add(nouvelleForme);
	}
	public List<Forme> getListeForme(){
		return this.listeDeFormes;
	}
	public Fenetre getFenetre() {
		return this.maFenetre;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Forme f : getListeForme()) {
			f.dessiner(g);
		}
		g.dispose();
	}
}
