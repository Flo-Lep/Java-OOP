package modele;

import java.awt.Point;

public class Cercle extends Ellipse{
	public Cercle(Point origine, int diametre, boolean newPlein){
		super(origine,diametre,diametre,newPlein);
	}
}
