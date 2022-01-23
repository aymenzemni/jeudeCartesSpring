package com.jeudecartes.demo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jeudecartes.demo.controller.JeuDeCartesController;
import com.jeudecartes.demo.dto.Carte;

@SpringBootTest
class JeuDeCartesApplicationTests {

	@Autowired
	JeuDeCartesController jeuDeCartesController;
	
	@Test
	void lengthOfCartesList() {
		ArrayList<Carte> carteListResult = new ArrayList<Carte>();
		carteListResult = jeuDeCartesController.getCartes();
		Assert.assertEquals(10, carteListResult.size());
	}
	
	@Test
	void elementNonDoubleCartesList() {
		ArrayList<Carte> carteListResult = new ArrayList<Carte>();
		carteListResult = jeuDeCartesController.getCartes();
		for (int i = 0; i < carteListResult.size(); i++) {
			boolean result = CarteMoreThenOnceInArray(carteListResult, carteListResult.get(i));
			Assert.assertFalse(result);
		}
	}
	
	@Test
	void cartesListTriee() {
		ArrayList<Carte> carteListTrieeResult = new ArrayList<Carte>();
		ArrayList<Carte> carteListShuffledResult = new ArrayList<Carte>();
		
		ArrayList<Carte> carteListShuffledResult12 = new ArrayList<Carte>();

		carteListShuffledResult = jeuDeCartesController.getCartes();		
		carteListShuffledResult12.addAll(carteListShuffledResult);

		
		carteListTrieeResult = jeuDeCartesController.trierCartes(carteListShuffledResult12);		
		
		ArrayList<Integer> trieeList = cartesTrieeTab(carteListTrieeResult);
		
		boolean result = tabTree(trieeList);

		Assert.assertTrue(result);
		
	}
	
	@Test
	void cartesListNnTriee() {
		ArrayList<Carte> carteListShuffledResult = new ArrayList<Carte>();
		
		ArrayList<Carte> carteListShuffledResult12 = new ArrayList<Carte>();

		carteListShuffledResult = jeuDeCartesController.getCartes();		
		carteListShuffledResult12.addAll(carteListShuffledResult);
		
		ArrayList<Integer> cartesNnTriee = cartesTrieeTab(carteListShuffledResult12);
		
		boolean result = tabTree(cartesNnTriee);
		Assert.assertFalse(result);

	}
	
	  public static boolean CarteMoreThenOnceInArray(ArrayList<Carte> listCartes, Carte whichCarte) {
	        int numberCounter = 0;
	        for (Carte number : listCartes) {
	            if (number == whichCarte) {
	                numberCounter++;
	            }
	        }
	        if (numberCounter > 1) {
	            return true;
	        }
	        return false;
	    }

	  public static ArrayList<Integer> cartesTrieeTab(ArrayList<Carte> listCartes) {
		 		  
		  ArrayList<Integer> set = new ArrayList<Integer>();
		  listCartes.stream().forEach( cartes -> {
			  int keyVal11 = 0;
			  switch(cartes.getCouleur()){			   
		       case "Carreau" : 
		    	   keyVal11 = 0 + cartes.getValeur();
		           break;
		   
		       case "Coeur" :
		    	   keyVal11 = 13 + cartes.getValeur();
		           break;
		   
		       case "Pique" :
		    	   keyVal11 = 26 + cartes.getValeur();
		           break;
		       case "Trefle" :
		    	   keyVal11 = 39 + cartes.getValeur();
		           break;
		   }
		      set.add(keyVal11);

		  });     
	
		return set;
		
	  }
	  
	  public boolean tabTree(ArrayList<Integer> tabcartes) {
		  boolean sorted = true;
		  for (int i = 0; i < tabcartes.size() -1; i++) {
			  if (tabcartes.get(i) > tabcartes.get(i + 1)) {
				  sorted = false;
				  break;
			  }
		  }
		  
		  return sorted;
	  }
}
