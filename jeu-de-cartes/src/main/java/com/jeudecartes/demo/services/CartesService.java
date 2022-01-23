package com.jeudecartes.demo.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.jeudecartes.demo.dto.Carte;

@Service
public class CartesService {
	
	public ArrayList<Carte> distribuerCartes() {
		ArrayList<Carte> carteList = new ArrayList<Carte>();
        
	    final String[] couleur = {"Carreau", "Coeur", "Pique", "Trefle"};
	    final int[] valeur = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	    
	    for (int i = 0; i < couleur.length; i++) {
	    	for (int j = 0; j < valeur.length; j++) {
	    		Carte carte = new Carte();
		    	carte.setCouleur(couleur[i]);
		    	carte.setValeur(valeur[j]);
		    	
		    	carteList.add(carte);
	    	}
	    }
	    
	    return carteList;
	}
	

	
	public ArrayList<Carte> trierCartes(ArrayList<Carte> cartesList) {
		
		cartesList.sort( (a,b) -> {
			return a.getValeur() - b.getValeur() ;
		});
		cartesList.sort( (a,b) -> {
			return a.getCouleur().compareTo(b.getCouleur()) ;
		});
		return cartesList;
		
	} 


}
