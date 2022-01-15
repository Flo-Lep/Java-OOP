package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Fenetre extends javax.swing.JFrame{
	private PanneauDessin monPanneauDessin;
	private PanneauBoutons monPanneauBoutons;
	private String name;
	public Fenetre(String newName, Dimension newDim){
		super(newName);
		this.name = newName;
		this.monPanneauDessin = new PanneauDessin(this,newDim,Color.WHITE);
		this.monPanneauBoutons = new PanneauBoutons(this);
		super.add(this.monPanneauDessin,BorderLayout.CENTER);
		super.add(this.monPanneauBoutons,BorderLayout.EAST);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
		super.pack();
	}
	public PanneauDessin getPanneauDessin() {
		return this.monPanneauDessin;
	}
	public PanneauBoutons getPanneauBoutons() {
		return this.monPanneauBoutons;
	}

}
