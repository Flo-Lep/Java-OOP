package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

public class GestionCouleur extends java.awt.CheckboxGroup implements java.awt.event.ActionListener{
	//Attributs
	private Color couleurParDefaut;
	private Color couleurChoisie;
	GestionCouleur(Color couleurParDefaut){
		super();
		this.couleurParDefaut = couleurParDefaut;
		this.couleurChoisie = couleurParDefaut;
	}
	public String choix() {
		return super.getSelectedCheckbox().getLabel();
	}
	public void actionPerformed(ActionEvent e) {
		Color c = JColorChooser.showDialog(null, "Choisissez la couleur", Color.BLACK);
	}
	public Color getCouleurChoisie() {
		return this.couleurChoisie;
	}
}
