package controleur;



public class GestionBoutons extends java.awt.CheckboxGroup{
	public GestionBoutons(){
		super();
	}
	public String choix() {
		return super.getSelectedCheckbox().getLabel();
	}
}
