package com.jeudecartes.demo.dto;

public class Carte{
	
	private String couleur;
	private int valeur;
	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}
	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	@Override
	public String toString() {
		return "Carte [couleur=" + couleur + ", valeur=" + valeur + "]";
	}
	

	

}
